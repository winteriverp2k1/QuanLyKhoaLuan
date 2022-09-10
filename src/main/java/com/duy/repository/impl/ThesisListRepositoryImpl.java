/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.repository.impl;

import com.duy.pojo.CouncilPosition;
import com.duy.pojo.Faculty;
import com.duy.pojo.Positionforthesis;
import com.duy.pojo.Thesis;
import com.duy.pojo.ThesisPosition;
import com.duy.pojo.User;
import com.duy.repository.ThesisListRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
@PropertySource("classpath:messages.properties")
public class ThesisListRepositoryImpl implements ThesisListRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;

    @Override
    public List<Thesis> getThesis(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Thesis> q = b.createQuery(Thesis.class);

        Root root = q.from(Thesis.class);
        q = q.select(root);

        if (kw != null) {
            Predicate p = b.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            q = q.where(p);
        }

        Query query = session.createQuery(q);

        int size = Integer.parseInt(env.getProperty("page.size").toString());
        int start = (page - 1) * size;
        query.setFirstResult(start);
        query.setMaxResults(size);

        return query.getResultList();
    }

    @Override
    public boolean addThesis(Thesis thesis) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(thesis);
            return true;
        } catch (Exception ex) {
            System.err.println("==ADD Thesis failed==" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<ThesisPosition> getThesisPos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addThesisPos(ThesisPosition thesisPos) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(thesisPos);
            return true;
        } catch (Exception ex) {
            System.err.println("==ADD thesisPos ERROR==" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Thesis getThesisById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Thesis.class, id);
    }

    @Override
    public boolean checkThesisName(String name) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Thesis> q = b.createQuery(Thesis.class);

        Root<Thesis> root = q.from(Thesis.class);
        CriteriaQuery query = q.select(root);
        query.where(b.equal(b.upper(root.get("name").as(String.class)),
                name.toUpperCase()));

        return session.createQuery(query).getSingleResult() == null;
    }

    @Override
    public List<Object[]> getThesisPos(int thesis_id, int thesis_pos) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<ThesisPosition> tp = b.createQuery(ThesisPosition.class);

        Root<ThesisPosition> root = tp.from(ThesisPosition.class);

        List<Predicate> predicates = new ArrayList<>();

        Predicate p1 = b.equal(root.get("thesisId"), thesis_id);
        predicates.add(p1);
        Predicate p2 = b.equal(root.get("thesisPosition"), thesis_pos);
        predicates.add(p2);

        tp.where(predicates.toArray(new Predicate[]{}));
        Query query = session.createQuery(tp);
        return query.getResultList();
    }

    @Override
    public List<Positionforthesis> getPosThesis() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Positionforthesis");
        return q.getResultList();
    }

    @Override
    public int countThesis() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Thesis");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public List<ThesisPosition> getThesisByUserId(int userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<ThesisPosition> q = b.createQuery(ThesisPosition.class);

        Root rThesisPosition = q.from(ThesisPosition.class);

        q.where(b.equal(rThesisPosition.get("userId"), userId));

        Query query = session.createQuery(q);

        return query.getResultList();

    }

    @Override
    public List<Thesis> getThesisByCouncilId(int councilId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Thesis> q = b.createQuery(Thesis.class);

        Root rThesis = q.from(Thesis.class);

        q.where(b.equal(rThesis.get("councilId"), councilId));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<ThesisPosition> getThesisPositionByThesisId(int thesisid) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<ThesisPosition> q = b.createQuery(ThesisPosition.class);

        Root rThesisPosition = q.from(ThesisPosition.class);

        q.where(b.equal(rThesisPosition.get("thesisId"), thesisid));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean deleteThesis(int thesisId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Thesis thesis = session.get(Thesis.class, thesisId);
            session.delete(thesis);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Object[]> getIdByThesisId(int thesisId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Thesis> q = b.createQuery(Thesis.class);

        Root rThesis = q.from(ThesisPosition.class);

        q.where(b.equal(rThesis.get("id"), thesisId));

        q.multiselect(rThesis.get("id"));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<CouncilPosition> getIdCouncilPos(int thesisid) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<CouncilPosition> q = b.createQuery(CouncilPosition.class);

        Root<CouncilPosition> rCouncilPosition = q.from(CouncilPosition.class);
        Root<Thesis> rThesis = q.from(Thesis.class);

        q = q.where(b.equal(rThesis.get("id"), thesisid),
                b.equal(rThesis.get("councilId"), rCouncilPosition.get("councilId")));

        q.select(rCouncilPosition);
        q.distinct(true);

        Query query = session.createQuery(q);

        return query.getResultList();
    }
}

