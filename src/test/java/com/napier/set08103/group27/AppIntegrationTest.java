package com.napier.set08103.group27;

import com.napier.set08103.group27.data.City;
import com.napier.set08103.group27.data.Country;
import com.napier.set08103.group27.data.Languages;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {
    static DatabaseManager databaseManager;
    static DataStore dataStore = DataStore.getInstance();

    @BeforeAll
    static void init()
    {
        databaseManager = new DatabaseManager();
        databaseManager.connect("localhost:33060");
    }

    @Test
    void testGetCity()
    {
        databaseManager.readCities();
        City city = dataStore.getCityHashMap().get(3);
        assertEquals(3, city.getId());
        assertEquals("Herat", city.getName());
        assertEquals("AFG", city.getCountryCode());
        assertEquals("Herat", city.getDistrict());
        assertEquals(186800, city.getPopulation());
        dataStore.clear();
    }

    @Test
    void testGetCountry()
    {
        databaseManager.readCountries();
        Country country = dataStore.getCountriesHashMap().get("AGO");
        assertEquals("AFG", country.getCode());
        assertEquals("Afghanistan", country.getName());
        assertEquals("Asia", country.getContinent());
        assertEquals("Southern and Central Asia", country.getRegion());
        assertEquals(652090.00, country.getSurfaceArea());
        assertEquals(1919, country.getIndepYear());
        assertEquals(22720000, country.getPopulation());
        assertEquals(45.9, country.getLifeExpectancy());
        assertEquals(5976.00, country.getGNP());
        assertEquals(null, country.getGNPOld());
        assertEquals("Afganistan/Afqanestan", country.getLocalName());
        assertEquals("Islamic Emirate", country.getGovernmentForm());
        assertEquals("Mohammad Omar", country.getHeadOfState());
        assertEquals(1, country.getCapital());
        assertEquals("AF", country.getCode2());
        dataStore.clear();
    }

    @Test
    void testGetLanguages()
    {
        databaseManager.readLanguages();
        ArrayList<Languages> languages = dataStore.getLanguageHashMap().get("ABW");

        assertEquals("ABW", languages.get(0).getCountryCode());
        assertEquals("Dutch", languages.get(0).getLanguage());
        assertEquals(true, languages.get(0).isOfficial());
        assertEquals(5.3, languages.get(0).getPercentage());

        assertEquals("ABW", languages.get(1).getCountryCode());
        assertEquals("English", languages.get(1).getLanguage());
        assertEquals(false, languages.get(1).isOfficial());
        assertEquals(9.5, languages.get(1).getPercentage());

        assertEquals("ABW", languages.get(2).getCountryCode());
        assertEquals("Papiamento", languages.get(2).getLanguage());
        assertEquals(false, languages.get(2).isOfficial());
        assertEquals(76.7, languages.get(2).getPercentage());

        assertEquals("ABW", languages.get(3).getCountryCode());
        assertEquals("Spanish", languages.get(3).getLanguage());
        assertEquals(false, languages.get(3).isOfficial());
        assertEquals(7.4, languages.get(3).getPercentage());
        dataStore.clear();
    }
}
