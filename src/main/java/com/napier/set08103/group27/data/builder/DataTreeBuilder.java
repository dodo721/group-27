package com.napier.set08103.group27.data.builder;

import com.napier.set08103.group27.DatabaseManager;
import com.napier.set08103.group27.data.DataObject;
import com.napier.set08103.group27.data.DataStore;
import com.napier.set08103.group27.data.District;
import com.napier.set08103.group27.data.World;

import java.util.List;

public class DataTreeBuilder {

    public void buildTree (DatabaseManager database) throws DataBuildException {
        DataStore store = DataStore.getInstance();
        World world = store.getWorld();

        CityBuilder cityBuilder = new CityBuilder(database);
        List<DataObject> cities = cityBuilder.build();
        DistrictBuilder districtBuilder = new DistrictBuilder(database);
        List<DataObject> districts = districtBuilder.build();
        CountryBuilder countryBuilder = new CountryBuilder(database);
        List<DataObject> countries = countryBuilder.build();
        RegionBuilder regionBuilder = new RegionBuilder(database);
        List<DataObject> regions = regionBuilder.build();
        ContinentBuilder continentBuilder = new ContinentBuilder(database);
        List<DataObject> continents = continentBuilder.build();

        assignParents(cities, districts);
        assignParents(districts, countries);
        assignParents(countries, regions);
        assignParents(regions, continents);

        for (DataObject object : continents) {
            object.setParent(world);
        }

    }

    private void assignParents (List<DataObject> children, List<DataObject> parents) throws DataBuildException {
        for (DataObject object : children) {
            DataObject parent = findNameInList(parents, object.getParentName());
            if (parent == null) {
                throw new DataBuildException("Parent " + object.getParentName() + " was not found!");
            }
            object.setParent(parent);
            parent.getChildren().add(object);
        }
    }

    private DataObject findNameInList (List<DataObject> objects, String name) {
        for (DataObject object : objects) {
            if (object.getName().equals(name)) {
                return object;
            }
        }
        return null;
    }

}