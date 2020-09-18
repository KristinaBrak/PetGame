package com.game;

import com.Player;

public interface Game {

    void close();

    void update();

    Player getPlayer();
}