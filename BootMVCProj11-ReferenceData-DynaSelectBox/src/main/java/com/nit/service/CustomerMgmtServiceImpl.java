package com.nit.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.nit.repository.IHumanActivitiesRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private IHumanActivitiesRepo humanRepo;

	@Autowired
	private Environment env;

	@Override
	public Set<String> getAllCountries() {
		Locale[] locales = Locale.getAvailableLocales();
		Set<String> countriesSet = new TreeSet();
		for (Locale l : locales) {
			countriesSet.add(l.getDisplayCountry());
		}
		return countriesSet;
	}

	@Override
	public Set<String> getAllLanguages() {

		Locale[] locales = Locale.getAvailableLocales();
		Set<String> languagesSet = new TreeSet();
		for (Locale l : locales) {
			languagesSet.add(l.getDisplayLanguage());
		}
		return languagesSet;
	}

	@Override
	public Set<String> getAllHobbies() {

		return humanRepo.getAllHobbies();
	}

	@Override
	public Set<String> getGenders() {

		return humanRepo.getGender();
	}

	@Override
	public List<String> getStatesByContry(String country) {
		// gets the from Properties file using Environment object
		String statesInfo = env.getRequiredProperty(country);
		System.out.println(statesInfo);
		List<String> statesList = Arrays.asList(statesInfo.split(","));
		System.out.println(statesList);
		Collections.sort(statesList);
		return statesList;
	}

}
