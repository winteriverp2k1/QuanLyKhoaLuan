/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.controllers;

import com.duy.pojo.User;
import com.duy.service.FacultyService;
import com.duy.service.ThesisListService;
import com.duy.service.ThesisService;
import com.duy.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ThesisService thesisService;
    
    @Autowired
    private ThesisListService thesisListService;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/council")
    public String listCouncil() {
        return "council";
    }

    @GetMapping("/userManager")
    public String userManager(Model model, @RequestParam Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page","1"));
        model.addAttribute("user", this.userDetailsService.getUsers(kw, page));
        model.addAttribute("count", this.userDetailsService.countUser());
        return "userManager";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("faculty", this.facultyService.getFaculties());
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User user) {
        String errMsg = "";
//        if (r.hasErrors())      
//            return "/admin/register";
//        try {  
//            Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
//            String img = (String) r.get("secure_url");
//
//        } catch(IOException ex){
//            System.err.println("ERROR:  " + ex.getMessage());
//        }
//            return "/admin/userManager";

        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (this.userDetailsService.addUser(user) == true) {
                return "redirect:/admin/userManager";
            } else {
                errMsg = "Đã có lỗi sảy ra";
            }
        } else {
            errMsg = "Mật khẩu không trùng khớp";
        }
//        if (this.userDetailsService.addUser(user) == true) {
//            return "redirect:/admin/userManager";
//        } else {
//            errMsg = "Đã có lỗi sảy ra";
//        }

        model.addAttribute("errMsg", errMsg);

        return "register";
    }

    @GetMapping("/userDetail")
    public String userDetail() {
        return "userDetail";
    }

    @GetMapping("/adminPage")
    public String adminPage() {
        return "adminPage";
    }

    @GetMapping("/statistical")
    public String statistical(Model model, @RequestParam(value = "year",required = false) Integer year) {

        model.addAttribute("stats", this.thesisService.countThesisbyFaculty());
        model.addAttribute("yearStats", this.thesisService.thesisPointbyYear(year));
        model.addAttribute("userFaculty", this.userDetailsService.countUserByFacultyId());
        model.addAttribute("userThesis", this.userDetailsService.countUserByThesis());
        model.addAttribute("totalStudent", this.userDetailsService.totalStudent());
      

        return "statistical";
    }

    @GetMapping("/user/{userId}")
    public String UserDetail(Model model, @PathVariable(value = "userId") int userId) {
        model.addAttribute("userdetail", this.userDetailsService.getUserById(userId));
        return "userDetail";
    }

    @GetMapping("/user/delete/{userId}")
    public String deleteUser(@PathVariable(value = "userId") int userId) {
        if (this.userDetailsService.deleteUser(userId) == true) {
            return "redirect:/admin/userManager";
        }
        return "userDetail";
    }

}
