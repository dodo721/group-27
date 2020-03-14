package com.napier.set08103.group27;

import com.napier.set08103.group27.data.City;
import com.napier.set08103.group27.data.Country;
import com.napier.set08103.group27.data.Languages;
import com.napier.set08103.group27.report.CitiesInRegionReportGenerator;
import com.napier.set08103.group27.report.CityReportGenerator;
import com.napier.set08103.group27.report.LanguagesOfWorldReport;
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
        db.connect("db:3306");

        //Reading data from SQL database - might be best to merge these into 1 method
        db.readCountries();
        db.readCities();
        db.readLanguages();

        /*
        for (Country country : dataStore.getCountriesHashMap().values()) {
            reports.add(new CitiesInRegionReportGenerator(country.getRegion()));
        }

        for (ReportGenerator report : reports) {
            String[] contents = report.generate();
            for (String line : contents) {
                System.out.println(line);
            }
        }
         */
        reports.add(new LanguagesOfWorldReport());

        for(ReportGenerator report : reports)
        {
            String[] contents = report.generate();
            for(String line : contents)
            {
                System.out.println(line);
            }
        }


        //Closing the connection to database
        db.disconnect();
    }
}
