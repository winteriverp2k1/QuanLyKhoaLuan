/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.duy.pojo.CouncilPosition;
import com.duy.pojo.User;
import com.duy.repository.UserRepository;
import com.duy.service.UserService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public User getUserbyUsername(String username) {
        return this.userRepository.getUserbyUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String usernanme) throws UsernameNotFoundException {
        User a = this.getUserbyUsername(usernanme);

        if (a == null) {
            throw new UsernameNotFoundException("Ivalid username");
        }

        Set<GrantedAuthority> auth = new HashSet<>();

        auth.add(new SimpleGrantedAuthority(a.getUserRole().toString()));

        return new org.springframework.security.core.userdetails.User(a.getUsername(), a.getPassword(), auth);
    }

    @Override
    public boolean addUser(User user) {

        String pass = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(pass));
        Date date = java.sql.Date.valueOf(LocalDate.now());
        user.setCreatedDate(date);

        try {
            Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            user.setAvatar((String) r.get("secure_url"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return this.userRepository.addUser(user);
    }

    @Override
    public User getUserById(int userId) {
        return this.userRepository.getUserById(userId);
    }

    @Override
    public boolean deleteUser(int userId) {
        return this.userRepository.deleteUser(userId);
    }

    @Override
    public int countUser() {
        return this.userRepository.countUser();
    }

    @Override
    public List<User> getUsers(String kw, int page) {
        return this.userRepository.getUsers(kw, page);
    }

    @Override
    public List<Object[]> countUserByFacultyId() {
        return this.userRepository.countUserByFacultyId();
    }

    @Override
    public List<Object[]> countUserByThesis() {
        return this.userRepository.countUserByThesis();
    }

    @Override
    public boolean changePassword(int userId, String newPassword) {

//        String newpw = this.passwordEncoder.encode(newPassword);
//        
//        User u = this.userRepository.getUserById(userId);
//        
//        String oldpw = u.getPassword();
//        if(newpw == oldpw){
//            this.userRepository.changePassword(userId, newPassword);
//            return true;
//        }   
//        return false;
        this.userRepository.changePassword(userId, newPassword);
        return true;
    }

    @Override
    public boolean updatePassword(User user) {
        String pass = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(pass));
        return this.userRepository.updatePassword(user);
    }

    @Override
    public List<Object[]> totalStudent() {
        return this.userRepository.totalStudent();
    }

    @Override
    public boolean checkOldPassword(int userId, String oldpw) {
        return this.userRepository.checkOldPassword(userId, oldpw);
    }

    @Override
    public List<User> getStudents() {
        return this.userRepository.getStudents();
    }

    @Override
    public List<User> getTeachers() {
        return this.userRepository.getTeachers();
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.getAllUsers();
    }

    @Override
    public List<User> getTeachersByFacultyId(int id) {
        return this.userRepository.getTeachersByFacultyId(id);
    }

    @Override
    public List<User> getStudentsByFacultyId(int id) {
        return this.userRepository.getStudentsByFacultyId(id);
    }

    @Override
    public List<CouncilPosition> getCouncilPostionIdByUserId(int userId) {
        return this.userRepository.getCouncilPostionIdByUserId(userId);
    }

    @Override
    public long countStudentDoThesis(int thesisId) {
        return this.userRepository.countStudentDoThesis(thesisId);
    }

    @Override
    public long countTeacherDoThesis(int thesisId) {
        return this.userRepository.countTeacherDoThesis(thesisId);
    }

    @Override
    public long countTeacherInCouncil(int councilId) {
        return this.userRepository.countTeacherInCouncil(councilId);
    }

}
