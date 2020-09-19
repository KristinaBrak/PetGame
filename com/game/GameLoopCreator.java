package com.game;

import com.server.messenger.Messenger;

public class GameLoopCreator {
    public static GameLoop create(Messenger messenger) {
        Game game = new GameImp(messenger);
        GameLoop gameLoop = new GameLoopImp(game);
        return gameLoop;
    }

}
