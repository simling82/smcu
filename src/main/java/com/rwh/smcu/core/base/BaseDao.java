package com.rwh.smcu.core.base;

import com.rwh.smcu.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 时间序列测试
 *
 * @author <a href="mailto:simling82@gmail.com">Simling</a>
 * @version v1.0 on 2017/8/8
 */
@NoRepositoryBean
@CacheConfig(cacheNames = "UserDao", cacheResolver = "defaultCacheResolver")
public interface BaseDao<T> extends JpaRepository<T, Long> {

    @CachePut(key = "#p0.id")
    public <S extends T> S save(S entity);

    @Cacheable(key = "#p0")
    public T findOne(Long id);
}
