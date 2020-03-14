package com.napier.set08103.group27.report;

import com.napier.set08103.group27.DataStore;
import com.napier.set08103.group27.data.City;
import com.napier.set08103.group27.data.Country;
import java.util.ArrayList;


public class CapitalCityReportGenerator implements ReportGenerator {

    private City city;
    private int id;
    public CapitalCityReportGenerator(int id) {
        this.id = id;
    }

    @Override
    public String[] generate(){

        DataStore dataStore = DataStore.getInstance();
        ArrayList<Integer> countries = new ArrayList<>();
        for (Country country : dataStore.getCountriesHashMap().values()) {
                countries.add(country.getCapital());
        }

        ArrayList<City> cities = new ArrayList<>();
        for(City city : dataStore.getCityHashMap().values()) {
            if (countries.contains(city.getId())) {
                cities.add(city);
            }
        }

        String[] report = new String[cities.size() - 1];

        for (int i = 1; i < report.length; i ++) {
            report[i] = cities.get(i - 1).getName() + ", population " + cities.get(i - 1).getPopulation();
        }

        return report;
    }




}
