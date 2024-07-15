package com.binhle.todoList.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<user, Integer> {
	public Long countById(Integer id);
}
