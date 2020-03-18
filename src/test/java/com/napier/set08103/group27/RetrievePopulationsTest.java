package com.napier.set08103.group27;

import com.napier.set08103.group27.data.City;
import com.napier.set08103.group27.data.Country;
import com.napier.set08103.group27.data.RetrievePopulations;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RetrievePopulationsTest {
    private RetrievePopulations retrievePopulations = new RetrievePopulations();
    private static DataStore dataStore = DataStore.getInstance();

    @Test
    void testWorldPopulation()
    {
        String code = "ABC";
        String name = "TestCountry";
        String continent = "TestContinent";
        String region = "TestRegion";
        double surfaceArea = 5.55;
        int indepYear = 1990;
        int population = 123456789;
        double lifeExpectancy = 60.5;
        double gnp = 5.5;
        double gnpOld = 4.5;
        String localName = "counTree";
        String governmentForm = "Who";
        String headOfState = "me";
        int capital = 5;
        String code2 = "CBA";
        Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population, lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
        dataStore.addToCountry(country);


        long worldPop = retrievePopulations.getWorldPopulation();
        System.out.println("World population: " + worldPop);

        assertEquals(123456789L, worldPop);
        dataStore.clear();
    }

    @Test
    void testContinentPopulation()
    {
        //Testing output for Europe
        String code = "ABC";
        String name = "TestCountry";
        String continent = "Europe";
        String region = "TestRegion";
        double surfaceArea = 5.55;
        int indepYear = 1990;
        int population = 999999999;
        double lifeExpectancy = 60.5;
        double gnp = 5.5;
        double gnpOld = 4.5;
        String localName = "counTree";
        String governmentForm = "Who";
        String headOfState = "me";
        int capital = 5;
        String code2 = "CBA";
        Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population, lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
        dataStore.addToCountry(country);

        long continentPop = retrievePopulations.getContinentPopulation("Europe");
        System.out.println("Europe population: " + continentPop);

        assertEquals(999999999L, continentPop);
        dataStore.clear();
    }

    @Test
    void testRegionPopulation()
    {
        String code = "ABC";
        String name = "TestCountry";
        String continent = "Europe";
        String region = "TestRegion";
        double surfaceArea = 5.55;
        int indepYear = 1990;
        int population = 50505050;
        double lifeExpectancy = 60.5;
        double gnp = 5.5;
        double gnpOld = 4.5;
        String localName = "counTree";
        String governmentForm = "Who";
        String headOfState = "me";
        int capital = 5;
        String code2 = "CBA";
        Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population, lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
        dataStore.addToCountry(country);

        long regionPop = retrievePopulations.getRegionPopulation("TestRegion");
        System.out.println("TestRegion population: " + regionPop);

        assertEquals(50505050L, regionPop);
        dataStore.clear();
    }

    @Test
    void testCountryPopulation()
    {
        String code = "ABC";
        String name = "TestCountry";
        String continent = "Europe";
        String region = "TestRegion";
        double surfaceArea = 5.55;
        int indepYear = 1990;
        int population = 50505050;
        double lifeExpectancy = 60.5;
        double gnp = 5.5;
        double gnpOld = 4.5;
        String localName = "counTree";
        String governmentForm = "Who";
        String headOfState = "me";
        int capital = 5;
        String code2 = "CBA";
        Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population, lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
        dataStore.addToCountry(country);

        long countryPop = retrievePopulations.getCountryPopulation("ABC");
        System.out.println("TestRegion population: " + countryPop);

        assertEquals(50505050L, countryPop);
        dataStore.clear();
    }

    @Test
    void testDistrictPopulation()
    {
        int id = 5;
        String name = "Name";
        String countryCode = "AAA";
        String district = "district";
        int population = 10000;

        City city = new City(id, name, countryCode, district, population);
        dataStore.addToCity(city);

        long districtPop = retrievePopulations.getDistrictPopulation("district");
        System.out.println("District population: " + districtPop);

        assertEquals(10000, districtPop);
        dataStore.clear();
    }

    @Test
    void testCityPopulation()
    {
        int id = 5;
        String name = "Name";
        String countryCode = "AAA";
        String district = "district";
        int population = 5050;

        City city = new City(id, name, countryCode, district, population);
        dataStore.addToCity(city);

        long cityPop = retrievePopulations.getCityPopulation("Name");
        System.out.println("City population: " + cityPop);

        assertEquals(5050, cityPop);
        dataStore.clear();
    }
}
