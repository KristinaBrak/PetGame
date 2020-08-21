package com.pet.status;

public class StatusImp implements Status {

    private String name;
    private int maxValue;
    private int minValue;
    private int value;

    public StatusImp(String name, int maxValue, int minValue) {
        this.name = name;
        this.value = maxValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public void increase(int value) {
        this.value += value;
        if (this.value > maxValue) {
            this.value = maxValue;
        }
    }

    public void decrease(int value) {
        this.value -= value;
        if (this.value < minValue) {
            this.value = minValue;
        }
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

}