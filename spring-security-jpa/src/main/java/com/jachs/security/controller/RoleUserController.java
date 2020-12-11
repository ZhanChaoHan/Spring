package com.jachs.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jachs.security.entity.RoleUser;
import com.jachs.security.service.RoleUserService;

@Controller
@RequestMapping( "/roleuser" )
@PreAuthorize("hasRole('ROLE_ADMIN')")//只让ADMIN用户访问
public class RoleUserController {
    @Autowired
    private RoleUserService roleUserService;
    
    @RequestMapping("/queryAllRoleUser")
    @ResponseBody
    public List<RoleUser> queryAllRoleUser() {
        return roleUserService.findAll();
    }
}
