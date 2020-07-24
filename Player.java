public class Player implements PetOwner {
    private String name;
    Pet pet;

    public Player(String name) {
        this.name = name;
    }

    public void createPet(String petName) {
        Pet pet = new Cat(petName);
        this.pet = pet;
    }

    public void pet(int loveLevel) {
        pet.changeMood(loveLevel);
    }

    public void feed(int energy) {
        pet.eat(energy);
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