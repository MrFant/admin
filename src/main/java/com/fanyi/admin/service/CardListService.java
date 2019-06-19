package com.fanyi.admin.service;

import com.fanyi.admin.domain.CardListInfo;

import java.util.List;
import java.util.Optional;

public interface CardListService {

    CardListInfo getCardListInfo(long id);

    List<CardListInfo> getCardListInfos(long size);



}
