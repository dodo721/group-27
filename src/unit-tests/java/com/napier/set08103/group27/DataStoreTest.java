package com.napier.set08103.group27;

import com.napier.set08103.group27.data.City;
import com.napier.set08103.group27.data.Country;
import com.napier.set08103.group27.data.Languages;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DataStoreTest {
    static DataStore dataStore;

    @BeforeAll
    static void init()
    {
        dataStore = DataStore.getInstance();
    }

    @Test
    void printCountriesWhenInputNull()
    {
        dataStore.addToCountry(null);
        for(String key : dataStore.getCountriesHashMap().keySet())
        {
            System.out.println("Country: " + key);
        }
    }

    @Test
    void printCityWhenInputNull()
    {
        dataStore.addToCity(null);
        for(int key : dataStore.getCityHashMap().keySet())
        {
            System.out.println("City: " + key);
        }
    }

    @Test
    void printLanguageWhenInputNull()
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
    void printCountries()
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
            System.out.println("Country: " + dataStore.getCountriesHashMap().get(key).getCode() + ", " + dataStore.getCountriesHashMap().get(key).getName());
        }
    }

    @Test
    void printCities()
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
            System.out.println("City: " + dataStore.getCityHashMap().get(key).getId() + ", " + dataStore.getCityHashMap().get(key).getName());
        }
    }

    @Test
    void printLanguage()
    {
        ArrayList<Languages> languageList = new ArrayList<Languages>();

        String countryCode = "XYZ";
        String lang = "English";
        String lang2 = "French";
        boolean isOfficial = true;
        double percentage = 80.5;

        Languages language = new Languages(countryCode, lang, isOfficial, percentage);
        Languages language2 = new Languages(countryCode, lang2, isOfficial, percentage);

        languageList.add(language);
        languageList.add(language2);

        dataStore.addToLanguages(languageList);

        for(String key : dataStore.getLanguageHashMap().keySet())
        {
            System.out.println("Country Code: " + key);
            for(int i = 0; i < dataStore.getLanguageHashMap().get(key).size(); i++)
            {
                System.out.println("Language: " + dataStore.getLanguageHashMap().get(key).get(i).getLanguage());
            }
        }
    }
}
