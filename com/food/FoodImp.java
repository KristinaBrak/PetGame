package com.food;

public class FoodImp implements Food {

    private String title;
    private int energyValue;

    public FoodImp(String title, int energyValue) {
        this.title = title;
        this.energyValue = energyValue;
    }

    public int getEnergyValue() {
        return energyValue;
    }

    public String getTitle() {
        return title;
    }

}