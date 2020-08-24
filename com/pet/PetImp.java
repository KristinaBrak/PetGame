package com.pet;

import java.util.HashMap;
import java.util.Map;

import com.GameConfig;
import com.food.Food;
import com.pet.status.*;

public class PetImp implements Pet {
    private String name;
    private int age;
    // private int health;
    // private int energy;
    // private int mood;
    // private int higiene;
    // private int sleep;

    private Map<StatusName, Status> statuses;

    // private static long lastEatTime;

    private static int starvationValue = GameConfig.STARVATION_VALUE;
    // private static long timeToStarve = GameConfig.TIME_TO_STARVE;

    public PetImp(String name) {
        this.name = name;
        age = 0; // not a status
        // health = MAX_STATUS_VALUE;
        // energy = MAX_STATUS_VALUE;
        // mood = MAX_STATUS_VALUE;
        // higiene = MAX_STATUS_VALUE;
        // sleep = MAX_STATUS_VALUE;

        this.statuses = new HashMap<StatusName, Status>();

        this.statuses.put(StatusName.ENERGY,
                new StatusImp(StatusName.ENERGY, GameConfig.MAX_STATUS_VALUE, GameConfig.MIN_STATUS_VALUE));
        this.statuses.put(StatusName.SLEEP,
                new StatusImp(StatusName.SLEEP, GameConfig.MAX_STATUS_VALUE, GameConfig.MIN_STATUS_VALUE));
        this.statuses.put(StatusName.MOOD,
                new StatusImp(StatusName.MOOD, GameConfig.MAX_STATUS_VALUE, GameConfig.MIN_STATUS_VALUE));
        this.statuses.put(StatusName.HEALTH,
                new StatusImp(StatusName.HEALTH, GameConfig.MAX_STATUS_VALUE, GameConfig.MIN_STATUS_VALUE));

        // setLastEatingTime();
    }

    @Override
    public void eat(Food food) {
        statuses.get(StatusName.ENERGY).increase(food.getEnergyValue());
        // setLastEatingTime();
    }

    @Override
    public void starve() {
        statuses.get(StatusName.ENERGY).decrease(starvationValue);
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

    public String getName() {
        return name;
    }

    @Override
    public void wash(int neatness) {
        // TODO Auto-generated method stub

    }

    @Override
    public void poop() {
        // TODO Auto-generated method stub

    }

    @Override
    public void sleep() {
        // TODO Auto-generated method stub

    }

    @Override
    public void heal(int healingPower) {
        // TODO Auto-generated method stub

    }

    @Override
    public void changeMood(int moodValue) {
        // TODO Auto-generated method stub

    }

    @Override
    public Map<StatusName, Status> getStatuses() {
        return this.statuses;
    }

}