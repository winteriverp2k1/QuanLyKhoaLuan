    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.validator;

import com.duy.pojo.Faculty;
import com.duy.pojo.Thesis;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author huynh
 */
public class FacultyValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Thesis.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Thesis thesis = (Thesis) target;
       
        // Máy tính xách tay trong CSDL hiện tại đang có id là 3
        if (thesis.getFacultyId().equals("1"))
            errors.reject("Khong chon khoa cntt");
    }    
}

