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
}
