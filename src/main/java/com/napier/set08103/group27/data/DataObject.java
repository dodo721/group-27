package com.napier.set08103.group27.data;

import java.util.List;

// All objects storing data about entities extend this class
public abstract class DataObject {

    protected String name;
    protected String id;
    protected int population;
    protected DataObject parent;
    protected List<DataObject> children;
    protected String parentName;

    public DataObject(String name, String id, int population, String parentName) {
        this.name = name;
        this.id = id;
        this.population = population;
        this.parentName = parentName;
    }

    // Used only for data building (see DataTreeBuilder)
    public void setParent (DataObject parent) {
        this.parent = parent;
    }

    // Pseudo-recursive method for searching the data tree for a name
    public DataObject findByName (String name) {
        for (DataObject obj : children) {
            DataObject res = obj.findByName(name);
            if (res != null) {
                return res;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    // Returns the parent name given if the parent is not already set,
    // otherwise returns the parent object name
    public String getParentName() {
        if (parent == null) {
            return parentName;
        } else {
            return parent.getName();
        }
    }

    public String getId() {
        return id;
    }

    public int getPopulation() {
        return population;
    }

    public DataObject getParent() {
        return parent;
    }

    public List<DataObject> getChildren() {
        return children;
    }
}
