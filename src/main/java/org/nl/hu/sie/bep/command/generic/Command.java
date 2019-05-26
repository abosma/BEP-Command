package org.nl.hu.sie.bep.command.generic;

import java.io.BufferedReader;

public abstract class Command {
    public abstract void executeCommand(BufferedReader commandLineReader);
    public abstract boolean isPending();

    @Override
    public abstract String toString();
}
