package com.gxx.crm.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;

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

    /**
     * 添加记录返回主键
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public ID insertHasKey(T entity) throws DataAccessException {
        baseMapper.insertHasKey(entity);
        try {
            return (ID) entity.getClass().getMethod("getId").invoke(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 批量添加
     * @param entities
     * @return
     * @throws DataAccessException
     */
    public Integer insertBatch(List<T> entities) throws DataAccessException {
        return baseMapper.insertBatch(entities);
    }

    /**
     * 根据id 查询详情
     * @param id
     * @return
     * @throws DataAccessException
     */
    public T selectByPrimaryKey(ID id) throws DataAccessException {
        return baseMapper.selectByPrimaryKey(id);
    }

    /**
     * 多条件查询
     * @param baseQuery
     * @return
     * @throws DataAccessException
     */
    public List<T> selectByParams(BaseQuery baseQuery) throws DataAccessException {
        return baseMapper.selectByParams(baseQuery);
    }


}
