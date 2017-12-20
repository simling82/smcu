//package com.rwh.smcu.core.base;
//
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.NoRepositoryBean;
//import org.springframework.stereotype.Repository;
//
///**
// * 时间序列测试
// *
// * @author <a href="mailto:simling82@gmail.com">Simling</a>
// * @version v1.0 on 2017/8/8
// */
//
////@Repository
//@CacheConfig(cacheResolver = "defaultCacheResolver")
//public interface BaseDao1<T> extends JpaRepository<T, Long> {
//
//    @CachePut(key = "#p0.id")
//    public <S extends T> S save(S entity);
//
//    @Cacheable(cacheNames = "get", key = "#p0")
//    public T findOne(Long id);
//}
