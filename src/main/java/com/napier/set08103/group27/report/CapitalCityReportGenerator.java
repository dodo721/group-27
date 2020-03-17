package com.napier.set08103.group27.report;

import com.napier.set08103.group27.DataStore;
import com.napier.set08103.group27.data.City;
import com.napier.set08103.group27.data.Country;
import java.util.ArrayList;


public class CapitalCityReportGenerator implements ReportGenerator {

    private City city;
    private int id;
    public CapitalCityReportGenerator() {
    }

    @Override
    public String[] generate(){

        DataStore dataStore = DataStore.getInstance();
        ArrayList<Integer> capitalCityIDs = new ArrayList<>();
        for (Country country : dataStore.getCountriesHashMap().values()) {
            int capitalCityID = country.getCapital();
            if (capitalCityID != 0)
                capitalCityIDs.add(capitalCityID);
        }

        ArrayList<City> cities = new ArrayList<>();
        for (int capitalCityID : capitalCityIDs) {
            cities.add(dataStore.getCityHashMap().get(capitalCityID));
        }

        String[] report = new String[cities.size() + 1];

        report[0] = "Capital cities reports:";
        for (int i = 1; i < report.length; i ++) {
            report[i] = cities.get(i - 1).getName() + ", population " + cities.get(i - 1).getPopulation();
        }

        return report;
    }




}
