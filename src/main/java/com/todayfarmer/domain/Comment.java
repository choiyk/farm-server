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
@ToString(exclude={"user", "content", "pcomment"})
@EqualsAndHashCode(exclude={"user", "content", "pcomment"})
@Entity
public class Comment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	String comment;
	Date postDate;
	int del;
	@ManyToOne
	@JoinColumn(name="userId")
	User user;
	@ManyToOne
	@JoinColumn(name="contentId")
	Content content;
	@ManyToOne
	@JoinColumn(name="pcommentId")
	Comment pcomment;
}
