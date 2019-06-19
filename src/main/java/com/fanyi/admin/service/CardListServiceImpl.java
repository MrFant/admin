package com.fanyi.admin.service;

import com.fanyi.admin.dao.CardListDao;
import com.fanyi.admin.domain.CardListInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardListServiceImpl implements CardListService{
    @Autowired
    CardListDao cardListDao;

    @Override
    public CardListInfo getCardListInfo(long id) {
        return cardListDao.getOne(id);
    }

    @Override
    public List<CardListInfo> getCardListInfos(long size) {
        return cardListDao.findAll();
    }
}
