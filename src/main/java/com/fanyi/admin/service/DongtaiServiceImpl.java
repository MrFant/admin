package com.fanyi.admin.service;

import com.fanyi.admin.domain.Dongtai;
import com.fanyi.admin.dao.DongtaiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DongtaiServiceImpl implements DongtaiService {

    @Autowired
    private DongtaiDao dongtaiDao;
    @Override
    public Dongtai saveDongtai(Dongtai dongtai) {
        return dongtaiDao.save(dongtai);
    }

    @Override
    public void removeDongtai(Long id) {
        dongtaiDao.deleteById(id);
    }

    @Override
    public void removeDongtaisInBatch(List<Dongtai> dongtais) {
        dongtaiDao.deleteInBatch(dongtais);
    }

    @Override
    public Dongtai updateDongtai(Dongtai dongtai) {
        return dongtaiDao.save(dongtai);
    }

    @Override
    public Dongtai getDongtaiById(Long id) {
        return dongtaiDao.getOne(id);
    }

    @Override
    public List<Dongtai> listDongtais() {
        return dongtaiDao.findAll();
    }

    @Override
    public Page<Dongtai> listDongtaisByTitleLike(String title, Pageable pageable) {

        title = "%" + title + "%";
        Page<Dongtai> dongtais = dongtaiDao.findByTitleLikeOrderByPublishTimeDesc(title, pageable);
        return dongtais;
    }
}
