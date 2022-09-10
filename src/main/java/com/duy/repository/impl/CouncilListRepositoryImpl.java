/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.repository.impl;

import com.duy.pojo.Council;
import com.duy.pojo.CouncilPosition;
import com.duy.pojo.Score;
import com.duy.pojo.ScoreDetail;
import com.duy.pojo.Thesis;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.duy.repository.CouncilListRepository;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
@PropertySource("classpath:messages.properties")
public class CouncilListRepositoryImpl implements CouncilListRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;

    @Override
    public List<Council> getCouncils(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Council> q = b.createQuery(Council.class);

        Root root = q.from(Council.class);
        q = q.select(root);

        if (kw != null) {
            Predicate p = b.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            q = q.where(p);
        }

//        q = q.orderBy(b.desc(root.get("createdDate")));
        Query query = session.createQuery(q);

        int size = Integer.parseInt(env.getProperty("page.size").toString());
        int start = (page - 1) * size;
        query.setFirstResult(start);
        query.setMaxResults(size);

        return query.getResultList();
    }

    @Override
    public Council getCouncilById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Council.class, id);
    }

    @Override
    public boolean addCouncil(Council council) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            council.setActive(1);
            council.setCreatedDate(new Date());
            session.save(council);
            return true;
        } catch (Exception ex) {
            System.err.println("==ADD council failed==" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addCouncilPos(CouncilPosition councilPos) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(councilPos);
            return true;
        } catch (Exception ex) {
            System.err.println("==ADD thesisPos ERROR==" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<CouncilPosition> getCouncilPosition() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<CouncilPosition> q = b.createQuery(CouncilPosition.class);

        Root root = q.from(CouncilPosition.class);
        q = q.select(root);

        Query query = session.createQuery(q);

        return query.getResultList();

    }

    @Override
    public int countCouncil() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Council");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public List<CouncilPosition> getCouncilByUserId(int userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<CouncilPosition> q = b.createQuery(CouncilPosition.class);

        Root rCouncilPosition = q.from(CouncilPosition.class);

        q.where(b.equal(rCouncilPosition.get("userId"), userId));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean Point(ScoreDetail detail) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(detail);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Score(Score score) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(score);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCouncil(int councilId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Council council = session.get(Council.class, councilId);
            session.delete(council);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Object[]> getCouncilPos(int councilId, int councilPos) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<CouncilPosition> tp = b.createQuery(CouncilPosition.class);

        Root<CouncilPosition> root = tp.from(CouncilPosition.class);

        List<Predicate> predicates = new ArrayList<>();

        Predicate p1 = b.equal(root.get("councilId"), councilId);
        predicates.add(p1);
        Predicate p2 = b.equal(root.get("positionId"), councilPos);
        predicates.add(p2);

        tp.where(predicates.toArray(new Predicate[]{}));
        Query query = session.createQuery(tp);
        return query.getResultList();
    }

}
