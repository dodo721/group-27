package com.napier.set08103.group27.report;

import com.napier.set08103.group27.data.RetrievePopulations;

public class ContinentPopulationReport implements ReportGenerator{

    String continent;
    RetrievePopulations retrievePopulations = new RetrievePopulations();

    public ContinentPopulationReport(String continent)
    {
        this.continent = continent;
    }

    @Override
    public String[] generate() {
        String[] report = new String[1];

        report[0] = "Continent Population Report for " + continent + ": " + retrievePopulations.getContinentPopulation(continent);

        return report;
    }
}
