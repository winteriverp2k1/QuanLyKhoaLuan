/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.service;

import com.duy.pojo.Council;
import com.duy.pojo.CouncilPosition;
import com.duy.pojo.Score;
import com.duy.pojo.ScoreDetail;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CouncilListService {
    List<Council> getCouncils(String kw, int page);
    Council getCouncilById(int id);
    boolean addCouncil(Council council);
    boolean addCouncilPos(CouncilPosition councilPos);
    List<CouncilPosition> getCouncilPosition();
    int countCouncil();
    List<CouncilPosition> getCouncilByUserId(int userId);
    boolean Point(ScoreDetail detail);
    boolean Score(Score score);
    boolean deleteCouncil(int councilId);
    List<Object[]> getCouncilPos(int councilId, int councilPos);
   
}
