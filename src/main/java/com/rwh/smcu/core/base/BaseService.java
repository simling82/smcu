//package com.rwh.smcu.core.base;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//import java.io.Serializable;
//
///**
// * 时间序列测试
// *
// * @author <a href="mailto:simling82@gmail.com">Simling</a>
// * @version v1.0 on 2017/8/8
// */
//@CacheConfig(cacheResolver = "defaultCacheResolver")
//public abstract class BaseService<T> implements Service<T, Long> {
//
//    @Autowired
//    private BaseDao1<T> baseDao1;
//
//    @Override
//    public <S extends T> S add(S entity) {
//        return baseDao1.save(entity);
//    }
//
//    @Override
//    public <S extends T> S update(S entity) {
//        return null;
//    }
//
//    @Override
//    @Cacheable(cacheNames = "baseService", key = "#p0")
//    public T get(Long id) {
//        getClass().getTypeName();
//        return baseDao1.findOne(id);
//    }
//
//    @Override
//    public Page<T> findAll(Pageable pageable) {
//        return null;
//    }
//}
