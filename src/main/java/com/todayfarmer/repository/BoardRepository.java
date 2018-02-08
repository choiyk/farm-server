package com.todayfarmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todayfarmer.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>  {

}
