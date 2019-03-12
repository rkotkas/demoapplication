package com.example.demo.service;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    public CountryRepository countryRepository;

    public Iterable<Country> getCountryList() {
        return countryRepository.findAll();
    }

}