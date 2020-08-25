package com.game;

import com.Player;
import com.TimeChecker;
import com.TimeCheckerImp;
import com.event.EventCreator;
import com.event.EventCreatorImp;

public class GameImp implements Game {
    private EventCreator eventCreator;

    private TimeChecker timeChecker;

    public GameImp(Player player) {
        eventCreator = new EventCreatorImp(player.getPet());
        timeChecker = new TimeCheckerImp();
    }

    @Override
    public void exit() {
        System.exit(0); // TODO delete after testing
        // TODO Auto-generated method stub

    }

    @Override
    public void update() {
        if (timeChecker.hasTimePassed()) {
            eventCreator.reduceStatus();
        }
    }

}