package com.nit.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CRICKETER_INFO")
@Data
public class Cricketer {
	@Id
	@GeneratedValue
	private Integer cid;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String type;
	private Date dob;
	private Date doj = new Date(110, 11, 20);

}
