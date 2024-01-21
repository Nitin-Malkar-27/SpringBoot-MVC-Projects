package com.nit.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nit.model.HumanActivities;

public interface IHumanActivitiesRepo extends CrudRepository<HumanActivities, String> {

	// hql query
	@Query("SELECT hobbies FROM HumanActivities")
	public Set<String> getAllHobbies();

	@Query("SELECT gender FROM HumanActivities")
	public Set<String> getGender();
}
