package com.fanyi.admin.service;

import com.fanyi.admin.domain.Authority;
import com.fanyi.admin.dao.AuthorityDao;
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
