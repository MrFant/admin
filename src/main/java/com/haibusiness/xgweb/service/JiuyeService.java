package com.haibusiness.xgweb.service;

import com.haibusiness.xgweb.domain.Jiuye;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JiuyeService {
    Jiuye saveJiuye(Jiuye dongtai);


    void removeJiuye(Long id);


    void removeJiuyesInBatch(List<Jiuye> jiuyes);

    Jiuye updateJiuye(Jiuye jiuye);

    Jiuye getJiuyeById(Long id);


    List<Jiuye> listJiuyes();


    Page<Jiuye> listJiuyesByNameLike(String name, Pageable pageable);
}
