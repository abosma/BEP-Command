package org.nl.hu.sie.bep.command.adapter;

import org.nl.hu.sie.bep.domain.adapter.CommandAdaptee;

public class CommandAdapter implements Adapter {

    private static CommandAdaptee commandAdaptee = new CommandAdaptee();

    private CommandAdapter(){

    }

    public static void createIEFFilesFromMonthNumber(int monthNumber) {
        commandAdaptee.createIEFFilesFromMonthNumber(monthNumber);
    }
}
