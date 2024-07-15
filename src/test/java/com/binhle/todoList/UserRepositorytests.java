package com.binhle.todoList;

import java.util.Optional;

import org.apache.catalina.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.binhle.todoList.user.UserRepository;
import com.binhle.todoList.user.user;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositorytests {
	@Autowired private UserRepository repo;
	
	@Test
	public void testAddNew() {
		user user = new user();
		user.setEmail("aaaaaaa@gmail.com");
		user.setPassword("aaaaaaa");
		user.setFirstName("eaaaa");
		user.setLastName("naaaaaaa");
		
		user saveduser = repo.save(user);
		
		Assertions.assertThat(saveduser).isNotNull();
		
		Assertions.assertThat(saveduser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAll() {
		Iterable<user> users = repo.findAll();
		Assertions.assertThat(users).hasSizeGreaterThan(0);
		
		for (user user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testUpdate() {
		Integer userId = 1;
		Optional<user> optionaluser = repo.findById(userId);
		user user = optionaluser.get();
		user.setPassword("11111");
		repo.save(user);
		
		user updateduser = repo.findById(userId).get();
		Assertions.assertThat(updateduser.getPassword()).isEqualTo("11111");
	}
	@Test
	public void testget() {
		Integer userId = 2;
		Optional<user> optionaluser = repo.findById(userId);
		Assertions.assertThat(optionaluser).isPresent();
		user user = optionaluser.get();
		System.out.println(optionaluser.get());
		
		
 	}
	
	@Test
	public void testDelete() {
		Integer userId = 2;
		repo.deleteById(userId);
		
		Optional<user> optionaluser = repo.findById(userId);
		Assertions.assertThat(optionaluser).isNotPresent();
	}
}
