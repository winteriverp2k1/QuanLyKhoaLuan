/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.service.impl;

import com.duy.repository.ThesisRepository;
import com.duy.service.ThesisService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ThesisServiceImpl implements ThesisService {

    @Autowired
    private ThesisRepository thesisRepository;

    @Override
    public List<Object[]> countThesisbyFaculty() {
        return this.thesisRepository.countThesisbyFaculty();
    }

    @Override
    public List<Object[]> thesisPointbyYear(Integer year) {
        return this.thesisRepository.thesisPointbyYear(year);
    }

}
