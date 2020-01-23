package com.napier.set08103.group27.data.builder;

import com.napier.set08103.group27.DatabaseManager;
import com.napier.set08103.group27.data.DataObject;
import com.napier.set08103.group27.data.DataStore;
import com.napier.set08103.group27.data.District;
import com.napier.set08103.group27.data.World;

import java.util.List;

// Class for creating the data tree from the objects built
public class DataTreeBuilder {

    // Method to create the DataObject tree stemming from the World object
    public void buildTree (DatabaseManager database) throws DataBuildException {
        DataStore store = DataStore.getInstance(); // Get world instance
        World world = store.getWorld();

        // Get the data builders for each DataObject type and build a list of objects for each one,
        // using the SQL database manager provided
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

        // Assign the parents and children to each object, creating the tree structure
        assignParents(cities, districts);
        assignParents(districts, countries);
        assignParents(countries, regions);
        assignParents(regions, continents);

        // Continents are the highest level object so assign parents to World
        for (DataObject object : continents) {
            object.setParent(world);
        }

    }

    // Assign the objects in the first list to parents in the second list
    private void assignParents (List<DataObject> children, List<DataObject> parents) throws DataBuildException {
        for (DataObject object : children) {
            // Attempt to find a parent for the object, if none is found throw an exception
            DataObject parent = findNameInList(parents, object.getParentName());
            if (parent == null) {
                throw new DataBuildException("Parent " + object.getParentName() + " was not found!");
            }
            // Set parent for object and push object to child list for parent
            object.setParent(parent);
            parent.getChildren().add(object);
        }
    }

    // Find an object with a name in a list
    private DataObject findNameInList (List<DataObject> objects, String name) {
        for (DataObject object : objects) {
            if (object.getName().equals(name)) {
                return object;
            }
        }
        return null;
    }

}