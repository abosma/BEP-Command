package org.nl.hu.sie.bep.command.input;

import java.util.Scanner;

public class InputHandler {

    public Scanner createScanner()
    {
        return new Scanner(System.in);
    }

    public void askForMonth()
    {
        System.out.println("Please input a month number");
    }

}
