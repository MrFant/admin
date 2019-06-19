package com.fanyi.admin.service;

import com.fanyi.admin.domain.Article;

import java.util.List;

public interface ArticleService {
    Article getArticle(long id );
    List<Article> getALL();


}
