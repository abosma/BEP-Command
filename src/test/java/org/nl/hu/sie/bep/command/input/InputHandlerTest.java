package org.nl.hu.sie.bep.command.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputHandlerTest {

    private InputHandler inputHandler;

    @BeforeEach
    void InitializeTest(){
        inputHandler = mock(InputHandler.class);
    }

    @Test
    void TestUserInputParsingSuccess(){
        String SucceededInput = "1";

        expect(inputHandler.parseUserInput(SucceededInput)).andReturn(1);
        replay(inputHandler);

        assertEquals(inputHandler.parseUserInput(SucceededInput), 1);

        verify(inputHandler);
    }

    @Test
    void TestUserInputParsingFailed(){
        String FailedInput = "asdf";

        expect(inputHandler.parseUserInput(FailedInput)).andReturn(0);
        replay(inputHandler);

        assertEquals(inputHandler.parseUserInput(FailedInput), 0);

        verify(inputHandler);
    }
}
