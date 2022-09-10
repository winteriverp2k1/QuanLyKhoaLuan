/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.formatters;


import com.duy.pojo.Thesis;
import com.duy.pojo.ThesisPosition;
import com.duy.pojo.User;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
/**
 *
 * @author Admin
 */
public class ThesisFormatter implements Formatter<Thesis>{

   @Override
    public String print(Thesis t, Locale locale) {
        return  String.valueOf(t.getId());
    }

    @Override
    public Thesis parse(String ThesisId, Locale locale) throws ParseException {
        Thesis t = new Thesis();
        t.setId(Integer.parseInt(ThesisId));
        return t;
    }
    
}
