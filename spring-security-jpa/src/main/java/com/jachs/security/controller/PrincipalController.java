package com.jachs.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jachs.security.entity.custom.Principal;
import com.jachs.security.service.PrincipalService;
import com.jachs.security.service.TeacherService;

/**
 * @author zhanchaohan
 *  校长Controller
 *  @see org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer
 *  全部可以拦截的都是这个类，功能强大,可以拦截类可以拦截方法
 *  hasRole([role])\t\t当前用户是否拥有指定角色。
 *  hasAnyRole([role1,role2])\t\t多个角色是一个以逗号进行分隔的字符串。如果当前用户拥有指定角色中的任意一个则返回true。
 *  hasAuthority([auth])\t\t等同于hasRole
 *  hasAnyAuthority([auth1,auth2])\t\t等同于hasAnyRole
 *  Principle\t\t代表当前用户的principle对象
 *  authentication\t\t直接从SecurityContext获取的当前Authentication对象
 *  permitAll\t\t总是返回true，表示允许所有的
 *  denyAll\t\t总是返回false，表示拒绝所有的
 *  isAnonymous()\t\t当前用户是否是一个匿名用户
 *  isRememberMe()\t\t表示当前用户是否是通过Remember-Me自动登录的
 *  isAuthenticated()\t\t表示当前用户是否已经登录认证成功了。
 *  isFullyAuthenticated()\t\t如果当前用户既不是一个匿名用户，同时又不是通过Remember-Me自动登录的，则返回true。
 */
@Controller
@RequestMapping("/principal")
@PreAuthorize("hasRole('ROLE_Principal') or hasRole('ROLE_ADMIN')")
public class PrincipalController {
    @Autowired
    private PrincipalService principalService;
    @Autowired
    private TeacherService teacherService;
    
    @RequestMapping("/queryAllPrincipal")
    @ResponseBody
    public List<Principal> queryAllPrincipal() {
        return principalService.findAll();
    }
    
    @PreAuthorize("hasRole('ROLE_Principal')")//ROLE_ADMIN不让查当前登录的校长信息因为他不是，只能让当前登录的校长用户查
    @RequestMapping("/queryMySelf")
    @ResponseBody
    public Principal queryMySelf() {
    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return principalService.queryMySelf(authentication.getName());
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")//超级用户才能删校长，校长不能
    @RequestMapping("/deleteOnePrincipal")
    @ResponseBody
    public List<Principal> deleteOnePrincipal(String PrincipalName) {
         principalService.deleteOnePrincipal(PrincipalName);
         
         return principalService.findAll();
    }
    
    
}
