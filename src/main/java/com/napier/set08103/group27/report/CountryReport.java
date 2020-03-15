package com.napier.set08103.group27.report;

import com.napier.set08103.group27.DataStore;
import com.napier.set08103.group27.data.Country;

import java.util.ArrayList;
import java.util.HashMap;

public class CountryReport implements ReportGenerator {

    private Country country;

    public CountryReport (Country country) {
        this.country = country;
    }

    @Override
    public String[] generate () {

        String[] report = new String[6];

        report[0] = "Report on country: " + country.getCode();
        report[1] = "Country name: " + country.getName();
        report[2] = "Continent: " + country.getContinent();
        report[3] = "Region: " + country.getRegion();
        report[4] = "Population: " + country.getPopulation();
        report[5] = "Capital: " + country.getCapital();

        return report;

    }
}
