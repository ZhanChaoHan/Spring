package com.jachs.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jachs.security.entity.custom.Teacher;
import com.jachs.security.service.PrincipalService;
import com.jachs.security.service.TeacherService;

/**
 * @author zhanchaohan
 *  老师Controller
 */
@Controller
@RequestMapping("/techer")
@PreAuthorize("hasRole('ROLE_Principal') or hasRole('ROLE_ADMIN') or hasRole('ROLE_Teacher')")
public class TecherController {
    @Autowired
    private TeacherService teacherService;
    
    @RequestMapping("/queryAllPrincipal")
    @ResponseBody
    public List<Teacher> failure() {
        return teacherService.findAll();
    }
}
