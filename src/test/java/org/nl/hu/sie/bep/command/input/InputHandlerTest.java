package org.nl.hu.sie.bep.command.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

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

        assertThat(inputHandler.parseUserInput(SucceededInput), is(equalTo(1)));

        verify(inputHandler);
    }

    @Test
    void TestUserInputParsingFailed(){
        String FailedInput = "asdf";

        expect(inputHandler.parseUserInput(FailedInput)).andReturn(0);
        replay(inputHandler);

        assertThat(inputHandler.parseUserInput(FailedInput), is(equalTo(0)));

        verify(inputHandler);
    }

    @Test
    void TestCommandInputBooleanReturnTrue(){
        int InputReturnTrue = 1;

        expect(inputHandler.userSelectsConvertDataToIEF(InputReturnTrue)).andReturn(true);
        replay(inputHandler);

        assertThat(inputHandler.userSelectsConvertDataToIEF(InputReturnTrue), is(true));

        verify(inputHandler);
    }

    @Test
    void TestCommandInputBooleanReturnFalse(){
        int InputReturnFalse = 0;

        expect(inputHandler.userSelectsConvertDataToIEF(InputReturnFalse)).andReturn(false);
        replay(inputHandler);

        assertThat(inputHandler.userSelectsConvertDataToIEF(InputReturnFalse), is(false));

        verify(inputHandler);
    }
}
