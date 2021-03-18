package com.jachs.mybatis.dao;

import com.jachs.mybatis.entity.Soft_ware;

public interface Soft_wareMapper {
    int deleteByPrimaryKey(String softWareId);

    int insert(Soft_ware record);

    int insertSelective(Soft_ware record);

    Soft_ware selectByPrimaryKey(String softWareId);

    int updateByPrimaryKeySelective(Soft_ware record);

    int updateByPrimaryKey(Soft_ware record);
}