package com;

public class Status {

    private int maxValue;
    private int minValue;
    private int value;

    public Status(int initialValue, int maxValue, int minValue) {
        value = initialValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public void increase(int value) {
        this.value += value;
        if (this.value > maxValue) {
            this.value = maxValue;
        }
        assert this.value < maxValue : "Pet energy cannot be above max status value";
        System.out.println("Energy of pet: " + this.value);
    }

    public void decrease(int value) {
        this.value -= value;
        if (this.value < minValue) {
            this.value = minValue;
        }
        assert this.value > minValue : "Pet energy cannot be above max status value";
        System.out.println("Energy of pet: " + this.value);
    }

    public int getValue() {
        return value;
    }

}