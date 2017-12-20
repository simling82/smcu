package com.rwh.smcu.core.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 * 时间序列测试
 *
 * @author <a href="mailto:simling82@gmail.com">Simling</a>
 * @version v1.0 on 2017/8/9
 */
public interface Service<T, ID extends Serializable> {

    public <S extends T> S add(S entity);

    public <S extends T> S update(S entity);

    public T get(ID id);

    public Page<T> findAll(Pageable pageable);
}
