package com.pet;

import java.util.HashMap;
import java.util.Map;

import com.game.GameConfig;
import com.food.Food;
import com.pet.status.*;

public class PetImp implements Pet {
    /**
     *
     */
    private static final long serialVersionUID = -5763579274780121841L;
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
    }

    @Override
    public void eat(Food food) {
        statuses.get(StatusName.ENERGY).increase(food.getEnergyValue());
    }

    @Override
    public void starve() {
        statuses.get(StatusName.ENERGY).decrease(starvationValue);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void wash(int neatness) {
        statuses.get(StatusName.HEALTH).increase(neatness);
    }

    @Override
    public void poop() {
        statuses.get(StatusName.HEALTH).decrease(GameConfig.POOP_VALUE);
    }

    @Override
    public void sleep() {
        // TODO Auto-generated method stub

    }

    @Override
    public void heal(int healingPower) {
        statuses.get(StatusName.HEALTH).increase(healingPower);

    }

    @Override
    public void changeMood(int moodValue) {
        // TODO Auto-generated method stub

    }

    @Override
    public Map<StatusName, Status> getStatuses() {
        return this.statuses;
    }

    @Override
    public String statusesToString() {
        var values = statuses.values();
        String text = "";
        for (Status value : values) {
            text += (value.getName() + " " + value.getValue() + "\t");
        }
        return text;
    }

}