package com.nit.service;

import java.util.List;
import java.util.Set;

public interface ICustomerMgmtService {

	public Set<String> getAllCountries();

	public Set<String> getAllLanguages();

	public Set<String> getAllHobbies();

	public Set<String> getGenders();

	public List<String> getStatesByContry(String country);
}
