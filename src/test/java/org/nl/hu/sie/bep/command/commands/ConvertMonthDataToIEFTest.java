package org.nl.hu.sie.bep.command.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertMonthDataToIEFTest {

    private ConvertMonthDataToIEF convertMonthDataToIEF;

    @BeforeEach
    void InitializeTest(){
        convertMonthDataToIEF = new ConvertMonthDataToIEF();
    }

    @Test
    void TestUserInputParsingSuccess(){
        String SucceededInput = "1";

        assertEquals(convertMonthDataToIEF.parseUserInput(SucceededInput), 1);
    }

    @Test
    void TestUserInputParsingFailed(){
        String FailedInput = "asdf";

        assertEquals(convertMonthDataToIEF.parseUserInput(FailedInput), 0);
    }

    @Test
    void TestUserInputMonthSuccess(){
        int SucceededInputMinimum = 1;
        int SucceededInputMaximum = 12;

        assertTrue(convertMonthDataToIEF.monthIsValid(SucceededInputMinimum));
        assertTrue(convertMonthDataToIEF.monthIsValid(SucceededInputMaximum));
    }

    @Test
    void TestUserInputMonthFailed(){
        int FailedInputMinimum = 0;
        int FailedInputMaximum = 13;

        assertFalse(convertMonthDataToIEF.monthIsValid(FailedInputMinimum));
        assertFalse(convertMonthDataToIEF.monthIsValid(FailedInputMaximum));
    }

    @Test
    void TestCommandIsPending(){
        assertTrue(convertMonthDataToIEF.isPending());
    }

    @Test
    void TestOverrideToString(){
        assertEquals(convertMonthDataToIEF.toString(), "Convert Month Data To IEF");
    }
}
