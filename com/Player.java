package com;

import com.food.Food;
import com.pet.Pet;

public interface Player {
    void createPet(String petName);

    Pet getPet();

    void pet(int loveLevel);

    void feed(Food food);

    void wash(int neatness);

    void giveMedicine(int healingPower);

    void letSleep();

    String getName();
}