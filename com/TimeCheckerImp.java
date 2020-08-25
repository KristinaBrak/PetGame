package com;

import com.game.GameConfig;

public class TimeCheckerImp implements TimeChecker {

    private long lastUpdateTime;
    private long reductionTime;

    public TimeCheckerImp() {
        lastUpdateTime = System.currentTimeMillis();
        this.reductionTime = secondsToMillis(GameConfig.STATUS_REDUCTION_TIME_SECONDS);
    }

    @Override
    public boolean hasTimePassed() {
        long currentTime = System.currentTimeMillis();
        // System.out.println(currentTime - lastUpdateTime);
        if (currentTime - lastUpdateTime >= reductionTime) {
            lastUpdateTime = currentTime;
            return true;
        }
        return false;
    }

    private long secondsToMillis(long number) {
        return number * 1000;
    }
}