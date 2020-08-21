package com.pet;

import com.food.Food;

public interface Pet {

    void eat(Food food);

    void starve();

    void wash(int neatness);

    void poop();

    void sleep();

    void heal(int healingPower); // heal sickness

    void changeMood(int moodValue); // pet happiness
}