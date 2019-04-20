package com.haibusiness.xgweb.service;

import com.haibusiness.xgweb.dao.AuthorityDao;
import com.haibusiness.xgweb.domain.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService{
    @Autowired
    private AuthorityDao authorityDao;


    public Authority getAuthorityById(Long id) {
        return authorityDao.getOne(id);
    }
}
