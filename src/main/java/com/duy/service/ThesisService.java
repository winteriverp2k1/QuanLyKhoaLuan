/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.service;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface ThesisService {

    List<Object[]> countThesisbyFaculty();

    List<Object[]> thesisPointbyYear(Integer year);

}
