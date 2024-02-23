package kh.maryiaskachkova.junglesimulator.util;

import kh.maryiaskachkova.junglesimulator.entity.Lion;

public class EventSimulator {
    // lion sleep +9 energy;
    // lion run -8 energy;
    // lion jump - 4 energy;
    // lion swim -6 energy;
    // lion eat buffalo -8 energy; coeff * 4 health;
    // lion eat zebra -10 energy; coeff * 3 health;
    // lion eat boar - 2 energy; coeff * 2 health;
    // lion fight with a hyena  -25 health; - 10 energy;
    // lion fight with lioness  - 35 health; - 25 energy;
    // poacher attacked lion - 45 health;
    public void startSimulation(Lion lion) {
        while (checkStatus(lion)) {
            int actionChoice = (int) (Math.random() * 100);
            if (actionChoice >= 0 && actionChoice < 20) {
                animalSleep(lion);
            } else if (actionChoice >= 20 && actionChoice < 25) {
                animalRun(lion);
            } else if (actionChoice >= 25 && actionChoice < 35) {
                animalJump(lion);
            } else if (actionChoice >= 35 && actionChoice < 45) {
                animalSwim(lion);
            } else if (actionChoice >= 45 && actionChoice < 60) {
                animalEatBuffalo(lion);
            } else if (actionChoice >= 60 && actionChoice < 75) {
                animalEatZebra(lion);
            } else if (actionChoice >= 75 && actionChoice < 85) {
                animalEatBoar(lion);
            } else if (actionChoice >= 85 && actionChoice < 90) {
                animalFightHyena(lion);
            } else if (actionChoice >= 90 && actionChoice < 95) {
                animalFightLioness(lion);
            } else if (actionChoice >= 95 && actionChoice < 100) {
                animalAttackedPoacher(lion);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Lion died! The end!");
    }

    private void animalSleep(Lion lion) {
        int energy = lion.getEnergy();
        energy = energy + 9;
        validateEnergy(lion);
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Lion sleep! + 9 energy. Current energy: " + lion.getEnergy());
    }

    private void animalRun(Lion lion) {
        int energy = lion.getEnergy();
        energy = energy - 8;
        validateEnergy(lion);
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Lion run! - 8 energy. Current energy: " + lion.getEnergy());
    }

    private void animalJump(Lion lion) {
        int energy = lion.getEnergy();
        energy = energy - 4;
        validateEnergy(lion);
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Lion jump! - 4 energy. Current energy: " + lion.getEnergy());
    }

    private void animalSwim(Lion lion) {
        int energy = lion.getEnergy();
        energy = energy - 6;
       validateEnergy(lion);
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Lion swim! - 6 energy. Current energy: " + lion.getEnergy());
    }

    private void animalEatBuffalo(Lion lion) {
        int energy = lion.getEnergy();
        int health = lion.getHealth();
        energy = energy - 8;
        validateEnergy(lion);
        health = health + (int) lion.getEnergyBonus() * 4;
        validateHealth(lion);
        lion.setEnergy(energy);
        lion.setHealth(health);
        checkEnergy(lion);
        System.out.println("Lion eat buffalo! Current energy: " + lion.getEnergy() + " , current health: " + lion.getHealth());
    }

    private void animalEatZebra(Lion lion) {
        int energy = lion.getEnergy();
        int health = lion.getHealth();
        energy = energy - 10;
        validateEnergy(lion);
        health = health + (int) lion.getEnergyBonus() * 3;
       validateHealth(lion);
        lion.setEnergy(energy);
        lion.setHealth(health);
        checkEnergy(lion);
        System.out.println("Lion eat zebra! Current energy: " + lion.getEnergy() + " , carrent health: " + lion.getHealth());
    }

    private void animalEatBoar(Lion lion) {
        int energy = lion.getEnergy();
        int health = lion.getHealth();
        energy = energy - 2;
        validateEnergy(lion);
        health = health + (int) lion.getEnergyBonus() * 2;
        validateHealth(lion);
        lion.setEnergy(energy);
        lion.setHealth(health);
        checkEnergy(lion);
        System.out.println("Lion eat boar! Current energy: " + lion.getEnergy() + " , carrent health: " + lion.getHealth());
    }

    private void animalFightHyena(Lion lion) {
        int health = lion.getHealth();
        int energy = lion.getEnergy();
        health = health - 25;
        energy = energy - 10;
        validateHealth(lion);
        validateEnergy(lion);
        lion.setHealth(health);
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Lion has fight with a hyena! Current health: " + lion.getHealth() + " current energy: " + lion.getEnergy());
    }

    private void animalFightLioness(Lion lion) {
        int health = lion.getHealth();
        int energy = lion.getEnergy();
        health = health - 35;
        energy = energy - 25;
        validateHealth(lion);
        validateEnergy(lion);
        lion.setHealth(health);
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Lion has fight with lioness! Current health: " + lion.getHealth() + " , current energy: " + lion.getEnergy());
    }

    private void animalAttackedPoacher(Lion lion) {
        int health = lion.getHealth();
        health = health - 45;
        validateHealth(lion);
        lion.setHealth(health);
        checkEnergy(lion);
        System.out.println("Poacher attacked a lion! Current health: " + lion.getHealth());
    }

    private boolean checkStatus(Lion lion) {
        System.out.println("hp: " + lion.getHealth() + " energy: " + lion.getEnergy());
        if (lion.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private void checkEnergy(Lion lion) {
        if (lion.getEnergy() <= 0) {
            int health = lion.getHealth();
            health = health - 6;
            validateHealth(lion);
            lion.setHealth(health);
        }
    }

    private void validateEnergy(Lion lion) {
        int energy = 0;
        if (energy < 0) {
            energy = 0;
        }
    }

    private void validateHealth(Lion lion) {
        int health = 0;
        if (health > 100) {
            health = 100;
        }
    }
}



