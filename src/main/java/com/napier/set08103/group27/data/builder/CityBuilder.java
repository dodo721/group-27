package com.napier.set08103.group27.data.builder;

import com.napier.set08103.group27.DatabaseManager;
import com.napier.set08103.group27.data.City;
import com.napier.set08103.group27.data.DataObject;
import com.napier.set08103.group27.data.District;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityBuilder extends DataObjectBuilder {
    public CityBuilder(DatabaseManager database) {
        super(database);
    }

    @Override
    public List<DataObject> build() throws SQLException {
        String query = "SELECT * FROM city";
        ResultSet rs = database.query(query);
        ArrayList<DataObject> cities = new ArrayList<DataObject>();
        while (rs.next()) {
            String name = rs.getString("Name");
            int id = rs.getInt("ID");
            int population = rs.getInt("Population");
            String parent = rs.getString("District");
            City city = new City(name, Integer.toString(id), population, parent);
            cities.add(city);
        }
        return cities;
    }
}
