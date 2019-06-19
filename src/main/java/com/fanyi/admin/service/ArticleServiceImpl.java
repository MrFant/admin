package com.fanyi.admin.service;

import com.fanyi.admin.dao.ArticleDao;
import com.fanyi.admin.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    ArticleDao articleDao;

    @Override
    public Article getArticle(long id) {
        return articleDao.getOne(id);
    }

    @Override
    public List<Article> getALL() {
        return articleDao.findAll();
    }
}
