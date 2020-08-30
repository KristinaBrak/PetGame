package com;

import java.io.Serializable;

import com.food.Food;
import com.pet.Pet;

public interface Player extends Serializable {
    void createPet(String petName);

    Pet getPet();

    void pet(int loveLevel);

    void feed(Food food);

    void wash(int neatness);

    void giveMedicine(int healingPower);

    void letSleep();

    String getName();
}