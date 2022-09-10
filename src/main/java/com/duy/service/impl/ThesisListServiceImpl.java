/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.service.impl;

import com.duy.pojo.CouncilPosition;
import com.duy.pojo.Positionforthesis;
import com.duy.pojo.Thesis;
import com.duy.pojo.ThesisPosition;
import com.duy.repository.ThesisListRepository;
import com.duy.service.ThesisListService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ThesisListServiceImpl implements ThesisListService {

    @Autowired
    private ThesisListRepository thesisListRepository;

    @Override
    public List<Thesis> getThesis(String kw, int page) {
        return this.thesisListRepository.getThesis(kw, page);
    }

    @Override
    public boolean addThesis(Thesis thesis) {
        return this.thesisListRepository.addThesis(thesis);
    }

    @Override
    public boolean addThesisPos(ThesisPosition thesisPos) {
        return this.thesisListRepository.addThesisPos(thesisPos);
    }

    @Override
    public Thesis getThesisById(int id) {
        return this.thesisListRepository.getThesisById(id);
    }

    @Override
    public boolean checkThesisName(String name) {
        return this.thesisListRepository.checkThesisName(name);
    }

    @Override
    public List<Object[]> getThesisPos(int thesis_id, int thesis_pos) {
        return this.thesisListRepository.getThesisPos(thesis_id, thesis_pos);
    }

    @Override
    public List<Positionforthesis> getPosThesis() {
        return this.thesisListRepository.getPosThesis();
    }

    @Override
    public int countThesis() {
        return this.thesisListRepository.countThesis();
    }

    @Override
    public List<ThesisPosition> getThesisByUserId(int userId) {
        return this.thesisListRepository.getThesisByUserId(userId);
    }

    @Override
    public List<Thesis> getThesisByCouncilId(int councilId) {
        return this.thesisListRepository.getThesisByCouncilId(councilId);
    }

    @Override
    public List<ThesisPosition> getThesisPositionByThesisId(int thesisid) {
        return this.thesisListRepository.getThesisPositionByThesisId(thesisid);
    }

    @Override
    public boolean deleteThesis(int thesisId) {
        return this.thesisListRepository.deleteThesis(thesisId);
    }

    @Override
    public List<Object[]> getIdByThesisId(int thesisId) {
        return this.thesisListRepository.getIdByThesisId(thesisId);
    }

    @Override
    public List<CouncilPosition> getIdCouncilPos(int thesisid) {
        return this.thesisListRepository.getIdCouncilPos(thesisid);
    }
}
