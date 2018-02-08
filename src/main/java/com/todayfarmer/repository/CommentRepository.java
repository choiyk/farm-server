package com.todayfarmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todayfarmer.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>  {

}
