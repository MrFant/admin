package com.fanyi.admin.dao;

import com.fanyi.admin.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<Article,Long> {

}
