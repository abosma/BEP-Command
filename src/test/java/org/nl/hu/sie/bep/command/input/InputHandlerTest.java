package org.nl.hu.sie.bep.command.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputHandlerTest {

    private InputHandler inputHandler;

    @BeforeEach
    void InitializeTest(){
        inputHandler = new InputHandler();
    }

    @Test
    void TestUserInputParsingSuccess(){
        String SucceededInput = "1";

        assertEquals(inputHandler.parseUserInput(SucceededInput), 1);
    }

    @Test
    void TestUserInputParsingFailed(){
        String FailedInput = "asdf";

        assertEquals(inputHandler.parseUserInput(FailedInput), 0);
    }
}
