package org.nl.hu.sie.bep.command.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class ConvertMonthDataToIEFTest {

    private ConvertMonthDataToIEF convertMonthDataToIEF;

    @BeforeEach
    void InitializeTest(){
        convertMonthDataToIEF = new ConvertMonthDataToIEF();
    }

    @Test
    void TestUserInputParsingSuccess(){
        String SucceededInput = "1";

        assertThat(convertMonthDataToIEF.parseUserInput(SucceededInput), is(equalTo(1)));
    }

    @Test
    void TestUserInputParsingFailed(){
        String FailedInput = "asdf";

        assertThat(convertMonthDataToIEF.parseUserInput(FailedInput), is(equalTo(0)));
    }

    @Test
    void TestUserInputMonthSuccess(){
        int SucceededInputMinimum = 1;
        int SucceededInputMaximum = 12;

        assertThat(convertMonthDataToIEF.monthIsValid(SucceededInputMinimum), is(true));
        assertThat(convertMonthDataToIEF.monthIsValid(SucceededInputMaximum), is(true));
    }

    @Test
    void TestUserInputMonthFailed(){
        int FailedInputMinimum = 0;
        int FailedInputMaximum = 13;

        assertThat(convertMonthDataToIEF.monthIsValid(FailedInputMinimum), is(false));
        assertThat(convertMonthDataToIEF.monthIsValid(FailedInputMaximum), is(false));
    }

    @Test
    void TestCommandIsPending(){
        assertThat(convertMonthDataToIEF.isPending(), is(true));
    }

    @Test
    void TestOverrideToString(){
        assertThat(convertMonthDataToIEF.toString(), is(equalTo("Convert Month Data To IEF")));
    }
}
