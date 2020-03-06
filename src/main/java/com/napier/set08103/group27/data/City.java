package com.napier.set08103.group27.data;

public class City {

    private String name;
    private int id;
    private int population;
    private String countryCode;
    private String district;

    public City(String name, int id, int population, String countryCode, String district) {
        this.name = name;
        this.id = id;
        this.population = population;
        this.countryCode = countryCode;
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPopulation() {
        return population;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDistrict() {
        return district;
    }
}
