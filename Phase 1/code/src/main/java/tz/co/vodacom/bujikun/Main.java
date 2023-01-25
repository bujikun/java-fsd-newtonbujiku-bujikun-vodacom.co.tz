package tz.co.vodacom.bujikun;

import tz.co.vodacom.bujikun.util.AppUtility;
import tz.co.vodacom.bujikun.util.FileUtility;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileUtility.createInitialFiles(args);
        boolean isNotTerminated = true;
        AppUtility.displayTitle();
        AppUtility.displayMainMenu();
        AppUtility.display("%n%s%n", "Enter Option Number: \n");
        do {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> System.out.println("Chose 1");
                case 2 -> AppUtility.displaySubMenu();
                case 3 -> {
                    isNotTerminated = false;
                    FileUtility.deleteRootDirectory();
                }
            }
        } while (isNotTerminated);

    }
}