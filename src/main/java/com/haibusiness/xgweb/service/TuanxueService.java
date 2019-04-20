package com.haibusiness.xgweb.service;

import com.haibusiness.xgweb.domain.Tuanxue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TuanxueService {
    Tuanxue saveTuanxue(Tuanxue tuanxue);


    void removeTuanxue(Long id);


    void removeTuanxuesInBatch(List<Tuanxue> tuanxues);

    Tuanxue updateTuanxue(Tuanxue tuanxue);

    Tuanxue getTuanxueById(Long id);


    List<Tuanxue> listTuanxues();


    Page<Tuanxue> listTuanxuesByNameLike(String name, Pageable pageable);
}
