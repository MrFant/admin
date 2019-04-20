package com.fanyi.admin.service;

import com.fanyi.admin.domain.Xiazai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface XiazaiService {
    Xiazai saveXiazai(Xiazai xiazai);


    void removeXiazai(Long id);


    void removeXiazaisInBatch(List<Xiazai> xiazais);

    Xiazai updateXiazai(Xiazai xiazai);

    Xiazai getXiazaiById(Long id);


    List<Xiazai> listXiazais();


    Page<Xiazai> listXiazaisByNameLike(String name, Pageable pageable);
}
