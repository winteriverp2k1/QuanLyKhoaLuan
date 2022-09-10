/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.repository;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface ThesisRepository {
   List<Object[]> countThesisbyFaculty();
   
   List<Object[]> thesisPointbyYear(Integer year);
}
