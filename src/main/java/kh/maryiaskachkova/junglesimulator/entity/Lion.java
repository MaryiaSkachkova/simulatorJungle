package kh.maryiaskachkova.junglesimulator.entity;

public class Lion {
    //100 hp
    //100 energy
    //fangsEnergyCoeff *2,5 extra energy from food
    private int health = 100;
    private int energy = 100;
    private final double fangsEnergyCoeff = 2.5;

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return this.health;
    }
    public void setEnergy(int energy) {
        this.energy = energy;
    }
    public int getEnergy() {
        return this.energy;
    }
    public double getFangsEnergyCoeff() {
        return this.fangsEnergyCoeff;
    }
}
