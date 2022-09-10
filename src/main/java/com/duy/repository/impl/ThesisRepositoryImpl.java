/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.repository.impl;

import com.duy.pojo.Faculty;
import com.duy.pojo.Thesis;
import com.duy.repository.ThesisRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class ThesisRepositoryImpl implements ThesisRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> countThesisbyFaculty() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rThesis = q.from(Thesis.class);
        Root rFaculty = q.from(Faculty.class);

        q.where(b.equal(rThesis.get("facultyId"), rFaculty.get("id")));
        q.multiselect(rFaculty.get("id"), rFaculty.get("name"), b.count(rThesis.get("id")));
        q.groupBy(rFaculty.get("id"));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> thesisPointbyYear(Integer year) {

        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rThesis = q.from(Thesis.class);
        Root rFaculty = q.from(Faculty.class);

        q.where(b.equal(rThesis.get("facultyId"), rFaculty.get("id")));

        if (year != null) {
           q.where(b.equal(rThesis.get("facultyId"), rFaculty.get("id")),
                b.equal(rThesis.get("year"), year));
        }

        q.multiselect(rFaculty.get("name"), rThesis.get("name"), rThesis.get("totalScore"), rThesis.get("year"));

        q.groupBy(rFaculty.get("name"));

        Query query = session.createQuery(q);

        return query.getResultList();

    }

}
