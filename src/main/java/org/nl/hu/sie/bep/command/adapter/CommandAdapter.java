package org.nl.hu.sie.bep.command.adapter;

import org.nl.hu.sie.bep.domain.adapter.CommandAdaptee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandAdapter implements Adapter {

    private static Logger logger = LoggerFactory.getLogger(CommandAdapter.class);
    private static CommandAdaptee commandAdaptee = new CommandAdaptee();

    private CommandAdapter(){

    }

    public static void createIEFFilesFromMonthNumber(int monthNumber) {
        try {
            commandAdaptee.createIEFFilesFromMonthNumber(monthNumber);
        } catch (NullPointerException e) {
            logger.info("Something went wrong with converting the data, please try again.");
        }
    }
}
