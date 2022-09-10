/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.service.impl;

import com.duy.pojo.Council;
import com.duy.pojo.CouncilPosition;
import com.duy.pojo.Position;
import com.duy.pojo.ScoreDetail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.duy.repository.CouncilListRepository;
import com.duy.service.CouncilListService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CouncilListServiceImpl implements CouncilListService {

    @Autowired
    private CouncilListRepository councilListRepository;

    @Override
    public List<Council> getCouncils(String kw, int page) {
        return this.councilListRepository.getCouncils(kw, page);
    }

    @Override
    public Council getCouncilById(int id) {
        return this.councilListRepository.getCouncilById(id);
    }

    @Override
    public boolean addCouncil(Council council) {
        return this.councilListRepository.addCouncil(council);
    }

    @Override
    public boolean addCouncilPos(CouncilPosition councilPos) {
        return this.councilListRepository.addCouncilPos(councilPos);
    }

    @Override
    public List<CouncilPosition> getCouncilPosition() {
        return this.councilListRepository.getCouncilPosition();
    }

    @Override
    public int countCouncil() {
        return this.councilListRepository.countCouncil();
    }

    @Override
    public List<CouncilPosition> getCouncilByUserId(int userId) {
        return this.councilListRepository.getCouncilByUserId(userId);
    }

    @Override
    public boolean Point(ScoreDetail detail) {
        return this.councilListRepository.Point(detail);
    }

    @Override
    public boolean Score(com.duy.pojo.Score score) {
        return this.councilListRepository.Score(score);
    }

    @Override
    public boolean deleteCouncil(int councilId) {
        return this.councilListRepository.deleteCouncil(councilId);
    }

    @Override
    public List<Object[]> getCouncilPos(int councilId, int councilPos) {
        return this.councilListRepository.getCouncilPos(councilId, councilPos);
    }

    @Override
    public List<Position> getPosCouncil() {
        return this.councilListRepository.getPosCouncil();
    }

   

}
