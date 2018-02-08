package com.todayfarmer.domain;

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
@ToString(exclude={"user"})
@EqualsAndHashCode(exclude={"user"})
@Entity
public class MyCrop {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	@ManyToOne
	@JoinColumn(name="userId")
	User user;
	String crop;
}
