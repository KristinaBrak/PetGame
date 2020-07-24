public class Cat implements Pet {
    private String name;
    private int age;
    private int health;
    private int hunger;
    private int mood;
    private int higiene;
    private int sleep;

    private static int poopValue = GameConfig.POOP_VALUE;

    public Cat(String name) {
        this.name = name;
        age = 0;
        health = 100;
        hunger = 0;
        mood = 100;
        higiene = 100;
        sleep = 100;
    }

    public void eat(int energy) {
        hunger += energy;
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