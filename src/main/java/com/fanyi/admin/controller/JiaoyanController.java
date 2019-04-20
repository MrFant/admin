package com.fanyi.admin.controller;

import com.fanyi.admin.domain.User;
import com.fanyi.admin.util.ConstraintViolationExceptionHandler;
import com.fanyi.admin.domain.Jiaoyan;
import com.fanyi.admin.service.JiaoyanService;
import com.fanyi.admin.util.Menu;
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
@RequestMapping("/jiaoyan")

public class JiaoyanController {
    private static final Logger logger=LoggerFactory.getLogger(JiaoyanController.class);

    @Autowired
    private JiaoyanService jiaoyanService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @GetMapping("/list/{type}")
    public ModelAndView list(@PathVariable("type") String type,
                             @RequestParam(value="async",required=false) boolean async,
                             @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                             @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                             @RequestParam(value="title",required=false,defaultValue="") String title,
                             Model model) {

        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<Jiaoyan> page = jiaoyanService.listJiaoyansByTypeAndTitleLike(type,title,pageable);
        List<Jiaoyan> list = page.getContent();	// 当前所在页面数据列表

        model.addAttribute("page", page);
        model.addAttribute("jiaoyanList", list);
        model.addAttribute("title","教研工作 》"+Menu.getMenu().get(type));
        model.addAttribute("type",type);
        return new ModelAndView(async==true?"admin/jiaoyan/list :: #mainContainerRepleace":"admin/jiaoyan/list", "jiaoyanModel", model);
    }
    /**
     * 获取 form 表单页面
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @GetMapping("/add/{type}")
    public ModelAndView createForm(@PathVariable("type") String type,Model model) {
        model.addAttribute("jiaoyan", new Jiaoyan());
        model.addAttribute("type", type);
        return new ModelAndView("/admin/jiaoyan/edit", "jiaoyanModel", model);
    }

    /**
     * 新建和更新教研工作
     * @param jiaoyan


     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @PostMapping("/update/{type}")
    public ResponseEntity<Response> create(@PathVariable("type") String type, Jiaoyan jiaoyan) {


        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

           //新建教研工作
            if(jiaoyan.getId()==null){
                jiaoyan.setHit(0);
                jiaoyan.setPublisher(user);
                jiaoyan.setPublishTime(new Date());
                jiaoyan.setUpdateTime(new Date());
                jiaoyan.setUpdateUser(user);

            }else{
                //更新教研工作,对于表单中没有出现的字段要把原来的值付给它们
                Jiaoyan originalJiaoyan=jiaoyanService.getJiaoyanById(jiaoyan.getId());
                jiaoyan.setHit(originalJiaoyan.getHit());
                jiaoyan.setPublisher(originalJiaoyan.getPublisher());
                jiaoyan.setPublishTime(originalJiaoyan.getPublishTime());
                jiaoyan.setUpdateTime(new Date());
                jiaoyan.setUpdateUser(user);

            }

            jiaoyanService.saveJiaoyan(jiaoyan);
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
            jiaoyanService.removeJiaoyan(id);
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
        Jiaoyan jiaoyan = jiaoyanService.getJiaoyanById(id);
        model.addAttribute("jiaoyan", jiaoyan);

        return new ModelAndView("admin/jiaoyan/edit", "jiaoyanModel", model);
    }

    @GetMapping(value = "homeList/{type}")
    public ModelAndView homeList(@PathVariable("type") String type, Model model) {
        Pageable pageable = new PageRequest(0, 20);
        Page<Jiaoyan> page = jiaoyanService.listJiaoyansByTypeAndTitleLike("jiaoxue", "", pageable);
        List<Jiaoyan> list = page.getContent();    // 当前所在页面数据列表

        model.addAttribute("jiaoyanList",list);
        model.addAttribute("type",type);
        model.addAttribute("title","教研工作 》"+Menu.getMenu().get(type));
        return new ModelAndView("jiaoyanList", "jiaoyanModel", model);
    }
    @GetMapping(value = "view/{id}/{type}")
    public ModelAndView homeView(@PathVariable("id") Long id,@PathVariable("type") String type, Model model) {
        Jiaoyan jiaoyan = jiaoyanService.getJiaoyanById(id);
        jiaoyan.setHit(jiaoyan.getHit()+1);
        jiaoyanService.saveJiaoyan(jiaoyan);
        model.addAttribute("jiaoyan", jiaoyan);
        model.addAttribute("title","教研工作 》"+Menu.getMenu().get(type));
        return new ModelAndView("jiaoyanView", "jiaoyanModel", model);
    }
}
