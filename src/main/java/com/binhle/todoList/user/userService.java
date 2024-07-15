package com.binhle.todoList.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
	@Autowired private UserRepository repo;
	
	public List<user> listAll(){
		return (List<user>) repo.findAll();
	}

	public void save(user user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}
	public user get(Integer id) throws UserNotFoundException {
		Optional<user> result = repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		throw new UserNotFoundException("Could not find any users with ID "+ id);
	}
	
	public void delete(Integer id) throws UserNotFoundException {
		Long count = repo.countById(id);
		if(count ==null || count ==0) {
			throw new UserNotFoundException("Could not find any users with ID "+ id);

		}
		repo.deleteById(id);
	}
}
