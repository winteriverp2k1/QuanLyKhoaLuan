/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.service.impl;

import com.duy.pojo.Council;
import com.duy.repository.CouncilRepository;
import com.duy.service.CouncilService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CouncilServiceImpl implements CouncilService{
    
    @Autowired
    private CouncilRepository councilRepository; 

    @Override
    public List<Council> getCouncil() {
        return this.councilRepository.getCouncil();
    }
    
}
