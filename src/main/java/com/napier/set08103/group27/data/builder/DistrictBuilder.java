package com.napier.set08103.group27.data.builder;

import com.napier.set08103.group27.DatabaseManager;
import com.napier.set08103.group27.data.District;
import com.napier.set08103.group27.data.DataObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DistrictBuilder extends DataObjectBuilder {
    public DistrictBuilder(DatabaseManager database) {
        super(database);
    }

    @Override
    public List<DataObject> build() throws SQLException {
        String query = "SELECT DISTINCT District FROM city;";
        ResultSet rs = database.query(query);
        ArrayList<DataObject> districts = new ArrayList<DataObject>();
        ArrayList<String> districtNames = new ArrayList<String>();
        while (rs.next()) {
            String name = rs.getString("District");
            districtNames.add(name);
        }
        for (String districtName : districtNames) {
            String query2 = "SELECT District, CountryCode, SUM(Population) as TotalPop FROM city WHERE District='" + districtName + "' GROUP BY District, CountryCode;";
            ResultSet drs = database.query(query2);
            drs.absolute(1);
            int population = drs.getInt("TotalPop");
            String countryCode = drs.getString("CountryCode");
            String query3 = "SELECT Name FROM country WHERE Code='" + countryCode + "';";
            ResultSet crs = database.query(query3);
            crs.absolute(1);
            String parent = crs.getString("Name");
            District district = new District(districtName, districtName, population, parent);
            districts.add(district);
        }
        return districts;
    }
}