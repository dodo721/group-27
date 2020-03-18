package com.napier.set08103.group27;

import com.napier.set08103.group27.data.RetrievePopulations;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RetrievePopulationsTest {
    private static DatabaseManager databaseManager;
    private RetrievePopulations retrievePopulations = new RetrievePopulations();
    private static DataStore dataStore = DataStore.getInstance();

    @BeforeAll
    static void init()
    {
        databaseManager = new DatabaseManager();
        databaseManager.connect("localhost:33060");
    }

    @Test
    void testWorldPopulation()
    {
        databaseManager.readCountries();
        long worldPop = retrievePopulations.getWorldPopulation();
        System.out.println("World population: " + worldPop);

        assertEquals(6078749450L, worldPop);
        dataStore.clear();
    }

    @Test
    void testContinentPopulation()
    {
        databaseManager.readCountries();
        //Testing output for Europe
        long continentPop = retrievePopulations.getContinentPopulation("Europe");
        System.out.println("Europe population: " + continentPop);

        assertEquals(730074600L, continentPop);
        dataStore.clear();
    }
}
