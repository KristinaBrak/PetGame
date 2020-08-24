package com;

public interface GameConfig {
    int MAX_STATUS_VALUE = 100;
    int MIN_STATUS_VALUE = 0;
    int MAX_DECREASE_STATUS_VALUE = 30;
    int POOP_VALUE = 10;
    int STARVATION_VALUE = 15;
    long TIME_TO_STARVE = (long) (1000 * 3); // after 3 s // (60000 * 0.5); //after 0.5min
}