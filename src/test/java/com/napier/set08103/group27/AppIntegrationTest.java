package com.napier.set08103.group27;

import com.napier.set08103.group27.data.City;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {
    static DatabaseManager databaseManager;
    static DataStore dataStore = DataStore.getInstance();

    @BeforeAll
    static void init()
    {
        databaseManager = new DatabaseManager();
        databaseManager.connect("db:33060");
    }

    @Test
    void testGetCity()
    {
        databaseManager.readCities();
        City city = dataStore.getCityHashMap().get(3);
        assertEquals(city.getId(), 3);
        assertEquals(city.getName(), "Herat");
        assertEquals(city.getCountryCode(), "AFG");
        assertEquals(city.getDistrict(), "Herat");
        assertEquals(city.getPopulation(), 186800);
    }
}
