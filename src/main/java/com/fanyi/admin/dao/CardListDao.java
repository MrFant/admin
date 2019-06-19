package com.fanyi.admin.dao;

import com.fanyi.admin.domain.CardListInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardListDao extends JpaRepository<CardListInfo,Long> {
//    CardListInfo getCardListInfoById(long id);
}
