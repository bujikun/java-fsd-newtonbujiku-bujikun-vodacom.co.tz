package tz.co.vodacom.bujikun;

import tz.co.vodacom.bujikun.util.AppUtility;
import tz.co.vodacom.bujikun.util.FileUtility;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileUtility.createInitialFiles(args);
        boolean isNotTerminated = true;
//        String choice = AppUtility.readUserChoice("Enter Option Number 1/2/3: ",
//                "3", true);
//        while (!choice.equals("3")) {
//            switch (choice) {
//                case "1" -> {
//                    AppUtility.handleMenuChoice("1");
//                    AppUtility.readUserChoice("Enter  * to go back to main menu: ",
//                            "*", false);
//                }
//
//                case "2" -> AppUtility.displaySubMenu();
//
//            }
//            System.out.println("Returned to main menu");
//
//            choice = AppUtility.readUserChoice("Enter Option Number 1/2/3: ",
//                    "3", true);
//
//        }
//        FileUtility.deleteDirectory(FileUtility.ROOT_PATH);

        String choice = null;
        do {
            AppUtility.displayTitle();
            AppUtility.displayMainMenu();
            choice = AppUtility.readUserChoice("Choose Option Number 1/2/3? : ",
                    "3", true);
            switch (choice) {
                case "1" -> {
                    AppUtility.handleMenuChoice("1");
                    AppUtility.readUserChoice("\nEnter  * to go back to main menu: ", "*", false);
                }

                case "2" -> {
                    AppUtility.displaySubMenu();
                    AppUtility.readUserChoice("", "*", false);
                }


                case "3" -> {
                    isNotTerminated = false;
                    FileUtility.deleteDirectory(FileUtility.ROOT_PATH);
                }

            }
        } while (isNotTerminated);

    }
}