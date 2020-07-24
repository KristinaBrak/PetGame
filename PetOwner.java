public interface PetOwner {
    void createPet(String petName);

    void pet(int loveLevel);

    void feed(int energy);

    void wash(int neatness);

    void giveMedicine(int healingPower);

    void letSleep();

    String getName();
}