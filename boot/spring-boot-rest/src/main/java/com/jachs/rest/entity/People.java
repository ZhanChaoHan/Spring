package com.jachs.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "People")
public class People {
	@Id
	private int PId;

	@Column(name = "PName")
	private String PName;
	@Column(name = "PRealName")
	private String PRealName;
}
