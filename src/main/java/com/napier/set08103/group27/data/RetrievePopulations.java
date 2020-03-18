package com.napier.set08103.group27.data;

import com.napier.set08103.group27.DataStore;

public class RetrievePopulations {

    DataStore dataStore = DataStore.getInstance();

    //Method to add populations of all countries together to get world population
    public long getWorldPopulation()
    {
        long worldPopulation = 0;

        for(String key : dataStore.getCountriesHashMap().keySet())
        {
            worldPopulation += dataStore.getCountriesHashMap().get(key).getPopulation();
        }

        return worldPopulation;
    }

    //Method to add all country populations in a continent together to get continent population
    //Takes in a string which will be the continent
    public long getContinentPopulation(String continent)
    {
        long continentPopulation = 0;

        if(continent != null)
        {
            for(String key : dataStore.getCountriesHashMap().keySet())
            {
                if(continent.equals(dataStore.getCountriesHashMap().get(key).getContinent()))
                {
                    continentPopulation += dataStore.getCountriesHashMap().get(key).getPopulation();
                }
            }
        }

        return continentPopulation;
    }

    //Method to add all region populations in a region together to get region population
    //Takes in string which will be region name
    public long getRegionPopulation(String region)
    {
        long regionPopulation = 0;

        if(region != null)
        {
            for(String key : dataStore.getCountriesHashMap().keySet())
            {
                if(region.equals(dataStore.getCountriesHashMap().get(key).getRegion()))
                {
                    regionPopulation += dataStore.getCountriesHashMap().get(key).getPopulation();
                }
            }
        }


        return regionPopulation;
    }

    //Method to get population of country
    //Takes in country code
    public long getCountryPopulation(String country)
    {
        long countryPopulation = 0;

        if(country != null)
        {
            for(String key : dataStore.getCountriesHashMap().keySet())
            {
                if(country.equals(dataStore.getCountriesHashMap().get(key).getCode()))
                {
                    countryPopulation += dataStore.getCountriesHashMap().get(key).getPopulation();
                }
            }
        }

        return countryPopulation;
    }

    //Method to get population in a district
    //Takes in district name
    public long getDistrictPopulation(String district)
    {
        long districtPopulation = 0;

        if(district != null)
        {
            for(int key : dataStore.getCityHashMap().keySet())
            {
                if(district.equals(dataStore.getCityHashMap().get(key).getDistrict()))
                {
                    districtPopulation += dataStore.getCityHashMap().get(key).getPopulation();
                }
            }
        }


        return districtPopulation;
    }

    //Method to get population in a city
    //Takes in city name
    public long getCityPopulation(String city)
    {
        long cityPopulation = 0;

        if(city != null)
        {
            for(int key : dataStore.getCityHashMap().keySet())
            {
                if(city.equals(dataStore.getCityHashMap().get(key).getName()))
                {
                    cityPopulation += dataStore.getCityHashMap().get(key).getPopulation();
                }
            }
        }

        return cityPopulation;
    }
}
