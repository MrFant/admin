package com.haibusiness.xgweb.service;

import com.haibusiness.xgweb.domain.Lianjie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LianjieService {
    Lianjie saveLianjie(Lianjie lianjie);


    void removeLianjie(Long id);


    void removeLianjiesInBatch(List<Lianjie> lianjies);

    Lianjie updateLianjie(Lianjie lianjie);

    Lianjie getLianjieById(Long id);


    List<Lianjie> listLianjies();


    Page<Lianjie> listLianjiesByNameLike(String name, Pageable pageable);
}
