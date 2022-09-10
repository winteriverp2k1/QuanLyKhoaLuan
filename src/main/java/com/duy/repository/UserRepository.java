/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.repository;

import com.duy.pojo.User;
import com.duy.pojo.CouncilPosition;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface UserRepository {

    User getUserbyUsername(String username);

    List<User> getUsers(String kw, int page);
   
    User getUserById(int userId);

    boolean addUser(User user);    
    
    boolean deleteUser(int userId);
    
    int countUser();
    
    List<Object[]> countUserByFacultyId();
    
    List<Object[]> countUserByThesis();
    
    boolean changePassword(int userId, String newPassword);
    
    List<Float> percentage();
    
    boolean updatePassword(User user);
    
    List<Object[]> totalStudent();
    
    boolean checkOldPassword(int userId, String oldpw);
    
    List<User> getAllUsers();
    List<User> getStudents();
    List<User> getTeachers();
    List<User> getTeachersByFacultyId(int id);
    List<User> getStudentsByFacultyId(int id);
    List<CouncilPosition> getCouncilPostionIdByUserId(int userId);
    
    long countStudentDoThesis(int thesisId);
    long countTeacherDoThesis(int thesisId);
}
