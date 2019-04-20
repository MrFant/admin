package com.haibusiness.xgweb.service;

import com.haibusiness.xgweb.domain.Tupian;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TupianService {
    Tupian saveTupian(Tupian tupian);


    void removeTupian(Long id);


    void removeTupiansInBatch(List<Tupian> tupians);

    Tupian updateTupian(Tupian tupian);

    Tupian getTupianById(Long id);


    List<Tupian> listTupians();


    Page<Tupian> listTupiansByNameLike(String name, Pageable pageable);
}
