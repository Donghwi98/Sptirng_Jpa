package com.green.jpa_test.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.green.jpa_test.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByUsernameAndPassword(String username, String password);


}
