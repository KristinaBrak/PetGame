package com.food;

public class FoodImp implements Food {

    private String title;
    private int energy;

    public FoodImp(String title, int energy) {
        this.title = title;
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public String getTitle() {
        return title;
    }

}