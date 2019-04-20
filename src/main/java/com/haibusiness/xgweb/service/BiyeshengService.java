package com.haibusiness.xgweb.service;

import com.haibusiness.xgweb.domain.Biyesheng;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BiyeshengService {

    Biyesheng saveBiyesheng(Biyesheng biyesheng);


    void removeBiyesheng(Long id);


    void removeBiyeshengsInBatch(List<Biyesheng> biyeshengs);

    Biyesheng updateBiyesheng(Biyesheng biyesheng);

    Biyesheng getBiyeshengById(Long id);


    List<Biyesheng> listBiyeshengs();


    Page<Biyesheng> listBiyeshengsByTitleLike(String title, Pageable pageable);
}
