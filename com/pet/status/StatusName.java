package com.pet.status;

public enum StatusName {
    ENERGY("Energy"), SLEEP("Sleep"), HEALTH("Health"), MOOD("Mood");

    String name;

    StatusName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

}