package com;

import com.food.Food;
import com.pet.*;

public class PetOwner implements Player {
    private String name;
    private Pet pet;

    public PetOwner(String name) {
        this.name = name;
    }

    public void createPet(String petName) {
        Pet pet = new Cat(petName);
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    public void pet(int loveLevel) {
        pet.changeMood(loveLevel);
    }

    public void feed(Food food) {
        pet.eat(food);
    }

    public void wash(int neatness) {
        pet.wash(neatness);
    }

    public void giveMedicine(int healingPower) {
        pet.heal(healingPower);
    }

    public void letSleep() {
        pet.sleep();
    }

    public String getName() {
        return name;
    }

}