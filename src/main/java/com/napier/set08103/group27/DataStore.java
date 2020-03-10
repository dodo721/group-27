package com.napier.set08103.group27;

import com.napier.set08103.group27.data.City;
import com.napier.set08103.group27.data.Country;
import com.napier.set08103.group27.data.Languages;

import java.util.ArrayList;
import java.util.HashMap;

class DataStore {
    private static DataStore instance;

    private HashMap<Integer, City> cityHashMap = new HashMap<Integer, City>(); //Int key will be the city ID
    private HashMap<String, Country> countryHashMap = new HashMap<String, Country>(); //Key will be country code
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
        countryHashMap.put(country.getCode() ,country);
    }

    public void addToCity(City city)
    {
        cityHashMap.put(city.getId(), city);
    }

    public void addToLanguages(ArrayList<Languages> languagesList)
    {
        //Making list for each key in hashmap so that all keys don't use same list of languages
        String countryCode = languagesList.get(0).getCountryCode();
        if (languageHashMap.keySet().contains(countryCode)) {
            ArrayList list = new ArrayList(languagesList);
            languageHashMap.put(countryCode, list);
        } else {
            languageHashMap.get(countryCode).addAll(languagesList);
        }
    }

    public HashMap<String, Country> getCountriesHashMap()
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
