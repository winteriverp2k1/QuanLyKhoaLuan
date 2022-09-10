/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.controllers;

import com.duy.pojo.User;
import com.duy.service.CouncilService;
import com.duy.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class indexController {

    @Autowired
    private CouncilService councilService;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params, HttpSession session) {
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        return "index";

    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/detail")
    public String accountDetail(Model model, HttpSession session) {
        model.addAttribute("currentUser", session.getAttribute("currentUser"));

        return "accountDetail";
    }

    @PostMapping("/detail/{userId}")
    public String accountDetail(Model model, @RequestParam(required = false) Map<String, String> params, @PathVariable(value = "userId") int userId) {
        String errMsg = "";

//        String oldpw = params.get("old");
        String newpw = params.get("new");

//        String old = this.passwordEncoder.encode(oldpw);
//        String newpw = params.get("newPassword");
        if (this.userDetailsService.changePassword(userId, newpw) == true) {
            return "redirect:/login";
        } else {
            errMsg = "Đã có lỗi sảy ra";
        }
//        

//        if (this.userDetailsService.changePassword(userId, newpw) == true) {
//            return "redirect:/login";
//        } else {
//            errMsg = "Đã có lỗi sảy ra";
//        }
//        if (this.userDetailsService.checkOldPassword(userId, oldpw) == true) {
//            if (this.userDetailsService.changePassword(userId, newpw) == true) {
//                return "redirect:/login";
//            }
//        }
//        } else {
//                errMsg = "Đã có lỗi sảy ra";
//            }
//        if(this.userDetailsService.checkOldPassword(userId, oldpw) == true)){
//            this.userDetailsService.changePassword(userId, newpw);
//            return "/login";
//        }
//        String oldpw = params.get("oldpassword");
//        Integer u = user.getId();
////        if (user.getPassword().equals(user.getNewPassword())) {
//            if (this.userDetailsService.checkOldPassword(userId, oldpw) == true) {
//                return "/changePassword";
//            } else {
//                errMsg = "Đã có lỗi sảy ra";
//            }
//        } else {
//            errMsg = "Mật khẩu không trùng khớp";
//        }
//        if (${currentUser.password}.equals(newpw)) {
//            return "redirect:/changePassword/{userId}";
//        } else {
//            errMsg = "Đã có lỗi sảy ra";
//        }
//
//        model.addAttribute("errMsg", errMsg);
        return "accountDetail";
    }

    @GetMapping("/changePassword")
    public String changePassword() {
//        String errMsg = "";
//        
//        String newpw = params.get("newPassword");
//        
//        if (this.userDetailsService.changePassword(userId, newpw)) {
//            return "redirect:/changePassword";
//        } else {
//            errMsg = "Đã có lỗi sảy ra";
//        }
//
//        model.addAttribute("errMsg", errMsg);

        return "changePassword";
    }

}
