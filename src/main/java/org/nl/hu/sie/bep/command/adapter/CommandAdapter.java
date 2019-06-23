package org.nl.hu.sie.bep.command.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.nl.hu.sie.bep.domain.adapter.*;

public class CommandAdapter implements Adapter {

    private static Logger logger = LoggerFactory.getLogger(CommandAdapter.class);
    private static CommandAdaptee commandAdaptee = new CommandAdaptee();

    private CommandAdapter(){

    }

    public static void createIEFFilesFromMonthNumber(int monthNumber) {
        String userLogInfo = String.format("Month %s was chosen.", monthNumber);

        commandAdaptee.createIEFFilesFromMonthNumber(monthNumber);
    }
}
