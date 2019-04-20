package com.fanyi.admin.controller;

import com.fanyi.admin.domain.Dongtai;
import com.fanyi.admin.domain.User;
import com.fanyi.admin.util.ConstraintViolationExceptionHandler;
import com.fanyi.admin.service.DongtaiService;
import com.fanyi.admin.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/dongtai")

public class DongtaiController {
    private static final Logger logger=LoggerFactory.getLogger(DongtaiController.class);

    @Autowired
    private DongtaiService dongtaiService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @GetMapping("/list")
    // boolean 类型的值默认为false
    public ModelAndView list(
                             @RequestParam(value="async",required=false) boolean async,
                             @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                             @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                             @RequestParam(value="title",required=false,defaultValue="") String title,
                             Model model) {

        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<Dongtai> page = dongtaiService.listDongtaisByTitleLike(title,pageable);
        List<Dongtai> list = page.getContent();	// 当前所在页面数据列表

        model.addAttribute("page", page);
        model.addAttribute("dongtaiList", list);
        model.addAttribute("title","学院动态");
        return new ModelAndView(async==true?"admin/dongtai/list :: #mainContainerRepleace":"admin/dongtai/list", "dongtaiModel", model);
    }
    /**
     * 获取 form 表单页面
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @GetMapping("/add")
    public ModelAndView createForm(Model model) {
        model.addAttribute("dongtai", new Dongtai());
        return new ModelAndView("/admin/dongtai/edit", "dongtaiModel", model);
    }

    /**
     * 新建和更新教研工作
     * @param dongtai


     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @PostMapping("/update")
    public ResponseEntity<Response> create( Dongtai dongtai) {


        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

           //新建教研工作
            if(dongtai.getId()==null){
                dongtai.setHit(0);
                dongtai.setPublisher(user);
                dongtai.setPublishTime(new Date());
                dongtai.setUpdateTime(new Date());
                dongtai.setUpdateUser(user);

            }else{
                //更新教研工作,对于表单中没有出现的字段要把原来的值付给它们
                Dongtai originalDongtai=dongtaiService.getDongtaiById(dongtai.getId());
                dongtai.setHit(originalDongtai.getHit());
                dongtai.setPublisher(originalDongtai.getPublisher());
                dongtai.setPublishTime(originalDongtai.getPublishTime());
                dongtai.setUpdateTime(new Date());
                dongtai.setUpdateUser(user);

            }

            dongtaiService.saveDongtai(dongtai);
        } catch (ConstraintViolationException e)  {
            return ResponseEntity.ok().body(new Response(false, ConstraintViolationExceptionHandler.getMessage(e)));
        } catch (Exception e) {
            return ResponseEntity.ok().body(new Response(false, e.getMessage()));
        }
        return ResponseEntity.ok().body(new Response(true, "处理成功", null));
    }

    /**
     * 删除教研工作
     * @param id
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Long id) {
        try {
            dongtaiService.removeDongtai(id);
        } catch (Exception e) {
            return  ResponseEntity.ok().body( new Response(false, e.getMessage()));
        }
        return  ResponseEntity.ok().body( new Response(true, "处理成功"));
    }

    /**
     * 获取修、添加改教研工作的界面及数据
     * @param id,model
     * @return
     */
    @GetMapping(value = "edit/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        Dongtai dongtai = dongtaiService.getDongtaiById(id);
        model.addAttribute("dongtai", dongtai);

        return new ModelAndView("admin/dongtai/edit", "dongtaiModel", model);
    }

    @GetMapping(value = "homeList")
    public ModelAndView homeList(Model model) {
        Pageable pageable = new PageRequest(0, 20);
        Page<Dongtai> page = dongtaiService.listDongtaisByTitleLike("", pageable);
        List<Dongtai> list = page.getContent();    // 当前所在页面数据列表

        model.addAttribute("dongtaiList",list);
        model.addAttribute("title","学院动态");
        return new ModelAndView("dongtaiList", "dongtaiModel", model);
    }
    @GetMapping(value = "view/{id}")
    public ModelAndView homeView(@PathVariable("id") Long id, Model model) {
        Dongtai dongtai = dongtaiService.getDongtaiById(id);
        dongtai.setHit(dongtai.getHit()+1);
        dongtaiService.saveDongtai(dongtai);
        model.addAttribute("dongtai", dongtai);
        model.addAttribute("title","学院动态");
        return new ModelAndView("dongtaiView", "dongtaiModel", model);
    }
}
