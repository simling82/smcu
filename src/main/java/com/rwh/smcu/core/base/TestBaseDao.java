package com.rwh.smcu.core.base;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 时间序列测试
 *
 * @author <a href="mailto:simling82@gmail.com">Simling</a>
 * @version v1.0 on 2017/8/8
 */
//@NoRepositoryBean
@CacheConfig(cacheResolver = "defaultCacheResolver")
@Service
public abstract class TestBaseDao<T> implements JpaRepository<T, Long> {

    @CachePut(key = "#p0.id")
    public abstract  <S extends T> S save(S entity);

    @Cacheable(cacheNames = "get", key = "#p0")
    public abstract T findOne(Long id);
}
