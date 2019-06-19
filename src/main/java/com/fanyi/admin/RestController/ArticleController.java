package com.fanyi.admin.RestController;


import com.fanyi.admin.domain.Article;
import com.fanyi.admin.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Article")
public class ArticleController {

    private static final Logger logger= LoggerFactory.getLogger(CardListController.class);

    @Autowired
    ArticleService articleService;

    @GetMapping("/{id}")
    public List<Article> getArticle(@PathVariable Long id){
        List<Article> list=new ArrayList<>();
        list.add(articleService.getArticle(id));
        return list;
    }

    @GetMapping("all")
    public List<Article> getAll(){
        return articleService.getALL();
    }

}
