/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.controllers;

import com.duy.pojo.Thesis;
import com.duy.pojo.ThesisPosition;
import com.duy.service.ThesisListService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author huynh
 */
@RestController
public class ApiThesisController {

    @Autowired
    private ThesisListService thesisListService;

    @GetMapping("/api/thesis")
    public ResponseEntity<List<Thesis>> getThesis() {
        return new ResponseEntity<>(this.thesisListService.getThesis(null,1), HttpStatus.OK);
    }

    @PostMapping("/{thesisId}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addThesis(HttpSession session,
            @PathVariable(value = "thesisId") int thesisId) {
        Thesis thesis = this.thesisListService.getThesisById(thesisId);
        this.thesisListService.addThesis(thesis);
    }
//    @PostMapping("/{thesisId}")
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public void addThesisPos(HttpSession session,
//            @PathVariable(value = "thesisId") int thesisId) {
//        ThesisPosition thesisPos = this.thesisListService.getThesisPos(thesisId, thesisId);
//        this.thesisListService.addThesis(thesis);
//    }
    
//    
//    @GetMapping("/thesisDetail/{thesisId}")
//    public String detail(Model model, @PathVariable(value = "thesisId") int id) {
//        model.addAttribute("thesis", this.thesisListService.getThesisById(id));
//        return "thesis-Detail";
//    }

}

