package com.haibusiness.xgweb.dao;

import com.haibusiness.xgweb.domain.Jiaoyan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JiaoyanDao extends JpaRepository<Jiaoyan,Long> {
    Page<Jiaoyan> findByTypeAndTitleLikeOrderByPublishTimeDesc(String type,String title,Pageable pageable);

}
