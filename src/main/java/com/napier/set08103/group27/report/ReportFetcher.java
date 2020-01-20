package com.napier.set08103.group27.report;

public class ReportFetcher {

    private ReportGenerator generator;
    private Object databaseInstance; // TODO: replace with database class

    public ReportFetcher(ReportGenerator generator, Object databaseInstance) {
        this.generator = generator;
        this.databaseInstance = databaseInstance;
    }

    public String fetch () {
        // TODO: link generator to database and get values
        return null;
    }
}
