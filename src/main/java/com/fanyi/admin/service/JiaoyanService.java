package com.fanyi.admin.service;

import com.fanyi.admin.domain.Jiaoyan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JiaoyanService {
    Jiaoyan saveJiaoyan(Jiaoyan jiaoyan);


    void removeJiaoyan(Long id);


    void removeJiaoyansInBatch(List<Jiaoyan> jiaoyans);

    Jiaoyan updateJiaoyan(Jiaoyan jiaoyan);

    Jiaoyan getJiaoyanById(Long id);


    List<Jiaoyan> listJiaoyans();


    Page<Jiaoyan> listJiaoyansByTypeAndTitleLike(String type,String title, Pageable pageable);
}
