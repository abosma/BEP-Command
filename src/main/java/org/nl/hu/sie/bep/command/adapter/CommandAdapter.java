package org.nl.hu.sie.bep.command.adapter;

public class CommandAdapter implements Adapter {

    Adapter domainAdapter;

    public CommandAdapter(){

    }

    public void createIEFFilesFromMonthNumber(int monthNumber) {
        domainAdapter.createIEFFilesFromMonthNumber(monthNumber);
    }
}
