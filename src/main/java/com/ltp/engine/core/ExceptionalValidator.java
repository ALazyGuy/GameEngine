package com.ltp.engine.core;

import org.apache.logging.log4j.LogManager;

import java.lang.reflect.InvocationTargetException;

/**
 * ExceptionalValidator - this class should be used to throw exceptions if data is invalid
 *
 * @author Daniil Selin
 * @version 1.0.0 08 May 2021
 * @since 1.0.0
 * @see com.ltp.engine.core.exception
 */
public class ExceptionalValidator {

    /**
     * ValidationType - contains validator reaction type on invalid data:
     * {@link ValidationType#SOFT} - throw an exception
     * {@link ValidationType#RUDE} - terminate program with fatal error log message
     *
     * @author Daniil Selin
     * @version 1.0.0 08 May 2021
     * @since 1.0.0
     */
    public enum ValidationType{
        RUDE, SOFT
    }

    /**
     * validate - if condition is false throw Exception or terminate program
     *
     * @param condition - true if data is valid, false otherwise
     * @param exception - exception class that will be thrown if condition is false
     * @param validationType - validator reaction type on invalid data {@link ValidationType}
     * @param message - message that will be show if data is invalid
     * @throws Throwable - throw exception if data is invalid and validationType is {@link ValidationType#SOFT}
     * @see ValidationType
     */
    public static void validate(boolean condition, Class<? extends Exception> exception, ValidationType validationType, String message) throws Throwable {
        if(!condition){
            Throwable instance = null;
            if(validationType == ValidationType.RUDE){
                LogManager.getLogger(exception).fatal(message);
                System.exit(-1);
            }
            try {
                instance =  exception.getConstructor(String.class).newInstance(message);
            } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
                e.printStackTrace();
            }
            throw instance;
        }
    }

}
