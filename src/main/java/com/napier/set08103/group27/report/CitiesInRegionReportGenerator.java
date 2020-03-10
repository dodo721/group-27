package com.napier.set08103.group27.report;

import com.napier.set08103.group27.DataStore;
import com.napier.set08103.group27.data.City;
import com.napier.set08103.group27.data.Country;

import java.util.ArrayList;
import java.util.Comparator;

public class CitiesInRegionReportGenerator implements ReportGenerator {

    public static Comparator<City> cityPopulationDescending = new Comparator<>() {
        public int compare(City c1, City c2) {
            return c1.getPopulation() - c2.getPopulation();
        }
    };

    String region;

    public CitiesInRegionReportGenerator (String region) {
        this.region = region;
    }

    @Override
    public String[] generate () {
        DataStore dataStore = DataStore.getInstance();
        ArrayList<String> countries = new ArrayList<>();
        for (Country country : dataStore.getCountriesHashMap().values()) {
            if (country.getRegion().equals(region)) {
                countries.add(country.getCode());
            }
        }
        ArrayList<City> cities = new ArrayList<>();
        for (City city : dataStore.getCityHashMap().values()) {
            if (countries.contains(city.getCountryCode())) {
                cities.add(city);
            }
        }
        cities.sort(cityPopulationDescending);
        String[] report = new String[cities.size() + 1];
        report[0] = "Report on region " + region;
        for (int i = 1; i < report.length; i ++) {
            report[i] = cities.get(i - 1).getName() + ", population " + cities.get(i - 1).getPopulation();
        }
        return report;
    }

}
