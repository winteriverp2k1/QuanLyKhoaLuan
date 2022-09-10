/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.controllers;

import com.duy.pojo.Score;
import com.duy.pojo.ScoreDetail;
import com.duy.service.CouncilListService;
import com.duy.service.ThesisListService;
import com.duy.service.UserService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/Teacher")
public class TeacherController {

    @Autowired
    private CouncilListService councilListService;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private ThesisListService thesisListService;

    @GetMapping("/Manager/{userId}")
    public String Manager(Model model, @PathVariable(value = "userId") int userId, HttpSession session) {
        model.addAttribute("councilPosition", this.councilListService.getCouncilByUserId(userId));
        model.addAttribute("thesisPosition", this.thesisListService.getThesisByUserId(userId));
        return "Teacher";
    }

    @GetMapping("/Council/{councilId}")
    public String ThesisByCouncil(Model model, @PathVariable(value = "councilId") int councilId, HttpSession session) {
        model.addAttribute("thesisbycouncil", this.thesisListService.getThesisByCouncilId(councilId));
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        return "ThesisByCouncil";
    }

    @GetMapping("/DetailThesis/{thesisId}")
    public String DetailThesis(Model model, @PathVariable(value = "thesisId") int thesisId) {
        model.addAttribute("detailthesis", this.thesisListService.getThesisPositionByThesisId(thesisId));
        return "detailThesis";
    }

    @GetMapping("/score/{thesisId}")
    public String Points(Model model, @PathVariable(value = "thesisId") int thesisId, HttpSession session) {
        model.addAttribute("score", new Score());
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute("idthesis", this.thesisListService.getIdByThesisId(thesisId));
        model.addAttribute("idcouncilpos", this.thesisListService.getIdCouncilPos(thesisId));
        return "AddScore";
    }

//    @PostMapping("/score/{userId}")
//    public String Points(Model model, @ModelAttribute(value = "score") Score score,@PathVariable(value = "userId") int userId, @RequestParam Map<String, Integer> params, HttpSession session){      
//        model.addAttribute("councilPos", this.userDetailsService.getCouncilPostionIdByUserId(userId));
//        model.addAttribute("currentUser", session.getAttribute("currentUser"));
//        if(this.councilListService.Score(score) == true){
//            return "redirect:/Teacher";
//        }
//        return "AddScore";
//    }
    @PostMapping("/score/{userId}")
    public String CreateBaseScore(Model model, @ModelAttribute(value = "score") Score score,@PathVariable(value = "userId") int userId, @RequestParam Map<String, Integer> params, HttpSession session,  BindingResult result){      
        if (!result.hasErrors()) {
            model.addAttribute("thisScore", this.councilListService.Score(score));
            return "redirect:/Teacher";
        }
        return "AddScore";
    }
    
    @GetMapping("/points")
    public String Points(Model model) {
        model.addAttribute("point", new ScoreDetail());
        return "checkPoint";
    }
//
//    @PostMapping("/points")
//    public String Points(Model model, @ModelAttribute(value = "point") ScoreDetail point) {
//        if (this.councilListService.Point(point) == true) {
//            return "redirect:/";
//        }
//        return "checkPoint";
//    }

}
