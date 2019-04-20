package com.haibusiness.xgweb.dao;

import com.haibusiness.xgweb.domain.Biyesheng;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiyeshengDao extends JpaRepository<Biyesheng,Long> {
    Page<Biyesheng> findByTitleLikeOrderByPublishTimeDesc(String title, Pageable pageable);
}
