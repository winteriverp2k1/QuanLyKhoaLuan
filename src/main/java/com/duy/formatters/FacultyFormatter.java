/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.formatters;

import com.duy.pojo.Faculty;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class FacultyFormatter implements Formatter<Faculty>{

    @Override
    public String print(Faculty t, Locale locale) {
        return  String.valueOf(t.getId());
    }

    @Override
    public Faculty parse(String FacultyId, Locale locale) throws ParseException {
        Faculty f = new Faculty();
        f.setId(Integer.parseInt(FacultyId));
        return f;
    }
    
}
