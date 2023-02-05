package com.ITgma.service;

import java.util.List;
import java.util.Map;

import com.ITgma.entities.Country;

public interface CountryService {
	
	// Countries list end point

	List<Country> getAllCountries();
	
	// Countries filter based on region end point

	List<Country> getCountriesByRegion(String countryRegion);
	
	// Total number of countries for each region end point

	Map<String, Integer> getRegionTotals();
	
	
//	-----------------------------------------------------------------
	
	
	// CRUD API for favorite countries end point

	Country createFavourite(Country country);

	List<Country> getFavourites();

	Country updateFavourite(Country country, long id);

	void deleteFavourite(long id);
	
	

}
