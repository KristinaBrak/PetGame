package com.pet.status;

public interface Status {

    void increase(int value);

    void decrease(int value);

    int getValue();

    String getName();

}