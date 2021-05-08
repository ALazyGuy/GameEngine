package com.ltp.engine.core;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Game - This class contains whole the game environment.
 *
 * @author Daniil Selin
 * @version 1.0.0 08 May 2021
 * @since 1.0.0
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Game {

    private static final Logger LOGGER = LogManager.getLogger(Game.class);

    /** running - true if game is running, false otherwise */
    @Getter
    private static boolean running;
    /** initialized - true if game data is initialized, false otherwise */
    @Getter
    private static boolean initialized;


    /** init - Initialize game data, initializing other game subsystems */
    public static void init(){
        if(initialized) return;

        initialized = true;
        LOGGER.info("Game initialized successfully");
    }

    /** start - Start the game. Method {@link Game#init()} must be called before */
    public static void start(){
        if(running || !initialized) return;

        running = true;

        LOGGER.info("Game started successfully");
    }

    /** terminate - Terminate the game, all game subsystems. Method {@link Game#start()} must be called before */
    public static void terminate(){
        if(!running) return;

        initialized = false;
        running = false;

        LOGGER.info("Game terminated successfully");
    }

}
