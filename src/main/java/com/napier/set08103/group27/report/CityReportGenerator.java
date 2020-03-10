package com.napier.set08103.group27.report;

import com.napier.set08103.group27.DataStore;
import com.napier.set08103.group27.data.City;
import com.napier.set08103.group27.data.Country;

public class CityReportGenerator implements ReportGenerator {

    private City city;

    public CityReportGenerator (City city) {
        this.city = city;
    }

    @Override
    public String[] generate () {
        String[] report = new String[4];
        report[0] = "Report on city " + city.getName();
        DataStore dataStore = DataStore.getInstance();
        Country country = dataStore.getCountriesHashMap().get(city.getCountryCode());
        report[1] = "Country: " + country.getName() + " (" + city.getCountryCode() + ")";
        report[2] = "District: " + city.getDistrict();
        report[3] = "Population: " + city.getPopulation();
        return report;
    }

}