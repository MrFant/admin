package com.haibusiness.xgweb.service;

import com.haibusiness.xgweb.domain.Tongzhi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TongzhiService {
    Tongzhi saveTongzhi(Tongzhi tongzhi);


    void removeTongzhi(Long id);


    void removeTongzhisInBatch(List<Tongzhi> tongzhis);

    Tongzhi updateTongzhi(Tongzhi tongzhi);

    Tongzhi getTongzhiById(Long id);


    List<Tongzhi> listTongzhis();


    Page<Tongzhi> listTongzhisByNameLike(String name, Pageable pageable);
}
