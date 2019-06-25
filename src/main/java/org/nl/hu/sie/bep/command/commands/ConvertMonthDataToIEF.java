package org.nl.hu.sie.bep.command.commands;

import org.nl.hu.sie.bep.command.adapter.CommandAdapter;
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
                    String userLogInfo = String.format("Month %s was chosen. Converting data to IEF file format...", userInputInteger);

                    logger.info(userLogInfo);

                    CommandAdapter.createIEFFilesFromMonthNumber(userInputInteger);
                    break;
                }
            }
        } catch (IOException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    protected int parseUserInput(String userInput)
    {
        int parsedInteger = 0;

        try{
            parsedInteger = Integer.parseInt(userInput);
        }catch (NumberFormatException e){
            logger.error(e.getMessage());
        }

        return parsedInteger;
    }

    protected boolean monthIsValid(int inputMonth)
    {
        return inputMonth >= 1 && inputMonth <= 12;
    }

    @Override
    public String toString() {
        return "Convert Month Data To IEF";
    }
}
