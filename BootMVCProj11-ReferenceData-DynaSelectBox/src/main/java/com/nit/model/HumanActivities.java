package com.nit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "HUMAN_ACTIVITIES")
public class HumanActivities {

	@Id
	private String hobbies;
	private String gender;
}
