package com.jachs.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jachs.rest.entity.People;

/**
 * get请求访问地址:http://127.0.0.1:8080/api/people<br>
 * @RepositoryRestResource<br>
 * exported：是否暴露当前接口，默认暴露<br>
 * path:rest接口访问地址<br>
 * collectionResourceRel：生成指向集合资源的链接时要使用的rel值。<br>
 * 
 * @author zhanchaohan
 * 
 */
@RepositoryRestResource(path = "people")
public interface PeopleRepository extends JpaRepository<People, Integer> {

}
