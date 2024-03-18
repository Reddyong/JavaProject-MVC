package org.example;

import org.example.controller.CustomerController;
import org.example.controller.MedicalRecordController;
import org.example.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();

        consoleView.printSelectAndProcedure();
    }
}