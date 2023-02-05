package com.ITgma;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ITgma.entities.Country;
import com.ITgma.repository.CountryRepository;

@SpringBootTest
@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
class CountryApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	CountryRepository countryRepo;
	
	@Test
	@Order(1)
	public void testCreate () {
		
		Country coun = new Country();
		coun.setId(31L);
		coun.setCountryName("Akshay");
		coun.setCountryCapital("Nakum");
		coun.setCountryRegion("Bangalore");
		coun.setDefaultCurrencyCode("Rupees");
		coun.setDefaultCurrencyName("paisa");
		coun.setDefaultCurrencySymbol("$");
		coun.setDefaultLanguageName("Hindi");
		countryRepo.save(coun);
		assertNotNull(countryRepo.findById(1L).get());
	}
	
	@Test
	@Order(2)
	public void testReadAll() {
		List<Country> findAll = countryRepo.findAll();
		assertThat(findAll).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testSingleData() {
		Country countrySingle = countryRepo.findById(1L).get();
		assertEquals("India", countrySingle.getCountryName());
	}
	
	@Test
	@Order(4)
	public void testUpdate() {
		Country countrUpdate = countryRepo.findById(1L).get();
		countrUpdate.setDefaultLanguageName("Bengali");
		countryRepo.save(countrUpdate);
		assertNotEquals("Hindi", countryRepo.findById(1L).get().getDefaultLanguageName());
	}
	
	@Test
	@Order(5)
	public void testDelete() {
		countryRepo.deleteById(37L);      // Put the any value between 1L to 30L
		assertThat(countryRepo.existsById(37L)).isFalse();
	}
	
}
