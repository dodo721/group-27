package com.napier.set08103.group27;

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
}
