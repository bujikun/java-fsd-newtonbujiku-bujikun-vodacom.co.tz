package tz.co.vodacom.bujikun;

import tz.co.vodacom.bujikun.util.AppUtility;
import tz.co.vodacom.bujikun.util.FileUtility;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileUtility.createInitialFiles(args);
        boolean isNotTerminated = true;
        String choice = null;
        do {
            AppUtility.displayTitle();
            AppUtility.displayMainMenu();
            choice = AppUtility.readUserChoice("Choose Option Number 1/2/3? : ",
                    "3", true);
            switch (choice) {
                case "1" -> {
                    AppUtility.handleMenuChoice("1");
                }

                case "2" -> {
                    AppUtility.handleMenuChoice("2");
                }


                case "3" -> {
                    isNotTerminated = false;
                    FileUtility.deleteDirectory(FileUtility.ROOT_PATH);
                }

            }
        } while (isNotTerminated);

    }
}