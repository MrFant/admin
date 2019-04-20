package com.fanyi.admin.controller;

import com.fanyi.admin.domain.Biyesheng;
import com.fanyi.admin.domain.User;
import com.fanyi.admin.util.ConstraintViolationExceptionHandler;
import com.fanyi.admin.service.BiyeshengService;
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
@RequestMapping("/biyesheng")

public class BiyeshengController {
    private static final Logger logger=LoggerFactory.getLogger(BiyeshengController.class);

    @Autowired
    private BiyeshengService biyeshengService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value="async",required=false) boolean async,
                             @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                             @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                             @RequestParam(value="title",required=false,defaultValue="") String title,
                             Model model) {

        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<Biyesheng> page = biyeshengService.listBiyeshengsByTitleLike(title,pageable);
        List<Biyesheng> list = page.getContent();	// 当前所在页面数据列表

        model.addAttribute("page", page);
        model.addAttribute("biyeshengList", list);
        model.addAttribute("title","优秀毕业生");
        return new ModelAndView(async==true?"admin/biyesheng/list :: #mainContainerRepleace":"admin/biyesheng/list", "biyeshengModel", model);
    }
    /**
     * 获取 form 表单页面
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @GetMapping("/add")
    public ModelAndView createForm(Model model) {
        model.addAttribute("biyesheng", new Biyesheng());
        return new ModelAndView("/admin/biyesheng/edit", "biyeshengModel", model);
    }

    /**
     * 新建和更新教研工作
     * @param biyesheng


     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @PostMapping("/update")
    public ResponseEntity<Response> create( Biyesheng biyesheng) {


        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

           //新建教研工作
            if(biyesheng.getId()==null){
                biyesheng.setHit(0);
                biyesheng.setPublisher(user);
                biyesheng.setPublishTime(new Date());
                biyesheng.setUpdateTime(new Date());
                biyesheng.setUpdateUser(user);

            }else{
                //更新教研工作,对于表单中没有出现的字段要把原来的值付给它们
                Biyesheng originalBiyesheng=biyeshengService.getBiyeshengById(biyesheng.getId());
                biyesheng.setHit(originalBiyesheng.getHit());
                biyesheng.setPublisher(originalBiyesheng.getPublisher());
                biyesheng.setPublishTime(originalBiyesheng.getPublishTime());
                biyesheng.setUpdateTime(new Date());
                biyesheng.setUpdateUser(user);

            }

            biyeshengService.saveBiyesheng(biyesheng);
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
            biyeshengService.removeBiyesheng(id);
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
        Biyesheng biyesheng = biyeshengService.getBiyeshengById(id);
        model.addAttribute("biyesheng", biyesheng);

        return new ModelAndView("admin/biyesheng/edit", "biyeshengModel", model);
    }

    @GetMapping(value = "homeList")
    public ModelAndView homeList(Model model) {
        Pageable pageable = new PageRequest(0, 20);
        Page<Biyesheng> page = biyeshengService.listBiyeshengsByTitleLike("", pageable);
        List<Biyesheng> list = page.getContent();    // 当前所在页面数据列表

        model.addAttribute("biyeshengList",list);
        model.addAttribute("title","学院动态");
        return new ModelAndView("biyeshengList", "biyeshengModel", model);
    }
    @GetMapping(value = "view/{id}")
    public ModelAndView homeView(@PathVariable("id") Long id, Model model) {
        Biyesheng biyesheng = biyeshengService.getBiyeshengById(id);
        biyesheng.setHit(biyesheng.getHit()+1);
        biyeshengService.saveBiyesheng(biyesheng);
        model.addAttribute("biyesheng", biyesheng);
        model.addAttribute("title","学院动态");
        return new ModelAndView("biyeshengView", "biyeshengModel", model);
    }
}
