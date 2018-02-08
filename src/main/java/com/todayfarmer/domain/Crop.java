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
@ToString(exclude={"cropCategory"})
@EqualsAndHashCode(exclude={"cropCategory"})
@Entity
public class Crop {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	String name;
	@ManyToOne
	@JoinColumn(name="categoryId")
	CropCategory cropCategory;
}
