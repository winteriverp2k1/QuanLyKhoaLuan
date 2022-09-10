/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.service;

import com.duy.pojo.CouncilPosition;
import com.duy.pojo.Positionforthesis;
import com.duy.pojo.Thesis;
import com.duy.pojo.ThesisPosition;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ThesisListService {

    List<Thesis> getThesis(String kw, int page);

    Thesis getThesisById(int id);

    boolean addThesis(Thesis thesis);

    boolean addThesisPos(ThesisPosition thesisPos);

    boolean checkThesisName(String name);

    List<Object[]> getThesisPos(int thesis_id, int thesis_pos);

    List<Positionforthesis> getPosThesis();

    int countThesis();

    List<ThesisPosition> getThesisByUserId(int userId);

    List<Thesis> getThesisByCouncilId(int councilId);

    List<ThesisPosition> getThesisPositionByThesisId(int thesisid);

    boolean deleteThesis(int thesisId);

    List<Object[]> getIdByThesisId(int thesisId);

    List<CouncilPosition> getIdCouncilPos(int thesisid);
}
