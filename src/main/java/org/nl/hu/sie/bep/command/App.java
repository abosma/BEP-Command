package org.nl.hu.sie.bep.command;

import org.nl.hu.sie.bep.command.input.InputHandler;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        InputHandler inputHandler = new InputHandler();

        inputHandler.createScanner();
        inputHandler.askForMonth();
    }
}
