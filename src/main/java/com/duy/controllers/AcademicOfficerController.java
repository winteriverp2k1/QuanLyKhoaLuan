/////*
//// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//// */
////package com.duy.controllers;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
////import com.duy.service.CouncilListService;
////import com.duy.service.ThesisListService;
////import org.springframework.web.bind.annotation.RequestParam;
////
/////**
//// *
//// * @author Admin
//// */
////@Controller
////@RequestMapping("/academic")
////public class AcademicOfficerController {
////    
////    @Autowired
////    private CouncilListService councilListService;
////    
////    @Autowired
////    private ThesisListService thesisListService;
////
////    @GetMapping("/manager")
////    public String academicPage() {
////        return "academicPage";
////    }
////
////    @GetMapping("/thesisManager")
////    public String thesisManager() {
////        return "thesisManager";
////    }
////
////    @GetMapping("/createThesis")
////    public String createThesis() {
////        return "createThesis";
////    }
////
////    @GetMapping("/createCouncil")
////    public String createCouncil() {
////        return "createCouncil";
////    }
////
////    @GetMapping("/councilList")
////    public String councilList(Model model, @RequestParam(value = "kw", required = false, defaultValue = "") String kw) {
////        model.addAttribute("council", this.councilListService.getCouncils(kw));
////        return "councilList";
////    }
////
////    @GetMapping("/thesisList")
////    public String thesisList(Model model, @RequestParam(value = "kw", required = false, defaultValue = "") String kw) { 
////        model.addAttribute("thesis", this.thesisListService.getThesis(kw));
////        return "thesisList";
////    }
////    
////    @GetMapping("/statistical")
////    public String statistical() {
////        return "statistical";
////    }
////    
////    @GetMapping("/councilDetail")
////    public String councilDetail() {
////        return "councilDetail";
////    }
////}
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.duy.controllers;
//
//import com.duy.pojo.Council;
//import com.duy.pojo.Thesis;
//import com.duy.pojo.ThesisPosition;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import com.duy.service.CouncilListService;
//import com.duy.service.FacultyService;
//import com.duy.service.ThesisListService;
//import com.duy.service.ThesisService;
//import com.duy.service.UserService;
//import com.duy.validator.WebAppValidator;
//import java.util.Date;
//import java.util.Map;
//import javax.validation.Valid;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// *
// * @author Admin
// */
//@Controller
//@ControllerAdvice
//@RequestMapping("/academic")
//public class AcademicOfficerController {
//
//    @Autowired
//    private ThesisService thesisService;
//    
//    @Autowired
//    private CouncilListService councilListService;
//
//    @Autowired
//    private ThesisListService thesisListService;
//
//    @Autowired
//    private UserService userDetailsService;
//
//    @Autowired
//    private FacultyService facultyService;
//
//    @Autowired
//    private WebAppValidator CheckFacultyValidator;
//
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        try {
//            if (CheckFacultyValidator.supports(binder.getTarget().getClass())) {
//                binder.setValidator(CheckFacultyValidator);
//            }
//
//        } catch (Exception ex) {
//
//        }
//    }
//
//    @GetMapping("/manager")
//    public String academicPage() {
//        return "academicPage";
//    }
//
//    @GetMapping("/thesisManager")
//    public String thesisManager() {
//        return "thesisManager";
//    }
//
//    @GetMapping("/createThesis")
//    public String createThesis(Model model) {
//        model.addAttribute("thesis", new Thesis());
//        model.addAttribute("thesis_position", new ThesisPosition());
//        model.addAttribute("students", this.userDetailsService.getStudents());
//        model.addAttribute("teachers", this.userDetailsService.getTeachers());
//        model.addAttribute("faculties", this.facultyService.getFaculties());
////        model.addAttribute("user", this.userDetailsService.getUsers());
//        return "createThesis";
//    }
//
//    @GetMapping("/createCouncil")
//    public String createCouncil(Model model) {
//        model.addAttribute("council", new Council());
//        model.addAttribute("students", this.userDetailsService.getStudents());
//        model.addAttribute("teachers", this.userDetailsService.getTeachers());
//        model.addAttribute("faculties", this.facultyService.getFaculties());
////        model.addAttribute("user", this.userDetailsService.getUsers(kw));
//        return "createCouncil";
//    }
//
//    @PostMapping("/createThesis")
//    public String createThesis(Model model, @ModelAttribute(value = "thesis") @Valid Thesis thesis, BindingResult result) {
//        System.err.println(thesis.getName());
//        System.err.println(thesis.getYear().toString());
//        System.err.println(thesis.getFacultyId().toString());
//        if (!result.hasErrors()) {
//            model.addAttribute("thisThesis", thesisListService.addThesis(thesis));
//            return "redirect:/academic/manager";
////        } else {
////            model.addAttribute("errMsg", "Something wrong!");
////            return "redirect:/";
//        }
//        return "createThesis";
//    }
//
//    @PostMapping("/createCouncil")
//    public String createCouncil(Model model, @ModelAttribute(value = "council") @Valid Council council, BindingResult result) {
//        System.err.println(council.getName());
//        System.err.println(council.getCreatedDate());
//        System.err.println(council.getFacultyId().toString());
//        if (!result.hasErrors()) {
//            model.addAttribute("thisCouncil", councilListService.addCouncil(council));
//            return "redirect:/academic/manager";
////        } else {
////            model.addAttribute("errMsg", "Something wrong!");
////            return "redirect:/";
//        }
//        return "createCouncil";
//    }
//
//    @PostMapping("performThesis/{thesisId}")
//    public String doThesis(Model model, @ModelAttribute(value = "thesis_position") @Valid ThesisPosition thesisPos, BindingResult result) {
//
////        model.addAttribute("thesis", this.thesisListService.getThesisById(thesisId));
//        model.addAttribute("thesis_position", new ThesisPosition());
//
//        if (!result.hasErrors()) {
//            model.addAttribute("thisThesisPos", thesisListService.addThesisPos(thesisPos));
//            return "thesisList";
//        } else {
//            return "thesisList";
//        }
//    }
//
//    @GetMapping("performThesis/{thesisId}")
//    public String doThesis(Model model, @PathVariable(value = "thesisId") int id) {
//        model.addAttribute("thesis", this.thesisListService.getThesisById(id));
//        Thesis t = this.thesisListService.getThesisById(id);
//        int fId = t.getFacultyId().getId();
//        System.out.println(fId);
//        model.addAttribute("position", this.thesisListService.getPosThesis());
//        System.out.println(this.thesisListService.getPosThesis());
//
//        model.addAttribute("students", this.userDetailsService.getStudentsByFacultyId(fId));
//        model.addAttribute("teachers", this.userDetailsService.getTeachersByFacultyId(fId));
//        model.addAttribute("thesis_position", new ThesisPosition());
////        model.addAttribute("thesis_position", this.thesisListService.getThesisPos(id,2));
////        model.addAttribute("thesis_position", this.thesisListService.getThesisPos(id,1));
//        return "performThesis";
//    }
//
//    @GetMapping("/thesisDetail/{thesisId}")
//    public String detail(Model model, @PathVariable(value = "thesisId") int id) {
//        model.addAttribute("thesis", this.thesisListService.getThesisById(id));
////        model.addAttribute("students", this.userDetailsService.getStudents());
////        model.addAttribute("teachers", this.userDetailsService.getTeachers());
//        model.addAttribute("faculties", this.facultyService.getFaculties());
////        model.addAttribute("students", this.thesisListService.getThesisPos(id, 2));
////        model.addAttribute("teachers", this.thesisListService.getThesisPos(id, 1));
////        System.out.println(this.thesisListService.getThesisPos(1, 2));
//        return "thesis-Detail";
//    }
//
//    @GetMapping("/councilDetail/{councilId}")
//    public String councilDetail(Model model, @PathVariable(value = "councilId") int id) {
//        model.addAttribute("council", this.councilListService.getCouncilById(id));
////        model.addAttribute("students", this.userDetailsService.getStudents());
////        model.addAttribute("teachers", this.userDetailsService.getTeachers());
//        model.addAttribute("faculties", this.facultyService.getFaculties());
//        return "councilDetail";
//    }
//
//    @GetMapping("/councilList")
//    public String councilList(Model model, @RequestParam Map<String, String> params) {
//        String kw = params.getOrDefault("kw", null);
//        int page = Integer.parseInt(params.getOrDefault("page", "1"));
//        model.addAttribute("council", this.councilListService.getCouncils(kw, page));
//        model.addAttribute("count", this.councilListService.countCouncil());
//        return "councilList";
//    }
//
//    @GetMapping("/thesisList")
//    public String thesisList(Model model,@RequestParam Map<String, String> params) {
//         String kw = params.getOrDefault("kw", null);
//        int page = Integer.parseInt(params.getOrDefault("page", "1"));
//        model.addAttribute("thesis", this.thesisListService.getThesis(kw, page));
//        model.addAttribute("count", this.thesisListService.countThesis());
//        return "thesisList";
//    }
//
//    @GetMapping("/statistical")
//    public String statistical(Model model, @RequestParam(value = "year", required = false) Integer year) {
//        model.addAttribute("stats", this.thesisService.countThesisbyFaculty());
//        model.addAttribute("yearStats", this.thesisService.thesisPointbyYear(year));
//        model.addAttribute("userFaculty", this.userDetailsService.countUserByFacultyId());
//        model.addAttribute("userThesis", this.userDetailsService.countUserByThesis());
//        return "statistical";
//    }
//
//    @ModelAttribute
//    public void commonAttr(Model model) {
//        model.addAttribute("thesis", new Thesis());
////        model.addAttribute("thesis_position", new ThesisPosition());
//        model.addAttribute("students", this.userDetailsService.getStudents());
//        model.addAttribute("teachers", this.userDetailsService.getTeachers());
//        model.addAttribute("faculties", this.facultyService.getFaculties());
//    }
//
//}

///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.duy.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import com.duy.service.CouncilListService;
//import com.duy.service.ThesisListService;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// *
// * @author Admin
// */
//@Controller
//@RequestMapping("/academic")
//public class AcademicOfficerController {
//    
//    @Autowired
//    private CouncilListService councilListService;
//    
//    @Autowired
//    private ThesisListService thesisListService;
//
//    @GetMapping("/manager")
//    public String academicPage() {
//        return "academicPage";
//    }
//
//    @GetMapping("/thesisManager")
//    public String thesisManager() {
//        return "thesisManager";
//    }
//
//    @GetMapping("/createThesis")
//    public String createThesis() {
//        return "createThesis";
//    }
//
//    @GetMapping("/createCouncil")
//    public String createCouncil() {
//        return "createCouncil";
//    }
//
//    @GetMapping("/councilList")
//    public String councilList(Model model, @RequestParam(value = "kw", required = false, defaultValue = "") String kw) {
//        model.addAttribute("council", this.councilListService.getCouncils(kw));
//        return "councilList";
//    }
//
//    @GetMapping("/thesisList")
//    public String thesisList(Model model, @RequestParam(value = "kw", required = false, defaultValue = "") String kw) { 
//        model.addAttribute("thesis", this.thesisListService.getThesis(kw));
//        return "thesisList";
//    }
//    
//    @GetMapping("/statistical")
//    public String statistical() {
//        return "statistical";
//    }
//    
//    @GetMapping("/councilDetail")
//    public String councilDetail() {
//        return "councilDetail";
//    }
//}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.controllers;

import com.duy.pojo.Council;
import com.duy.pojo.Thesis;
import com.duy.pojo.ThesisPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.duy.service.CouncilListService;
import com.duy.service.FacultyService;
import com.duy.service.ThesisListService;
import com.duy.service.ThesisService;
import com.duy.service.UserService;
import com.duy.validator.WebAppValidator;
import java.util.Date;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
@RequestMapping("/academic")
public class AcademicOfficerController {

    @Autowired
    private ThesisService thesisService;
    
    @Autowired
    private CouncilListService councilListService;

    @Autowired
    private ThesisListService thesisListService;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private WebAppValidator CheckFacultyValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        try {
            if (CheckFacultyValidator.supports(binder.getTarget().getClass())) {
                binder.setValidator(CheckFacultyValidator);
            }

        } catch (Exception ex) {

        }
    }

    @GetMapping("/manager")
    public String academicPage() {
        return "academicPage";
    }

    @GetMapping("/thesisManager")
    public String thesisManager() {
        return "thesisManager";
    }

    @GetMapping("/createThesis")
    public String createThesis(Model model) {
        model.addAttribute("thesis", new Thesis());
        model.addAttribute("thesis_position", new ThesisPosition());
        model.addAttribute("students", this.userDetailsService.getStudents());
        model.addAttribute("teachers", this.userDetailsService.getTeachers());
        model.addAttribute("faculties", this.facultyService.getFaculties());
//        model.addAttribute("user", this.userDetailsService.getUsers());
        return "createThesis";
    }

    @GetMapping("/createCouncil")
    public String createCouncil(Model model) {
        model.addAttribute("council", new Council());
        model.addAttribute("students", this.userDetailsService.getStudents());
        model.addAttribute("teachers", this.userDetailsService.getTeachers());
        model.addAttribute("faculties", this.facultyService.getFaculties());
//        model.addAttribute("user", this.userDetailsService.getUsers(kw));
        return "createCouncil";
    }

    @PostMapping("/createThesis")
    public String createThesis(Model model, @ModelAttribute(value = "thesis") @Valid Thesis thesis, BindingResult result) {
        System.err.println(thesis.getName());
        System.err.println(thesis.getYear().toString());
        System.err.println(thesis.getFacultyId().toString());
        if (!result.hasErrors()) {
            model.addAttribute("thisThesis", thesisListService.addThesis(thesis));
            return "redirect:/academic/manager";
//        } else {
//            model.addAttribute("errMsg", "Something wrong!");
//            return "redirect:/";
        }
        return "createThesis";
    }

    @PostMapping("/createCouncil")
    public String createCouncil(Model model, @ModelAttribute(value = "council") @Valid Council council, BindingResult result) {
        System.err.println(council.getName());
        System.err.println(council.getCreatedDate());
        System.err.println(council.getFacultyId().toString());
        if (!result.hasErrors()) {
            model.addAttribute("thisCouncil", councilListService.addCouncil(council));
            return "redirect:/academic/manager";
//        } else {
//            model.addAttribute("errMsg", "Something wrong!");
//            return "redirect:/";
        }
        return "createCouncil";
    }
    
    
//
//    @PostMapping("performThesis/{thesisId}")
//    public String doThesis(Model model, @ModelAttribute(value = "thesis_position") @Valid ThesisPosition thesisPos, BindingResult result) {
//        
////        model.addAttribute("thesis", this.thesisListService.getThesisById(thesisId));
//        model.addAttribute("thesis_position", new ThesisPosition());
//        model.addAttribute("thesis", thesisListService.getThesisById(thesisPos.getThesisId().getId()));
//
//        if (!result.hasErrors()) {
//            model.addAttribute("thisThesisPos", thesisListService.addThesisPos(thesisPos));
//            return "thesisList";
//        } else {
//            return "thesisList";
//        }
//    }
    
    @PostMapping("/performThesis")
    public String doThesis(Model model, @ModelAttribute(value = "thesis_position") @Valid ThesisPosition thesisPos, BindingResult result) {
        model.addAttribute("thesis", thesisListService.getThesisById(thesisPos.getThesisId().getId()));

        thesisListService.addThesisPos(thesisPos);
        if (!result.hasErrors()) {
            model.addAttribute("thisThesisPos", thesisListService.addThesisPos(thesisPos));
            thesisListService.addThesisPos(thesisPos);
            return "redirect:/";
        } else {
            return "redirect:/";
        }
//        return "redirect:/";
    }

//    @GetMapping("performThesis/{thesisId}")
//    public String doThesis(Model model, @PathVariable(value = "thesisId") int id) {
//        model.addAttribute("thesis", this.thesisListService.getThesisById(id));
//        Thesis t = this.thesisListService.getThesisById(id);
////        model.addAttribute("teacher_count", this.userDetailsService.countTeacherDoThesis(t.getId()));
////        model.addAttribute("student_count", this.userDetailsService.countStudentDoThesis(t.getId()));
//        int fId = t.getFacultyId().getId();
//        System.out.println(fId);
//        model.addAttribute("position", this.thesisListService.getPosThesis());
//        System.out.println(this.thesisListService.getPosThesis());
//
//        model.addAttribute("students", this.userDetailsService.getStudentsByFacultyId(fId));
//        model.addAttribute("teachers", this.userDetailsService.getTeachersByFacultyId(fId));
//        model.addAttribute("thesis_position", new ThesisPosition());
//        System.out.println(this.userDetailsService.getStudentsByFacultyId(fId));
//        System.out.println(this.userDetailsService.getTeachersByFacultyId(fId));
////        model.addAttribute("thesis_position", this.thesisListService.getThesisPos(id,2));
////        model.addAttribute("thesis_position", this.thesisListService.getThesisPos(id,1));
//        return "performThesis";
//    }
    
    @GetMapping("performThesis/{thesisId}")
    public String doThesis(Model model, @PathVariable(value = "thesisId") int id) {
        model.addAttribute("thesis_position", new ThesisPosition());
        model.addAttribute("thesis", this.thesisListService.getThesisById(id));
        Thesis t = this.thesisListService.getThesisById(id);

        int fId = t.getFacultyId().getId();
        System.out.println(fId);
        model.addAttribute("position", this.thesisListService.getPosThesis());

        model.addAttribute("students", this.userDetailsService.getStudentsByFacultyId(fId));
        model.addAttribute("teachers", this.userDetailsService.getTeachersByFacultyId(fId));
        
        model.addAttribute("count_students", this.userDetailsService.countStudentDoThesis(t.getId()));
        model.addAttribute("count_teachers", this.userDetailsService.countTeacherDoThesis(t.getId()));

        return "performThesis";
    }


    @GetMapping("/thesisDetail/{thesisId}")
    public String detail(Model model, @PathVariable(value = "thesisId") int id) {
        Thesis t = this.thesisListService.getThesisById(id);
        model.addAttribute("thesis", this.thesisListService.getThesisById(id));
        model.addAttribute("faculties", this.facultyService.getFaculties());
        int thesisId = t.getId();
        model.addAttribute("students", this.thesisListService.getThesisPos(thesisId, 2));
        model.addAttribute("teachers", this.thesisListService.getThesisPos(thesisId, 1));
//        System.out.println(this.thesisListService.getThesisPos(1, 1));
//        System.out.println(this.thesisListService.getThesisPos(1, 2));
        return "thesis-Detail";
    }

    @GetMapping("/councilDetail/{councilId}")
    public String councilDetail(Model model, @PathVariable(value = "councilId") int id) {
        Council c = this.councilListService.getCouncilById(id);
        model.addAttribute("council", this.councilListService.getCouncilById(id));
        model.addAttribute("faculties", this.facultyService.getFaculties());
        int councilId = c.getId();
        model.addAttribute("mem1", this.councilListService.getCouncilPos(councilId, 1));
        model.addAttribute("mem2", this.councilListService.getCouncilPos(councilId, 2));
        model.addAttribute("mem3", this.councilListService.getCouncilPos(councilId, 3));
        model.addAttribute("mem4", this.councilListService.getCouncilPos(councilId, 4));
        model.addAttribute("mem5", this.councilListService.getCouncilPos(councilId, 5));
        
        return "councilDetail";
    }

    @GetMapping("/councilList")
    public String councilList(Model model, @RequestParam Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("council", this.councilListService.getCouncils(kw, page));
        model.addAttribute("count", this.councilListService.countCouncil());
        return "councilList";
    }

//    @GetMapping("/thesisList")
//    public String thesisList(Model model,@RequestParam Map<String, String> params) {
//         String kw = params.getOrDefault("kw", null);
//        int page = Integer.parseInt(params.getOrDefault("page", "1"));
//        model.addAttribute("thesis", this.thesisListService.getThesis(kw, page));
//        model.addAttribute("count", this.thesisListService.countThesis());
//        return "thesisList";
//    }
     @GetMapping("/thesisList")
    public String thesisList(Model model, @RequestParam(required = false) Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("thesis", this.thesisListService.getThesis(kw, page));
        model.addAttribute("count", this.thesisListService.countThesis());
        return "thesisList";
    }

    @GetMapping("/statistical")
    public String statistical(Model model, @RequestParam(value = "year", required = false) Integer year) {
        model.addAttribute("stats", this.thesisService.countThesisbyFaculty());
        model.addAttribute("yearStats", this.thesisService.thesisPointbyYear(year));
        model.addAttribute("userFaculty", this.userDetailsService.countUserByFacultyId());
        model.addAttribute("userThesis", this.userDetailsService.countUserByThesis());
        return "statistical";
    }

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("thesis", new Thesis());
//        model.addAttribute("thesis_position", new ThesisPosition());
        model.addAttribute("students", this.userDetailsService.getStudents());
        model.addAttribute("teachers", this.userDetailsService.getTeachers());
        model.addAttribute("faculties", this.facultyService.getFaculties());
    }

     @RequestMapping(value = "/deleteThesis/{thesisId}", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteThesis(Model model, @PathVariable(value = "thesisId") int id) {
        try {
            int t = thesisListService.getThesisById(id).getId();
            thesisListService.deleteThesis(t);

        } catch (Exception e) {

        }
        return "redirect:/academic/thesisList";
    }

    @RequestMapping(value = "/deleteCouncil/{councilId}", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteCouncil(Model model, @PathVariable(value = "councilId") int id) {
        try {
            int c = councilListService.getCouncilById(id).getId();
            councilListService.deleteCouncil(c);

        } catch (Exception e) {

        }
        return "redirect:/academic/councilList";
    }
}

