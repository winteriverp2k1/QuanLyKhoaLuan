/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.repository;

import com.duy.pojo.User;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface AccountRepository {
    List<User> getAllAccount();
}
