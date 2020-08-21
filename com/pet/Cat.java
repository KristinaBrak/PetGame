package com.pet;

import com.GameConfig;
import com.food.Food;

public class Cat implements Pet {
    private String name;
    private int age;
    private int health;
    private int energy;
    private int mood;
    private int higiene;
    private int sleep;
    private final int MAX_STATUS_VALUE = 100;

    private static int poopValue = GameConfig.POOP_VALUE;

    public Cat(String name) {
        this.name = name;
        age = 0;
        health = MAX_STATUS_VALUE;
        energy = MAX_STATUS_VALUE;
        mood = MAX_STATUS_VALUE;
        higiene = MAX_STATUS_VALUE;
        sleep = MAX_STATUS_VALUE;
    }
    public void eat(Food food) {
        energy += food.getEnergy();
        if(energy > MAX_STATUS_VALUE){
            energy = MAX_STATUS_VALUE;
        }
    }

    public void wash(int neatness) {
        higiene += neatness;
    }

    public void poop() {
        higiene -= poopValue;
    }

    public void sleep() {
        // TODO Auto-generated method stub
    }

    public void heal(int healingPower) {
        health += healingPower;
    }

    public void changeMood(int loveLevel) {
        mood += loveLevel;

    }

    public String getName() {
        return name;
    }


}