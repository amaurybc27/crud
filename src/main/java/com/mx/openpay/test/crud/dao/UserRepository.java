package com.mx.openpay.test.crud.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mx.openpay.test.crud.model.User;

/**
 * Interface for generic CRUD operations for a user.
 * @author abc
 *
 */
public interface UserRepository extends CrudRepository<User, Integer>{

	@Override
	List<User> findAll();
}
