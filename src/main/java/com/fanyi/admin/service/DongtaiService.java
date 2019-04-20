package com.fanyi.admin.service;

import com.fanyi.admin.domain.Dongtai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DongtaiService {
    Dongtai saveDongtai(Dongtai dongtai);


    void removeDongtai(Long id);


    void removeDongtaisInBatch(List<Dongtai> dongtais);

    Dongtai updateDongtai(Dongtai dongtai);

    Dongtai getDongtaiById(Long id);


    List<Dongtai> listDongtais();


    Page<Dongtai> listDongtaisByTitleLike(String title, Pageable pageable);
}
