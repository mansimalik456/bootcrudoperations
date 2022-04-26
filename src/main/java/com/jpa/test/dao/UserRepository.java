package com.jpa.test.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpa.test.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	
	
}
