package com.todayfarmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todayfarmer.domain.Content;

public interface ContentRepository extends JpaRepository<Content, Integer>  {

}
