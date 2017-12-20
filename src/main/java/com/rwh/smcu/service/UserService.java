package com.rwh.smcu.service;

import com.rwh.smcu.core.base.BaseDao;
import com.rwh.smcu.core.base.TestBaseDao;
import com.rwh.smcu.dao.UserDao;
import com.rwh.smcu.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 时间序列测试
 *
 * @author <a href="mailto:simling82@gmail.com">Simling</a>
 * @version v1.0 on 2017/8/3
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

//    @Autowired
//    private BaseDao<User> baseDao;

//    @Autowired
//    private BaseDao<User> userDao;

    public User add(User user){
        logger.info("add:"+user);
        return userDao.save(user);
    }

    public User update(User user){
        logger.info("update:"+user);
        return userDao.save(user);
    }

    public User get(Long id){
        logger.info("get:"+id);
        return userDao.findOne(id);
//        return this.get(id);
    }

    public Page<User> findAll(Pageable pageable){
        logger.info("findAll:"+pageable);
        return userDao.findAll(pageable);
    }

    public List<User> queryUserByName(String name){
        logger.info("queryUserByName:"+name);
        return userDao.queryUserByName(name);
    }
}
