package org.nl.hu.sie.bep.command.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nl.hu.sie.bep.command.generic.Command;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandHandlerTest {

    private BufferedReader testReader;
    private CommandHandler commandHandler;

    @BeforeEach
    void InitializeTest(){
        testReader = new BufferedReader(new InputStreamReader(System.in));
        commandHandler = new CommandHandler(testReader);
    }

    @Test
    void TestAddCommand(){
        Command mockCommand = mock(Command.class);

        commandHandler.addCommand(mockCommand);

        replay(mockCommand);

        assertEquals(commandHandler.commands.size(), 1);

        verify(mockCommand);
    }

    @Test
    void TestRemoveCommand(){
        Command mockCommand = mock(Command.class);
        commandHandler.addCommand(mockCommand);

        replay(mockCommand);

        assertEquals(commandHandler.commands.size(), 1);

        commandHandler.removeCommand(mockCommand);

        assertEquals(commandHandler.commands.size(), 0);

        verify(mockCommand);
    }

    @Test
    void TestPendingCommands(){
        Command mockCommand = mock(Command.class);

        expect(mockCommand.isPending()).andReturn(true);

        commandHandler.addCommand(mockCommand);

        replay(mockCommand);

        assertTrue(commandHandler.hasPendingCommands());

        verify(mockCommand);
    }
}
