package com.fanyi.admin.dao;

import com.fanyi.admin.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityDao extends JpaRepository<Authority,Long> {
}
