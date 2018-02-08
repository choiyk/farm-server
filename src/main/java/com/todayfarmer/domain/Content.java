package com.todayfarmer.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude={"user", "board"})
@EqualsAndHashCode(exclude={"user", "board"})
@Entity
public class Content {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	String title;
	String content;
	int like;
	int dislike;
	Date postDate;
	@ManyToOne
	@JoinColumn(name="userId")
	User user;
	@ManyToOne
	@JoinColumn(name="boardId")
	Board board;
}
