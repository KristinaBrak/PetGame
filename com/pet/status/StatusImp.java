package com.pet.status;

public class StatusImp implements Status {

    /**
     *
     */
    private static final long serialVersionUID = 72374855425588857L;
    private StatusName name;
    private int value;
    private int maxValue;
    private int minValue;

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

    @Override
    public void setName(StatusName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Value: %d, Max: %d, Min: %d", this.name.getStatusNameValue(), this.value,
                this.maxValue, this.minValue);

    }
}