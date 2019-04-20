package com.haibusiness.xgweb.dao;

import com.haibusiness.xgweb.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Long> {
    Page<User> findByNameLike(String name, Pageable pageable);

    User findByUsername(String username);
}
