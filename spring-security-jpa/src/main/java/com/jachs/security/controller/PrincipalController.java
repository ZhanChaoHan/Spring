package com.jachs.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jachs.security.entity.custom.Principal;
import com.jachs.security.service.PrincipalService;

/**
 * @author zhanchaohan
 *  校长Controller
 *  @see org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer
 *  全部可以拦截的都是这个类，功能强大,可以拦截类可以拦截方法
 *  hasAnyRole
 *  hasRole
 *  hasAuthority
 *  hasAnyAuthority
 *  hasIpAddress
 *  AuthorizedUrl
 */
@Controller
@RequestMapping("/principal")
@PreAuthorize("hasRole('ROLE_Principal') or hasRole('ROLE_ADMIN')")
public class PrincipalController {
    @Autowired
    private PrincipalService principalService;
    
    @RequestMapping("/queryAllPrincipal")
    @ResponseBody
    public List<Principal> queryAllPrincipal() {
        return principalService.findAll();
    }
}
