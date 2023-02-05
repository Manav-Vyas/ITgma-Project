package com.ITgma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ITgma.entities.Country;


public interface CountryRepository extends JpaRepository<Country, Long> {


}
