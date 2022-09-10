/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.repository.impl;

import com.duy.pojo.CouncilPosition;
import com.duy.pojo.User;
import com.duy.pojo.Faculty;
import com.duy.pojo.Position;
import com.duy.pojo.Thesis;
import com.duy.pojo.ThesisPosition;
import com.duy.repository.UserRepository;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
@PropertySource("classpath:messages.properties")
public class UserRepositoyImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserbyUsername(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM User WHERE username=:username");

        q.setParameter("username", username);

        return (User) q.getSingleResult();
    }

    @Override
    public User getUserById(int userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(User.class, userId);
    }

    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(int userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            User p = session.get(User.class, userId);
            session.delete(p);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public int countUser() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM User");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public List<User> getUsers(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);

        Root root = q.from(User.class);
        q = q.select(root);

        if (kw != null) {
            Predicate p = b.like(root.get("username").as(String.class), String.format("%%%s%%", kw));
            q = q.where(p);
        }

        q = q.orderBy(b.desc(root.get("createdDate")));

        Query query = session.createQuery(q);

        int size = Integer.parseInt(env.getProperty("page.size").toString());
        int start = (page - 1) * size;
        query.setFirstResult(start);
        query.setMaxResults(size);

        return query.getResultList();
    }

    @Override
    public List<Object[]> countUserByFacultyId() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rUser = q.from(User.class);
        Root rFaculty = q.from(Faculty.class);

        q.where(b.equal(rUser.get("facultyId"), rFaculty.get("id")),
                b.equal(rUser.get("userRole"), "ROLE_SinhVien"));

        q.groupBy(rFaculty.get("id"));

        q.multiselect(rFaculty.get("id"), rFaculty.get("name"), b.count(rUser.get("id")));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> countUserByThesis() {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root<Thesis> rThesis = q.from(Thesis.class);
        Root<Faculty> rFaculty = q.from(Faculty.class);
        Root<ThesisPosition> rThesisPosition = q.from(ThesisPosition.class);

        List<Predicate> predicates = new ArrayList();

        Predicate P1 = b.equal(rFaculty.get("id"), rThesis.get("facultyId"));
        predicates.add(P1);
        Predicate P2 = b.equal(rThesisPosition.get("thesisId"), rThesis.get("id"));
        predicates.add(P2);
        Predicate P3 = b.equal(rThesisPosition.get("thesisPosition"), 2);
        predicates.add(P3);

        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(rFaculty.get("name"));

        q.multiselect(rFaculty.get("id"), rFaculty.get("name"), b.count(rThesisPosition.get("userId")));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean changePassword(int userId, String newPassword) {
        if (newPassword != null && !newPassword.isEmpty()) {
            Session session = sessionFactory.getObject().getCurrentSession();

            User u = session.get(User.class, userId);

            u.setPassword(this.passwordEncoder.encode(newPassword));

            session.update(u);

            return true;
        }
        return false;
    }

    @Override
    public List<Float> percentage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updatePassword(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.update(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Object[]> totalStudent() {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//
//        String stringQuery =  "SELECT Faculty.id, Faculty.name, count(distinct ThesisPosition.userId), count(distinct User.id)" +
//                "FROM Faculty" +
//                "INNER JOIN Thesis ON Thesis.facultyId = Faculty.id" +
//                "INNER JOIN User ON User.facultyId = Faculty.id AND User.userRole=:role" +
//                "INNER JOIN ThesisPosition ON Thesis.id = ThesisPosition.thesisId" +
//                "WHERE ThesisPosition.thesisPosition =:number" +
//                "GROUP BY Faculty.name" +
//                "SELECT Faculty.id, Faculty.name, count(DISTINCT ThesisPosition.userId), count(DISTINCT User.id)\n"
//                + "FROM Faculty \n"
//                + "INNER JOIN Thesis ON Thesis.facultyId = Faculty.id\n"
//                + "INNER JOIN User ON User.facultyId = Faculty.id AND User.userRole=:role\n"
//                + "INNER JOIN ThesisPosition ON Thesis.id = ThesisPosition.thesisId\n"
//                + "WHERE ThesisPosition.thesisPosition =:number \n"
//                + "GROUP BY Faculty.name";
//        Query query = session.createQuery(stringQuery);
//
//        query.setParameter("role", "ROLE_SinhVien");
//        query.setParameter("number", "2");
//
//        List<Object[]> res = query.getResultList();
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        q.distinct(true);

        Root<Thesis> rThesis = q.from(Thesis.class);
        Root<Faculty> rFaculty = q.from(Faculty.class);
        Root<User> rUser = q.from(User.class);
        Root<ThesisPosition> rThesisPosition = q.from(ThesisPosition.class);

        List<Predicate> predicates = new ArrayList();

        Predicate P1 = b.equal(rFaculty.get("id"), rThesis.get("facultyId"));
        predicates.add(P1);
        Predicate P2 = b.equal(rUser.get("facultyId"), rFaculty.get("id"));
        predicates.add(P2);
        Predicate P3 = b.equal(rUser.get("userRole"), "ROLE_SinhVien");
        predicates.add(P3);
//        Predicate P4 =  (Predicate) q.where(b.equal(rUser.get("facultyId"),rFaculty.get("id")),
//                b.equal(rUser.get("userRole"), "ROLE_SinhVien"));
//        predicates.add(P4);
//        Predicate P7 =  (Predicate) predicates.stream().filter((java.util.function.Predicate<? super Predicate>) P4);
//        predicates.add(P7);
        Predicate P5 = b.equal(rThesis.get("id"), rThesisPosition.get("thesisId"));
        predicates.add(P5);
        Predicate P6 = b.equal(rThesisPosition.get("thesisPosition"), 2);
        predicates.add(P6);

        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(rFaculty.get("name"));

//        q.distinct(true);
        q.multiselect(b.count((rThesisPosition.get("userId"))), b.count(rUser.get("id"))).distinct(true);

        Query query = session.createQuery(q);

        return query.getResultList();

    }

    @Override
    public boolean checkOldPassword(int userId, String oldpw) {

        String old = this.passwordEncoder.encode(oldpw);

        Session session = sessionFactory.getObject().getCurrentSession();

        User u = session.get(User.class, userId);

        String pwdb = u.getPassword();

        if (old.equals(pwdb)) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> getStudents() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);

        Root<User> root = q.from(User.class);
        q = q.select(root);
        q = q.where(b.equal(root.get("userRole"), "ROLE_SinhVien"));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<User> getStudentsByFacultyId(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);

        Root<User> root = q.from(User.class);
        q = q.select(root);
        q = q.where(b.equal(root.get("userRole"), "ROLE_SinhVien"),
                b.equal(root.get("facultyId"), id));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<User> getTeachers() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);

        Root<User> root = q.from(User.class);
        q = q.select(root);
        q = q.where(b.equal(root.get("userRole"), "ROLE_GiangVien"));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<User> getTeachersByFacultyId(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);

        Root<User> root = q.from(User.class);
        q = q.select(root);
        q = q.where(b.equal(root.get("userRole"), "ROLE_GiangVien"),
                b.equal(root.get("facultyId"), id));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);

        Root<User> root = q.from(User.class);
        q = q.select(root);

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<CouncilPosition> getCouncilPostionIdByUserId(int userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<CouncilPosition> q = b.createQuery(CouncilPosition.class);

        Root rCouncilPosition = q.from(CouncilPosition.class);

        q.where(b.equal(rCouncilPosition.get("userId"), userId));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public long countStudentDoThesis(int thesisId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root<ThesisPosition> Rtp = q.from(ThesisPosition.class);
        Root<User> Ruser = q.from(User.class);

        q.multiselect(b.count(Ruser.get("id")));

        List<Predicate> predicates = new ArrayList<>();

        Predicate P1 = b.equal(Rtp.get("userId"), Ruser.get("id"));
        predicates.add(P1);
        Predicate P2 = b.equal(Rtp.get("thesisId"), thesisId);
        predicates.add(P2);
        Predicate P3 = b.equal(Ruser.get("userRole"), "ROLE_SinhVien");
        predicates.add(P3);

        q.where(predicates.toArray(new Predicate[]{}));
        Query query = session.createQuery(q);
        Object result = query.getSingleResult();
        return (long) result;
    }

    @Override
    public long countTeacherDoThesis(int thesisId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root<ThesisPosition> Rtp = q.from(ThesisPosition.class);
        Root<User> Ruser = q.from(User.class);

        q.multiselect(b.count(Ruser.get("id")));

        List<Predicate> predicates = new ArrayList<>();

        Predicate P1 = b.equal(Rtp.get("userId"), Ruser.get("id"));
        predicates.add(P1);
        Predicate P2 = b.equal(Rtp.get("thesisId"), thesisId);
        predicates.add(P2);
        Predicate P3 = b.equal(Ruser.get("userRole"), "ROLE_GiangVien");
        predicates.add(P3);

        q.where(predicates.toArray(new Predicate[]{}));
        Query query = session.createQuery(q);
        Object result = query.getSingleResult();
        return (long) result;       
    }

    @Override
    public long countTeacherInCouncil(int councilId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root<CouncilPosition> Rp = q.from(CouncilPosition.class);
        

        q.multiselect(b.count(Rp.get("id")));

        List<Predicate> predicates = new ArrayList<>();
;
        Predicate P2 = b.equal(Rp.get("councilId"), councilId);
        predicates.add(P2);

        q.where(predicates.toArray(new Predicate[]{}));
        Query query = session.createQuery(q);
        Object result = query.getSingleResult();
        return (long) result;       
    }
}
