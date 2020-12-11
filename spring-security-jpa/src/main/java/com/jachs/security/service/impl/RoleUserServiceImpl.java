package com.jachs.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jachs.security.dao.RoleUserRepository;
import com.jachs.security.entity.RoleUser;
import com.jachs.security.service.RoleUserService;

/****
 * RoleUser增删改查
 * 
 * @author zhanchaohan
 * @PreAuthorize支持Spring EL表达式
 * @see org.springframework.security.access.expression
 */
@Service
public class RoleUserServiceImpl implements RoleUserService {
    @Autowired
    private RoleUserRepository roleUserDao;

    @Override
    public List<RoleUser> findAll () {
        return roleUserDao.findAll ();
    }



}
