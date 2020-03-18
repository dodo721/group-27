package com.napier.set08103.group27;

import com.napier.set08103.group27.report.ContinentPopulationReport;
import com.napier.set08103.group27.report.LanguagesOfWorldReport;
import com.napier.set08103.group27.report.ReportGenerator;
import com.napier.set08103.group27.report.WorldPopulationReport;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static DataStore dataStore = DataStore.getInstance();
    private static ArrayList<ReportGenerator> reports = new ArrayList<ReportGenerator>();

    public static void main (String[] args) {

        DatabaseManager db = new DatabaseManager();

        //Connecting to the database
        if(args.length < 1)
        {
            db.connect("localhost:33060");
        }
        else
        {
            db.connect(args[0]);
        }


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

        //Adding report containing number of speakers of a language in the world
        reports.add(new LanguagesOfWorldReport());

        //Report to show world population
        reports.add(new WorldPopulationReport());

        //Adding reports to get population for continents
        reports.add(new ContinentPopulationReport("Europe"));
        reports.add(new ContinentPopulationReport("Asia"));
        reports.add(new ContinentPopulationReport("North America"));
        reports.add(new ContinentPopulationReport("Africa"));
        reports.add(new ContinentPopulationReport("South America"));
        reports.add(new ContinentPopulationReport("Oceania"));
        reports.add(new ContinentPopulationReport("Antarctica"));

        //printing reports
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
