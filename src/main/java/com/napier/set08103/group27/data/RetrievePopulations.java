package com.napier.set08103.group27.data;

import com.napier.set08103.group27.DataStore;

public class RetrievePopulations {

    DataStore dataStore = DataStore.getInstance();

    public long getWorldPopulation()
    {
        long worldPopulation = 0;

        for(String key : dataStore.getCountriesHashMap().keySet())
        {
            worldPopulation += dataStore.getCountriesHashMap().get(key).getPopulation();
        }

        return worldPopulation;
    }

    public long getContinentPopulation(String continent)
    {
        long continentPopulation = 0;

        for(String key : dataStore.getCountriesHashMap().keySet())
        {
            if(continent.equals(dataStore.getCountriesHashMap().get(key).getContinent()))
            {
                continentPopulation += dataStore.getCountriesHashMap().get(key).getPopulation();
            }
        }

        return continentPopulation;
    }

    public long getRegionPopulation(String region)
    {
        long regionPopulation = 0;

        for(String key : dataStore.getCountriesHashMap().keySet())
        {
            if(region.equals(dataStore.getCountriesHashMap().get(key).getRegion()))
            {
                regionPopulation += dataStore.getCountriesHashMap().get(key).getPopulation();
            }
        }

        return regionPopulation;
    }

    public long getCountryPopulation(String country)
    {
        long countryPopulation = 0;

        for(String key : dataStore.getCountriesHashMap().keySet())
        {
            if(country.equals(dataStore.getCountriesHashMap().get(key).getCode()))
            {
                countryPopulation += dataStore.getCountriesHashMap().get(key).getPopulation();
            }
        }

        return countryPopulation;
    }

    public long getDistrictPopulation(String district)
    {
        long districtPopulation = 0;

        for(int key : dataStore.getCityHashMap().keySet())
        {
            if(district.equals(dataStore.getCityHashMap().get(key).getDistrict()))
            {
                districtPopulation += dataStore.getCityHashMap().get(key).getPopulation();
            }
        }

        return districtPopulation;
    }

    public long getCityPopulation(String city)
    {
        long cityPopulation = 0;

        for(int key : dataStore.getCityHashMap().keySet())
        {
            if(city.equals(dataStore.getCityHashMap().get(key).getName()))
            {
                cityPopulation += dataStore.getCityHashMap().get(key).getPopulation();
            }
        }

        return cityPopulation;
    }
}
