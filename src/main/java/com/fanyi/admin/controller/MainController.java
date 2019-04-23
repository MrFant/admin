package com.fanyi.admin.controller;

import com.fanyi.admin.domain.*;
import com.fanyi.admin.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    private static final Long ROLE_USER_AUTHORITY_ID = 2L;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private JiaoyanService jiaoyanService;
    @Autowired
    private DongtaiService dongtaiService;
    @Autowired
    private BiyeshengService biyeshengService;



    @GetMapping(value = {"/","/index"})
    public String index(Model model) {
        model.addAttribute("jiaoxueList", this.getJiaoxueList());
        model.addAttribute("dongtaiList", this.getDongtaiList());
        model.addAttribute("biyeshengList", this.getBiyeshengList());
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("hidenLogin", "false");
        return "index";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {

        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登陆失败，账号或者密码错误！");
//        return "redirect:/login";
        //这里应该用请求转发而不是重定向
        return "forward:/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("hidenRegister", "false");
        return "index";
    }

    @GetMapping("/Access_Denied")
    public String error(Model model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }


    @PostMapping("/register")
    public String registerUser(User user) {
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
        user.setAuthorities(authorities);
        user.setEncodePassword(user.getPassword());
        userService.saveUser(user);
        log.info("save user");
        return "redirect:/login";
    }


//    @GetMapping("/logout/page")
//    public String logoutPage() {
//
//        return "redirect:/login";
//    }



    private List<Jiaoyan> getJiaoxueList() {
        Pageable pageable = new PageRequest(0, 12);
        Page<Jiaoyan> page = jiaoyanService.listJiaoyansByTypeAndTitleLike("jiaoxue", "", pageable);
        List<Jiaoyan> list = page.getContent();    // 当前所在页面数据列表

        for (Jiaoyan jiaoxue : list) {
            entityManager.detach(jiaoxue);
            jiaoxue.setTitle("<i class=\"fa fa-chevron-circle-right fa-fw\"></i>" + jiaoxue.getTitle());
        }
        return list;
    }
    private List<Dongtai> getDongtaiList() {
        Pageable pageable = new PageRequest(0, 12);
        Page<Dongtai> page = dongtaiService.listDongtaisByTitleLike("", pageable);
        List<Dongtai> list = page.getContent();    // 当前所在页面数据列表
        for (Dongtai dongtai : list) {
            entityManager.detach(dongtai);
            dongtai.setTitle("<i class=\"fa fa-chevron-circle-right fa-fw\"></i>" + dongtai.getTitle());
        }
        return list;
    }
    private List<Biyesheng> getBiyeshengList() {
        Pageable pageable = new PageRequest(0, 12);
        Page<Biyesheng> page = biyeshengService.listBiyeshengsByTitleLike("", pageable);
        List<Biyesheng> list = page.getContent();    // 当前所在页面数据列表

        return list;
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
