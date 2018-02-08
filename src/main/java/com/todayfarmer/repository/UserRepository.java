package com.todayfarmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todayfarmer.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findOneByEmail(String email);
	public User findOneByNickname(String nickname);
}
