package com.maliha.main.model;

public class House {
    private String name;
    private int position;

    public House(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
