package com.ltp.engine.core.exception;

/**
 * GameException - This exception will be thrown if discovered problems
 * with game environment.
 *
 * @author Daniil Selin
 * @version 1.0.0 08 May 2021
 * @since 1.0.0
 * @see com.ltp.engine.core.Game
 */
public class GameException extends Exception {

    public GameException(String message) {
        super(message);
    }

    public GameException(String message, Throwable cause) {
        super(message, cause);
    }
}
