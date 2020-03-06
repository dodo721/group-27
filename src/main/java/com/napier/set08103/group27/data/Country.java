package com.napier.set08103.group27.data;

public class Country {

    private String name;
    private String code;
    private String continent;
    private String region;
    private double surfaceArea;
    private String indepYear;
    private int population;
    private double lifeExpectancy;
    private double GNP;
    private double GNPOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private int capital;
    private String code2;

    public Country(String name, String code, String continent, String region, double surfaceArea, String indepYear, int population, double lifeExpectancy, double GNP, double GNPOld, String localName, String governmentForm, String headOfState, int capital, String code2) {
        this.name = name;
        this.code = code;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.GNP = GNP;
        this.GNPOld = GNPOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.capital = capital;
        this.code2 = code2;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public String getIndepYear() {
        return indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public double getGNP() {
        return GNP;
    }

    public double getGNPOld() {
        return GNPOld;
    }

    public String getLocalName() {
        return localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public int getCapital() {
        return capital;
    }

    public String getCode2() {
        return code2;
    }
}
