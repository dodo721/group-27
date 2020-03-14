package com.napier.set08103.group27;

import com.napier.set08103.group27.data.City;
import com.napier.set08103.group27.data.Country;
import com.napier.set08103.group27.data.Languages;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DataStoreTest {
    static DataStore dataStore;

    @BeforeAll
    static void init()
    {
        dataStore = DataStore.getInstance();
    }

    @Test
    void addCountriesWhenInputNull()
    {
        dataStore.addToCountry(null);
        for(String key : dataStore.getCountriesHashMap().keySet())
        {
            System.out.println("Country: " + key);
        }
    }

    @Test
    void addCityWhenInputNull()
    {
        dataStore.addToCity(null);
        for(int key : dataStore.getCityHashMap().keySet())
        {
            System.out.println("City: " + key);
        }
    }

    @Test
    void addLanguageWhenInputNull()
    {
        dataStore.addToLanguages(null);
        for(String key : dataStore.getLanguageHashMap().keySet())
        {
            System.out.println("Language: " + key);
        }
    }

    @Test
    void printCountriesEmpty()
    {
        for(String key : dataStore.getCountriesHashMap().keySet())
        {
            System.out.println("Country: " + key);
        }
    }

    @Test
    void printCitiesEmpty()
    {
        for(int key : dataStore.getCityHashMap().keySet())
        {
            System.out.println("City: " + key);
        }
    }

    @Test
    void printLanguageEmpty()
    {
        for(String key : dataStore.getLanguageHashMap().keySet())
        {
            System.out.println("Language: " + key);
        }
    }

    @Test
    void addCountries()
    {
        String code = "ABC";
        String name = "TestCountry";
        String continent = "TestContinent";
        String region = "TestRegion";
        double surfaceArea = 5.55;
        int indepYear = 1990;
        int population = 50000;
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

        for(String key : dataStore.getCountriesHashMap().keySet())
        {
            System.out.println("Country: " + dataStore.getCountriesHashMap().get(key).getCode()
                    + ", " + dataStore.getCountriesHashMap().get(key).getName()
                    + ", " + dataStore.getCountriesHashMap().get(key).getContinent()
                    + ", " + dataStore.getCountriesHashMap().get(key).getRegion()
                    + ", " + dataStore.getCountriesHashMap().get(key).getSurfaceArea()
                    + ", " + dataStore.getCountriesHashMap().get(key).getIndepYear()
                    + ", " + dataStore.getCountriesHashMap().get(key).getPopulation()
                    + ", " + dataStore.getCountriesHashMap().get(key).getLifeExpectancy()
                    + ", " + dataStore.getCountriesHashMap().get(key).getGNP()
                    + ", " + dataStore.getCountriesHashMap().get(key).getGNPOld()
                    + ", " + dataStore.getCountriesHashMap().get(key).getLocalName()
                    + ", " + dataStore.getCountriesHashMap().get(key).getGovernmentForm()
                    + ", " + dataStore.getCountriesHashMap().get(key).getHeadOfState()
                    + ", " + dataStore.getCountriesHashMap().get(key).getCapital()
                    + ", " + dataStore.getCountriesHashMap().get(key).getCode2());
        }

        assertEquals("ABC", dataStore.getCountriesHashMap().get(code).getCode());
        assertEquals("TestCountry", dataStore.getCountriesHashMap().get(code).getName());
        assertEquals("TestContinent", dataStore.getCountriesHashMap().get(code).getContinent());
        assertEquals("TestRegion", dataStore.getCountriesHashMap().get(code).getRegion());
        assertEquals(5.55, dataStore.getCountriesHashMap().get(code).getSurfaceArea());
        assertEquals(1990, dataStore.getCountriesHashMap().get(code).getIndepYear());
        assertEquals(50000, dataStore.getCountriesHashMap().get(code).getPopulation());
        assertEquals(60.5, dataStore.getCountriesHashMap().get(code).getLifeExpectancy());
        assertEquals(5.5, dataStore.getCountriesHashMap().get(code).getGNP());
        assertEquals(4.5, dataStore.getCountriesHashMap().get(code).getGNPOld());
        assertEquals("counTree", dataStore.getCountriesHashMap().get(code).getLocalName());
        assertEquals("Who", dataStore.getCountriesHashMap().get(code).getGovernmentForm());
        assertEquals("me", dataStore.getCountriesHashMap().get(code).getHeadOfState());
        assertEquals(5, dataStore.getCountriesHashMap().get(code).getCapital());
        assertEquals("CBA", dataStore.getCountriesHashMap().get(code).getCode2());

        dataStore.clear();
    }

    @Test
    void addCities()
    {
        int id = 5;
        String name = "Name";
        String countryCode = "AAA";
        String district = "district";
        int population = 10000;

        City city = new City(id, name, countryCode, district, population);
        dataStore.addToCity(city);

        for(int key : dataStore.getCityHashMap().keySet())
        {
            System.out.println("City: " + dataStore.getCityHashMap().get(key).getId()
                    + ", " + dataStore.getCityHashMap().get(key).getCountryCode()
                    + ", " + dataStore.getCityHashMap().get(key).getName()
                    + ", " + dataStore.getCityHashMap().get(key).getDistrict()
                    + ", " + dataStore.getCityHashMap().get(key).getPopulation());
        }
        assertEquals(5, dataStore.getCityHashMap().get(id).getId());
        assertEquals("Name", dataStore.getCityHashMap().get(id).getName());
        assertEquals("AAA", dataStore.getCityHashMap().get(id).getCountryCode());
        assertEquals("district", dataStore.getCityHashMap().get(id).getDistrict());
        assertEquals(10000, dataStore.getCityHashMap().get(id).getPopulation());

        dataStore.clear();
    }

    @Test
    void addLanguage()
    {
        ArrayList<Languages> languageList = new ArrayList<Languages>();

        String countryCode = "XYZ";
        String lang = "English";
        String lang2 = "French";

        Languages language = new Languages(countryCode, lang, true, 80.5);
        Languages language2 = new Languages(countryCode, lang2, false, 19.5);

        languageList.add(language);
        languageList.add(language2);

        dataStore.addToLanguages(languageList);

        for(String key : dataStore.getLanguageHashMap().keySet())
        {
            System.out.println("Country Code: " + key);
            for(int i = 0; i < dataStore.getLanguageHashMap().get(key).size(); i++)
            {
                System.out.println("Language: " + dataStore.getLanguageHashMap().get(key).get(i).getLanguage()
                        + ", " + dataStore.getLanguageHashMap().get(key).get(i).isOfficial()
                        + ", " + dataStore.getLanguageHashMap().get(key).get(i).getPercentage());
            }
        }
        assertEquals(countryCode, dataStore.getLanguageHashMap().get(countryCode).get(0).getCountryCode());
        assertEquals(lang, dataStore.getLanguageHashMap().get(countryCode).get(0).getLanguage());
        assertEquals(true, dataStore.getLanguageHashMap().get(countryCode).get(0).isOfficial());
        assertEquals(80.5, dataStore.getLanguageHashMap().get(countryCode).get(0).getPercentage());

        assertEquals(countryCode, dataStore.getLanguageHashMap().get(countryCode).get(1).getCountryCode());
        assertEquals(lang2, dataStore.getLanguageHashMap().get(countryCode).get(1).getLanguage());
        assertEquals(false, dataStore.getLanguageHashMap().get(countryCode).get(1).isOfficial());
        assertEquals(19.5, dataStore.getLanguageHashMap().get(countryCode).get(1).getPercentage());

        dataStore.clear();
    }
}
