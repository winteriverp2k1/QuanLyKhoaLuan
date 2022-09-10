/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.repository.impl;

import com.duy.pojo.Council;
import com.duy.pojo.User;
import com.duy.repository.CouncilRepository;
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

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class CouncilRepositoryImpl implements CouncilRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Council> getCouncil() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Council");
        return q.getResultList();
    }
}

