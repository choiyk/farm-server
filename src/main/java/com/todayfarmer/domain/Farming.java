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
@ToString(exclude={"user", "myCrop"})
@EqualsAndHashCode(exclude={"user", "myCrop"})
@Entity
public class Farming {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	String title;
	String memo;
	Date startDate;
	Date endDate;
	int alarm;
	String postDate;
	@ManyToOne
	@JoinColumn(name="userId")
	User user;
	@ManyToOne
	@JoinColumn(name="cropId")
	MyCrop myCrop;
}
