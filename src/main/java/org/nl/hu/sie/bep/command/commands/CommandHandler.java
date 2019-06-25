package org.nl.hu.sie.bep.command.commands;

import org.nl.hu.sie.bep.command.generic.Command;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class CommandHandler {

    List<Command> commands = new ArrayList<>();

    private BufferedReader commandLineHandler;

    public CommandHandler(BufferedReader commandLineHandler){
        this.commandLineHandler = commandLineHandler;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    void removeCommand(Command command) {
        commands.remove(command);
    }

    boolean hasPendingCommands() {
        return commands.stream().anyMatch(Command::isPending);
    }

    public void processPendingCommands(){
        for(Command command : commands){
            if(command.isPending()){
                command.executeCommand(commandLineHandler);
            }
        }
    }
}
