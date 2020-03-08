package com.napier.set08103.group27;

import com.napier.set08103.group27.data.City;
import com.napier.set08103.group27.data.Country;
import com.napier.set08103.group27.data.Languages;

import java.util.ArrayList;
import java.util.HashMap;

class DataStore {
    private static DataStore instance;

    private HashMap<Integer, City> cityHashMap = new HashMap<Integer, City>(); //Int key will be the city ID
    private HashMap<Integer, Country> countryHashMap = new HashMap<Integer, Country>(); //Int key will be the capital city
    private HashMap<String, ArrayList<Languages>> languageHashMap = new HashMap<String, ArrayList<Languages>>();
    //key for languages will have country code as key and will have a list of language objects

    private DataStore(){}

    public static DataStore getInstance()
    {
        if(instance == null)
        {
            instance = new DataStore();
        }
        return instance;
    }

    public void addToCountry(Country country)
    {
        countryHashMap.put(country.getCapital() ,country);
    }

    public void addToCity(City city)
    {
        cityHashMap.put(city.getId(), city);
    }

    public void addToLanguages(ArrayList<Languages> languagesList)
    {
        languageHashMap.put(languagesList.get(0).getCountryCode(), languagesList);
        System.out.println("Added to hashmap");
        for(int i = 0; i < languagesList.size(); i++)
        {
            System.out.println("Lang: " + languagesList.get(i).getLanguage() + " To: " + languagesList.get(i).getCountryCode());
        }
    }

    public HashMap<Integer, Country> getCountriesHashMap()
    {
        return countryHashMap;
    }

    public HashMap<Integer, City> getCityHashMap()
    {
        return cityHashMap;
    }

    public HashMap<String, ArrayList<Languages>> getLanguageHashMap()
    {
        return languageHashMap;
    }
}
