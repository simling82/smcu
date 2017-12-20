package com.rwh.smcu.dao;

import com.rwh.smcu.core.base.BaseDao;
import com.rwh.smcu.entity.User;
import org.springframework.cache.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 基础接口继承CRUD和Page
 *
 * @author <a href="mailto:simling82@gmail.com">Simling</a>
 * @version v1.0 on 2017/8/3
 */
@CacheConfig(cacheNames = "UserDao")
public interface UserDao extends JpaRepository<User, Long> {

    @CachePut(key = "#p0.id")
    @Caching(evict={@CacheEvict(key="#p0.username"), @CacheEvict(key="'findAll'")})
    public User save(User user);

    @Cacheable(key = "#p0")
    public User findOne(Long id);

    @Cacheable(key = "'queryUserByName'")
    @Query("select u from User u where u.username like %?1%")
    public List<User> queryUserByName(String name);

    @Cacheable(key = "'findAll'")
    public Page<User> findAll(Pageable pageable);

}
