package kh.maryiaskachkova.junglesimulator.util;

import kh.maryiaskachkova.junglesimulator.entiity.Lion;

public class EventProducer {
    // lion sleep +9 energy;
    // lion run -8 energy;
    // lion eat buffalo -8 energy; coeff * 3 health;
    // lion eat zebra -10 energy; coeff * 4 health;
    // lion fight with a hyena  -25 health; - 10 energy;
    // lion fight with lioness - 30 health; - 25energy;
    // lion swim -10 energy;
    // lion eat boar - 2 energy; coeff * 2 health;
    // poacher attacked lion - 45 health;
    // if energy = 0 minus 10 health;
public void activateEvent(){

}

private void sleepEvent(Lion lion){
    int energy = lion.getEnergy();
    energy = energy + 9;
    if (energy > 100){
        energy = 100;
    }
    lion.setEnergy(energy);
    System.out.println("Lion sleep! + 9 energy. Current energy: " + lion.getEnergy());
}
private void run(Lion lion){
    int energy = lion.getEnergy();
    energy = energy - 8;
    if (energy < 0){
        energy = 0;
    }
    lion.setEnergy(energy);
    System.out.println("Lion run! - 8 energy. Current energy: " + lion.getEnergy());
}
private void lionEat(Lion lion){
    int energy = lion.getEnergy();
    int health = lion.getHealth();
    energy = energy - 8;
    if (energy < 0){
        energy = 0;
    }
    health = health + (int) lion.getFangsEnergyCoeff(3);
    if (health > 100){
        health = 100;
    }
    lion.setEnergy(energy);
    lion.setHealth(health);
}

}
