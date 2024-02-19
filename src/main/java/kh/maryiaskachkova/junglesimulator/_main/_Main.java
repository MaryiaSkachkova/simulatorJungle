package kh.maryiaskachkova.junglesimulator._main;

import kh.maryiaskachkova.junglesimulator.entiity.Lion;
import kh.maryiaskachkova.junglesimulator.util.EventSimulator;

public class _Main {
    public static void main(String[] args) {
        Lion lion = new Lion();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.startSimulation(lion);
    }
}
