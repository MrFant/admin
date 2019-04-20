package com.fanyi.admin.service;

import com.fanyi.admin.domain.Biyesheng;
import com.fanyi.admin.dao.BiyeshengDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BiyeshengServiceImpl implements BiyeshengService {

    @Autowired
    private BiyeshengDao biyeshengDao;
    @Override
    public Biyesheng saveBiyesheng(Biyesheng biyesheng) {
        return biyeshengDao.save(biyesheng);
    }

    @Override
    public void removeBiyesheng(Long id) {
        biyeshengDao.delete(id);
    }

    @Override
    public void removeBiyeshengsInBatch(List<Biyesheng> biyeshengs) {
        biyeshengDao.deleteInBatch(biyeshengs);
    }

    @Override
    public Biyesheng updateBiyesheng(Biyesheng biyesheng) {
        return biyeshengDao.save(biyesheng);
    }

    @Override
    public Biyesheng getBiyeshengById(Long id) {
        return biyeshengDao.getOne(id);
    }

    @Override
    public List<Biyesheng> listBiyeshengs() {
        return biyeshengDao.findAll();
    }

    @Override
    public Page<Biyesheng> listBiyeshengsByTitleLike(String title, Pageable pageable) {

        title = "%" + title + "%";
        Page<Biyesheng> biyeshengs = biyeshengDao.findByTitleLikeOrderByPublishTimeDesc(title, pageable);
        return biyeshengs;
    }
}
