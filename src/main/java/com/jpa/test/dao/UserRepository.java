package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpa.test.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	public List<User> findAllByName(String name);
	
	public List<User> findAllByNameAndCity(String name, String city);
	
	
}
