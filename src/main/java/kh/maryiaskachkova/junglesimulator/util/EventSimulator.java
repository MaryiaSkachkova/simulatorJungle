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
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 20) {
                sleepEvent(lion);
            } else if (eventNumber >= 20 && eventNumber < 25) {
                runEvent(lion);
            } else if (eventNumber >= 25 && eventNumber < 35) {
                jumpEvent(lion);
            } else if (eventNumber >= 35 && eventNumber < 45) {
                swimEvent(lion);
            } else if (eventNumber >= 45 && eventNumber < 60) {
                lionEatBuffalo(lion);
            } else if (eventNumber >= 60 && eventNumber < 75) {
                lionEatZebra(lion);
            } else if (eventNumber >= 75 && eventNumber < 85) {
                lionEatBoar(lion);
            } else if (eventNumber >= 85 && eventNumber < 90) {
                lionFightHyena(lion);
            } else if (eventNumber >= 90 && eventNumber < 95) {
                lionFightLioness(lion);
            } else if (eventNumber >= 95 && eventNumber < 100) {
                poacherAttacked(lion);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Lion died! The end!");
    }

    private void sleepEvent(Lion lion) {
        int energy = lion.getEnergy();
        energy = energy + 9;
        if (energy > 100) {
            energy = 100;
        }
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Lion sleep! + 9 energy. Current energy: " + lion.getEnergy());
    }
    private void runEvent(Lion lion) {
        int energy = lion.getEnergy();
        energy = energy - 8;
        if (energy < 0) {
            energy = 0;
        }
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Lion run! - 8 energy. Current energy: " + lion.getEnergy());
    }
    private void jumpEvent(Lion lion) {
        int energy = lion.getEnergy();
        energy = energy - 4;
        if (energy < 0) {
            energy = 0;
        }
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Lion jump! - 4 energy. Current energy: " + lion.getEnergy());
    }
    private void swimEvent(Lion lion) {
        int energy = lion.getEnergy();
        energy = energy - 6;
        if (energy < 0) {
            energy = 0;
        }
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Lion swim! - 6 energy. Current energy: " + lion.getEnergy());
    }
    private void lionEatBuffalo(Lion lion) {
        int energy = lion.getEnergy();
        int health = lion.getHealth();
        energy = energy - 8;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) lion.getFangsEnergyCoeff() * 4;
        if (health > 100) {
            health = 100;
        }
        lion.setEnergy(energy);
        lion.setHealth(health);
        checkEnergy(lion);
        System.out.println("Lion eat buffalo! Current energy: " + lion.getEnergy() + " , current health: " + lion.getHealth());
    }
    private void lionEatZebra(Lion lion) {
        int energy = lion.getEnergy();
        int health = lion.getHealth();
        energy = energy - 10;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) lion.getFangsEnergyCoeff() * 3;
        if (health > 100) {
            health = 100;
        }
        lion.setEnergy(energy);
        lion.setHealth(health);
        checkEnergy(lion);
        System.out.println("Lion eat zebra! Current energy: " + lion.getEnergy() + " , carrent health: " + lion.getHealth());
    }
    private void lionEatBoar(Lion lion) {
        int energy = lion.getEnergy();
        int health = lion.getHealth();
        energy = energy - 2;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) lion.getFangsEnergyCoeff() * 2;
        if (health > 100) {
            health = 100;
        }
        lion.setEnergy(energy);
        lion.setHealth(health);
        checkEnergy(lion);
        System.out.println("Lion eat boar! Current energy: " + lion.getEnergy() + " , carrent health: " + lion.getHealth());
    }
    private void lionFightHyena(Lion lion) {
        int health = lion.getHealth();
        int energy = lion.getEnergy();
        health = health - 25;
        energy = energy - 10;
        if (health < 0) {
            health = 0;
        }
        if (energy < 0) {
            energy = 0;
        }
        lion.setHealth(health);
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Lion has fight with a hyena! Current health: " + lion.getHealth() + " current energy: " + lion.getEnergy());
    }
    private void lionFightLioness(Lion lion) {
        int health = lion.getHealth();
        int energy = lion.getEnergy();
        health = health - 35;
        energy = energy - 25;
        if (health < 0) {
            health = 0;
        }
        if (energy < 0) {
            energy = 0;
        }
        lion.setHealth(health);
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Lion has fight with lioness! Current health: " + lion.getHealth() + " , current energy: " + lion.getEnergy());
    }
    private void poacherAttacked(Lion lion) {
        int health = lion.getHealth();
        health = health - 45;
        if (health < 0) {
            health = 0;
        }
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
            if (health < 0) {
                health = 0;
            }
            lion.setHealth(health);
        }
    }
}
