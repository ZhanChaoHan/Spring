package com.jachs.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jachs.rest.dao.PeopleRepository;
import com.jachs.rest.entity.People;

/***
 * 不直接使用rest
 * @author zhanchaohan
 *
 */
@RestController
@RequestMapping("/api/peoplec")
public class PeopleController {
	@Autowired
	private PeopleRepository peopleRepository;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object insert(People people) {
        return peopleRepository.save(people);
    }
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Integer pId) {
         peopleRepository.deleteById(pId);
    }
}
