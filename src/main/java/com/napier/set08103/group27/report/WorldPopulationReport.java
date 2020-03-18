package com.napier.set08103.group27.report;

import com.napier.set08103.group27.DataStore;
import com.napier.set08103.group27.data.RetrievePopulations;

public class WorldPopulationReport implements ReportGenerator{

    RetrievePopulations retrievePopulations = new RetrievePopulations();

    public WorldPopulationReport(){}

    @Override
    public String[] generate()
    {
        String[] report = new String[1];

        report[0] = "World Population: " + retrievePopulations.getWorldPopulation();

        return report;
    }
}
