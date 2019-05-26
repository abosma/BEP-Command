package org.nl.hu.sie.bep.command.commands;

import org.nl.hu.sie.bep.command.generic.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;

public class ConvertMonthDataToIEF extends Command {

    private static Logger logger = LoggerFactory.getLogger(ConvertMonthDataToIEF.class);

    private boolean isPending = true;

    @Override
    public void executeCommand(BufferedReader commandLineReader) {
        this.askForMonth(commandLineReader);
        this.isPending = false;
    }

    @Override
    public boolean isPending() {
        return isPending;
    }

    private void askForMonth(BufferedReader commandLineReader) {
        try {
            while(true) {
                logger.info("Please input a month number between 1 and 12.");

                int userInputInteger = parseUserInput(commandLineReader.readLine());

                if(monthIsValid(userInputInteger)){
                    logger.info("Creating files from databases...");
                    break;
                }
            }
        } catch (IOException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    private int parseUserInput(String userInput)
    {
        int parsedInteger = 0;

        try{
            parsedInteger = Integer.parseInt(userInput);
        }catch (NumberFormatException e){
            logger.error(e.getLocalizedMessage());
        }

        return parsedInteger;
    }

    private boolean monthIsValid(int inputMonth)
    {
        return inputMonth >= 1 && inputMonth <= 12;
    }

    @Override
    public String toString() {
        return "Convert Month Data To IEF";
    }
}
