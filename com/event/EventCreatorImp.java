package com.event;

import java.util.ArrayList;
import java.util.Random;

import com.game.GameConfig;
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
        printStatuses(); // TODO delete after testing
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

    private void printStatuses() {
        var values = pet.getStatuses().values();
        for (Status value : values) {
            System.out.println(value.getName() + " " + value.getValue());
        }
    }

}