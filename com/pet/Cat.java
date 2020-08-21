package com.pet;

import com.GameConfig;
import com.food.Food;
import com.pet.status.*;

public class Cat implements Pet {
    private String name;
    private int age;
    private int health;
    // private int energy;
    private int mood;
    private int higiene;
    private int sleep;

    private Status energy;

    private final int MAX_STATUS_VALUE = 100;
    private final int MIN_STATUS_VALUE = 0;

    // private static long lastEatTime;

    private static int poopValue = GameConfig.POOP_VALUE;
    private static int starvationValue = GameConfig.STARVATION_VALUE;
    // private static long timeToStarve = GameConfig.TIME_TO_STARVE;

    public Cat(String name) {
        this.name = name;
        // age = MIN_STATUS_VALUE;
        // health = MAX_STATUS_VALUE;
        // energy = MAX_STATUS_VALUE;
        // mood = MAX_STATUS_VALUE;
        // higiene = MAX_STATUS_VALUE;
        // sleep = MAX_STATUS_VALUE;

        energy = new StatusImp("Energy", MAX_STATUS_VALUE, MIN_STATUS_VALUE);
        // setLastEatingTime();
    }

    public void eat(Food food) {
        energy.increase(food.getEnergyValue());
        // setLastEatingTime();
    }

    public void starve() {
        energy.decrease(starvationValue);
    }

    // private void setLastEatingTime() {
    // lastEatTime = System.currentTimeMillis();
    // }

    // public void starve() {
    // if (isStarvingTime()) {
    // energy -= starvationValue;
    // if (energy < MIN_STATUS_VALUE) {
    // energy = MIN_STATUS_VALUE;
    // }
    // }
    // assert energy > MIN_STATUS_VALUE : "Pet energy cannot be below min status
    // value";
    // System.out.println("Energy of pet: " + energy);
    // }

    // private boolean isStarvingTime() {
    // long time = System.currentTimeMillis() - lastEatTime;
    // if (time > timeToStarve) {
    // System.out.println("Is starving time: " + (double) time);
    // return true;
    // }
    // System.out.println("Not starving time: " + (double) time);
    // return false;
    // }

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