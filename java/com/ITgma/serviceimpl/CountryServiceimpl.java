package com.ITgma.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITgma.entities.Country;
import com.ITgma.repository.CountryRepository;
import com.ITgma.service.CountryService;


@Service
public class CountryServiceimpl implements CountryService {
	
	@Autowired
	private CountryRepository countryRepo;
	
	
	// -----------------------------------------------

	@Override
	public List<Country> getAllCountries() {
			List<Country> findAll = countryRepo.findAll();
			return findAll;
	}
	
	// -----------------------------------------------

	 @Override
	    public List<Country> getCountriesByRegion(String countryRegion) {
	        return null;  // --> There is some mistake.
	    }

	
	// -----------------------------------------------

	@Override
	public Map<String, Integer> getRegionTotals() {
		
		    List<Country> countries = countryRepo.findAll();
		    Map<String, Integer> regionTotals = new HashMap<>();
		    for (Country country : countries) 
		    {
		      String region = country.getCountryRegion();
		      int currentCount = regionTotals.getOrDefault(region, 0);
		      regionTotals.put(region, currentCount + 1);
		    }
		    return regionTotals;
		  }
	
	
	
	//	#######################################################

	@Override
	public Country createFavourite(Country country) {
		Country create = countryRepo.save(country);
		return create;
	}

	@Override
	public List<Country> getFavourites() {
		List<Country> findAll = countryRepo.findAll();
		return findAll;
	}

	@Override
	public Country updateFavourite(Country country, long id) {
		Optional<Country> findById = countryRepo.findById(id);
		Country coun = new Country();
		coun.setId(country.getId());			
		coun.setCountryName(country.getCountryName());
		coun.setCountryCapital(country.getCountryCapital());
		coun.setCountryRegion(country.getCountryRegion());
		coun.setDefaultCurrencyCode(country.getDefaultCurrencyCode());
		coun.setDefaultCurrencyName(country.getDefaultCurrencyName());
		coun.setDefaultCurrencySymbol(country.getDefaultCurrencySymbol());
		coun.setDefaultLanguageName(country.getDefaultLanguageName());
		Country save = countryRepo.save(coun);
		 return save;
	}

	@Override
	public void deleteFavourite(long id) {
		countryRepo.deleteById(id);
	}

	
}
