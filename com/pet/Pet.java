package com.pet;

import java.io.Serializable;
import java.util.Map;

import com.food.Food;
import com.pet.status.Status;
import com.pet.status.StatusName;

public interface Pet extends Serializable {

    void eat(Food food);

    void starve();

    void wash(int neatness);

    String getName();

    void poop();

    void sleep();

    void heal(int healingPower); // heal sickness

    void changeMood(int moodValue); // pet happiness

    Map<StatusName, Status> getStatuses();
}