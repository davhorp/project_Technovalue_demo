package com.devit.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devit.demo.entitys.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long>{

	
}
