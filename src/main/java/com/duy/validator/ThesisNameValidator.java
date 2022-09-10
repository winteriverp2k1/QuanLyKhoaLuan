/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.validator;

import com.duy.pojo.Thesis;
import com.duy.service.ThesisListService;
import javax.persistence.NoResultException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author huynh
 */
public class ThesisNameValidator implements ConstraintValidator<ThesisName, String> {

    @Autowired
    private ThesisListService thesisListService;
    
    @Override
    public void initialize(ThesisName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value,
            ConstraintValidatorContext context) {
        try {
            return thesisListService.checkThesisName(value);
        } catch (NoResultException ex) {
            return false;
        }
    }

}
//
//@Component
//public class ThesisNameValidator implements Validator {
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Thesis.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Thesis thesis = (Thesis) target;
//       
//        // Máy tính xách tay trong CSDL hiện tại đang có id là 3
//        if (!"".equals(thesis.getName()))
//            errors.rejectValue("name", "thesis.name.notNullMsg");
//    }    
//}