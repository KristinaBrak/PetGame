package com;

import java.util.ArrayList;
import java.util.Random;

import com.pet.Pet;
import com.pet.status.Status;

public class EventCreatorImp implements EventCreator {

    private Pet pet;

    public EventCreatorImp(Pet pet) {
        this.pet = pet;
    }

    @Override
    public void reduceStatus() {
        Status reducedStatus = getRandomStatus();
        reducedStatus.decrease(getRandomValue());
    }

    private Status getRandomStatus() {
        Random random = new Random();
        int index = random.nextInt(pet.getStatuses().size());
        ArrayList<Status> statusValues = new ArrayList<Status>(pet.getStatuses().values());
        return statusValues.get(index);
    }

    private int getRandomValue() {
        Random random = new Random();
        int number = random.nextInt(GameConfig.MAX_DECREASE_STATUS_VALUE);
        return number;
    }

}