/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.formatters;

import com.duy.pojo.Faculty;
import com.duy.pojo.User;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class UserFormatter implements Formatter<User>{

    @Override
    public String print(User u, Locale locale) {
        return  String.valueOf(u.getId());
    }

    @Override
    public User parse(String UserId, Locale locale) throws ParseException {
        User u = new User();
        u.setId(Integer.parseInt(UserId));
        return u;
    }
    
}
