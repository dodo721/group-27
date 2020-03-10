package com.napier.set08103.group27;

import com.napier.set08103.group27.data.City;
import com.napier.set08103.group27.data.Country;
import com.napier.set08103.group27.report.CitiesInRegionReportGenerator;
import com.napier.set08103.group27.report.CityReportGenerator;
import com.napier.set08103.group27.report.ReportGenerator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    private static DataStore dataStore = DataStore.getInstance();
    private static ArrayList<ReportGenerator> reports = new ArrayList<ReportGenerator>();

    public static void main (String[] args) {

        DatabaseManager db = new DatabaseManager();

        //Connecting to the database
        db.connect();

        //Reading data from SQL database - might be best to merge these into 1 method
        db.readCountries();
        db.readCities();
        db.readLanguages();

        //testing all languages for country code "ZAF" are correct
        /*for(int i = 0; i < dataStore.getLanguageHashMap().get("ZAF").size(); i++)
        {
            System.out.println("ZAF: " + dataStore.getLanguageHashMap().get("ZAF").get(i).getLanguage());
        }*/

        for (Country country : dataStore.getCountriesHashMap().values()) {
            reports.add(new CitiesInRegionReportGenerator(country.getRegion()));
        }

        for (ReportGenerator report : reports) {
            String[] contents = report.generate();
            for (String line : contents) {
                System.out.println(line);
            }
        }

        //Need to test if the get methods from the DataStore singleton work and output correct data

        //Closing the connection to database
        db.disconnect();
    }
}
