package com.pet.status;

public class StatusImp implements Status {

    private int maxValue;
    private int minValue;
    private int value;
    private StatusName name;

    public StatusImp(StatusName name, int maxValue, int minValue) {
        this.name = name;
        this.value = maxValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    @Override
    public void increase(int value) {
        this.value += value;
        if (this.value > maxValue) {
            this.value = maxValue;
        }
    }

    @Override
    public void decrease(int value) {
        this.value -= value;
        if (this.value < minValue) {
            this.value = minValue;
        }
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public StatusName getName() {
        return this.name;
    }

}