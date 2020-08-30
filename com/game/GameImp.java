package com.game;

import com.Player;
import com.TimeChecker;
import com.TimeCheckerImp;
import com.event.EventCreator;
import com.event.EventCreatorImp;
import com.pet.status.Status;
import com.server.Messenger;

public class GameImp implements Game {

    private EventCreator eventCreator;
    private TimeChecker timeChecker;
    private Messenger messenger;
    private Player player;

    public GameImp(Player player, Messenger messenger) {
        eventCreator = new EventCreatorImp(player.getPet());
        timeChecker = new TimeCheckerImp();
        this.messenger = messenger;
        this.player = player;
    }

    @Override
    public void exit() {
        System.exit(0); // TODO delete after testing
        // TODO Auto-generated method stub
    }

    @Override
    public void update() {

        if (messenger.hasMessage()) {
            String message = messenger.getMessage();
            System.out.println(message);
            if (message.equals("printStats")) {
                messenger.send(player.getPet().statusesToString());
            }
        }

        if (timeChecker.hasTimePassed()) {
            eventCreator.reduceStatus();
        }
    }

}