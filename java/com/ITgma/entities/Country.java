package com.ITgma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country_info")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "country_name")
	private String countryName;

	@Column(name = "country_capital")
	private String countryCapital;

	@Column(name = "country_region")
	private String countryRegion;

	@Column(name = "currency_code")
	private String defaultCurrencyCode;

	@Column(name = "currency_name")
	private String defaultCurrencyName;

	@Column(name = "currency_symbol")
	private String defaultCurrencySymbol;

	@Column(name = "language_name")
	private String defaultLanguageName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCapital() {
		return countryCapital;
	}

	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}

	public String getCountryRegion() {
		return countryRegion;
	}

	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}

	public String getDefaultCurrencyCode() {
		return defaultCurrencyCode;
	}

	public void setDefaultCurrencyCode(String defaultCurrencyCode) {
		this.defaultCurrencyCode = defaultCurrencyCode;
	}

	public String getDefaultCurrencyName() {
		return defaultCurrencyName;
	}

	public void setDefaultCurrencyName(String defaultCurrencyName) {
		this.defaultCurrencyName = defaultCurrencyName;
	}

	public String getDefaultCurrencySymbol() {
		return defaultCurrencySymbol;
	}

	public void setDefaultCurrencySymbol(String defaultCurrencySymbol) {
		this.defaultCurrencySymbol = defaultCurrencySymbol;
	}

	public String getDefaultLanguageName() {
		return defaultLanguageName;
	}

	public void setDefaultLanguageName(String defaultLanguageName) {
		this.defaultLanguageName = defaultLanguageName;
	}

	

}