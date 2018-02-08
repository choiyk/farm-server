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
@ToString(exclude={"type"})
@EqualsAndHashCode(exclude={"type"})
@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	String email;
	String pw;
	String nickname;
	@ManyToOne
	@JoinColumn(name="typeId")
	Type type;

}
