package com.fanyi.admin.service;

import com.fanyi.admin.domain.Hezuo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HezuoService {
    Hezuo saveHezuo(Hezuo hezuo);


    void removeHezuo(Long id);


    void removeHezuosInBatch(List<Hezuo> hezuos);

    Hezuo updateHezuo(Hezuo hezuo);

    Hezuo getHezuoById(Long id);


    List<Hezuo> listHezuos();


    Page<Hezuo> listHezuosByNameLike(String name, Pageable pageable);
}
