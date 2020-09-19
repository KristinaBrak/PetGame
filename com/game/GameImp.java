package com.game;

import com.Player;
import com.PetOwner;
import com.TimeChecker;
import com.TimeCheckerImp;
import com.event.EventCreator;
import com.event.EventCreatorImp;
import com.persistance.Persistance;
import com.persistance.PersistanceImp;
import com.server.messenger.Messenger;

public class GameImp implements Game {

    private EventCreator eventCreator;
    private TimeChecker timeChecker;
    private Messenger messenger;
    private Player player;
    private Persistance persistance;

    public GameImp(Messenger messenger) {
        persistance = new PersistanceImp();
        this.player = new PetOwner("Susan");
        this.player.createPet("Liolekas");
        // this.player = (PetOwner) persistance.load();
        eventCreator = new EventCreatorImp(player.getPet());
        timeChecker = new TimeCheckerImp();
        this.messenger = messenger;
    }

    @Override
    public void close() {
        persistance.save(player);
        this.messenger = null;
        // System.exit(0);
    }

    @Override
    public void update() {
        if (messenger != null && messenger.hasMessage()) {
            String message = messenger.getMessage();
            System.out.println(message);
            if (message.equals("getStats")) {
                messenger.send(player.getPet().statusesToString());
                System.out.println(player.getPet().statusesToString());
            }
        }

        if (timeChecker.hasTimePassed()) {
            eventCreator.reduceStatus();
            System.out.println(player.getPet().statusesToString());
            messenger.send(player.getPet().statusesToString());
        }

    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

}