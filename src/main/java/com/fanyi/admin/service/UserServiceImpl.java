package com.fanyi.admin.service;

import com.fanyi.admin.domain.User;
import com.fanyi.admin.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService,UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;



    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }


    @Override
    public void removeUser(Long id) {
        userDao.delete(id);
    }


    @Override
    public void removeUsersInBatch(List<User> users) {
        userDao.deleteInBatch(users);
    }


    @Override
    public User updateUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getOne(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.findAll();
    }

    @Override
    public Page<User> listUsersByNameLike(String name, Pageable pageable) {
        // 模糊查询
        name = "%" + name + "%";
        Page<User> users = userDao.findByNameLike(name, pageable);
        return users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*
          这个方法不能返回null
         */
        User user=userDao.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException(username);
        }

        return user;


    }
}
