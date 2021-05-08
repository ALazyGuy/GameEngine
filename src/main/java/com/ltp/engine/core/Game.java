package com.ltp.engine.core;

import com.ltp.engine.core.exception.GameException;
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
    private static boolean running = false;
    /** initialized - true if game data is initialized, false otherwise */
    @Getter
    private static boolean initialized = false;


    /**
     * init - Initialize game data, initializing other game subsystems
     *
     * @throws Throwable - will be thrown on double initialization
     */
    public static void init() throws Throwable {
        ExceptionalValidator.validate(!initialized, GameException.class, ExceptionalValidator.ValidationType.SOFT, "Double initialization found");

        initialized = true;
        LOGGER.info("Game initialized successfully");
    }

    /**
     * start - Start the game. Method {@link Game#init()} must be called before
     *
     * @throws Throwable - will be thrown on double start or start before {@link Game#init()}
     */
    public static void start() throws Throwable {
        ExceptionalValidator.validate(!running,
                GameException.class,
                ExceptionalValidator.ValidationType.SOFT,
                "Double start found");
        ExceptionalValidator.validate(initialized,
                GameException.class,
                ExceptionalValidator.ValidationType.RUDE,
                "Unable to start game, until it's not initialized ");

        running = true;

        LOGGER.info("Game started successfully");
    }

    /**
     * terminate - Terminate the game, all game subsystems. Method {@link Game#start()} must be called before
     * 
     * @throws Throwable - will be thrown on termination before {@link Game#init()} and {@link Game#start()}
     */
    public static void terminate() throws Throwable {
        ExceptionalValidator.validate(running, GameException.class, ExceptionalValidator.ValidationType.RUDE, "Unable to terminate game, if it isn't running");

        initialized = false;
        running = false;

        LOGGER.info("Game terminated successfully");
    }

}
