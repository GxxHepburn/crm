package com.gxx.crm.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

/**
 * @author gxx
 * @create 2021-07-06 2:50
 */
public abstract class BaseService<T, ID> {

    @Autowired
    private BaseMapper<T, ID> baseMapper;

    /**
     * 添加记录返回行数
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public Integer insertSelective(T entity) throws DataAccessException {
        return baseMapper.insertSelective(entity);
    }


}
