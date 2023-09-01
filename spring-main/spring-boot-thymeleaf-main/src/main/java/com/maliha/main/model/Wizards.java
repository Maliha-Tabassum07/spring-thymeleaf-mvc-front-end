package com.maliha.main.model;

public class Wizards {

    private Integer id;
    private String name;
    private String house;

    public Wizards() {
    }

    public Wizards(Integer id, String name, String house) {
        this.id = id;
        this.name = name;
        this.house = house;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouse() {
        return house;
    }


    public void setHouse(String house) {
        this.house = house;
    }
}
