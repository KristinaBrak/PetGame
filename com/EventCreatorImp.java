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
        // TODO Auto-generated method stub

    }

    private Status getRandomStatus() {
        Random random = new Random();
        int index = random.nextInt(pet.getStatuses().size());
        ArrayList<Status> statusValues = new ArrayList<Status>(pet.getStatuses().values());
        return statusValues.get(index);
    }

}