package com.fanyi.admin.service;

import com.fanyi.admin.dao.JiaoyanDao;
import com.fanyi.admin.domain.Jiaoyan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class JiaoyanServiceImpl implements JiaoyanService {

    @Autowired
    private JiaoyanDao jiaoyanDao;
    @Override
    public Jiaoyan saveJiaoyan(Jiaoyan jiaoyan) {
        return jiaoyanDao.save(jiaoyan);
    }

    @Override
    public void removeJiaoyan(Long id) {
        jiaoyanDao.delete(id);
    }

    @Override
    public void removeJiaoyansInBatch(List<Jiaoyan> jiaoyans) {
        jiaoyanDao.deleteInBatch(jiaoyans);
    }

    @Override
    public Jiaoyan updateJiaoyan(Jiaoyan jiaoyan) {
        return jiaoyanDao.save(jiaoyan);
    }

    @Override
    public Jiaoyan getJiaoyanById(Long id) {
        return jiaoyanDao.getOne(id);
    }

    @Override
    public List<Jiaoyan> listJiaoyans() {
        return jiaoyanDao.findAll();
    }

    @Override
    public Page<Jiaoyan> listJiaoyansByTypeAndTitleLike(String type,String title, Pageable pageable) {

        title = "%" + title + "%";
        Page<Jiaoyan> jiaoyans = jiaoyanDao.findByTypeAndTitleLikeOrderByPublishTimeDesc(type, title, pageable);
        return jiaoyans;
    }
}
