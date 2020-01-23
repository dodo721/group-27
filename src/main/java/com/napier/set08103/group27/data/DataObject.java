package com.napier.set08103.group27.data;

import java.util.List;

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

    public void setParent (DataObject parent) {
        this.parent = parent;
    }

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
