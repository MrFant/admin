package com.haibusiness.xgweb.dao;

import com.haibusiness.xgweb.domain.Dongtai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DongtaiDao extends JpaRepository<Dongtai,Long> {
    Page<Dongtai> findByTitleLikeOrderByPublishTimeDesc(String title, Pageable pageable);
}
