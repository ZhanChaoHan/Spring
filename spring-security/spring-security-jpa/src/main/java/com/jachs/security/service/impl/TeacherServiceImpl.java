package com.jachs.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jachs.security.dao.custom.TeacherRepository;
import com.jachs.security.entity.custom.Teacher;
import com.jachs.security.service.TeacherService;

/**
 * @author zhanchaohan
 * 
 */
@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherRepository teacherRepository;
    
    
    @Override
    public List<Teacher> queryAllTeacher () {
        return teacherRepository.findAll ();
    }

}
