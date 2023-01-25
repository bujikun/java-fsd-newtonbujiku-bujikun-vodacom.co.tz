package tz.co.vodacom.bujikun.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class AppUtility {
    public static void displayTitle() {
        System.out.printf("%n\t%s%n", "LockedMe.com File Management Application");
        System.out.printf("\t%s%n", "Developer: Newton Bujiku - bujikun@vodacom.co.tz\n");
    }

    public static void displayMainMenu() {
        System.out.printf("%n\t%s%n", "1. Display All Files (Ascending Order)");
        System.out.printf("\t%s%n", "2. File Manipulation");
        System.out.printf("\t%s%n", "3. Exit Application\n");

    }

    public static void displaySubMenu() {
        System.out.printf("%n%s%n", "2. File Manipulation");
        System.out.printf("%s%n", "a. Create a new file");
        System.out.printf("%s%n", "b. Delete a file");
        System.out.printf("%s%n", "c. Search a file");
        System.out.printf("%s%n", "*. Go Back To Main Screen\n");

    }

    public static void display(String pattern, String message) {
        System.out.printf(pattern, message);
    }

    public static void displayFiles(List<? extends File> files) {
        if (files.size() == 0) {
            display("\t%s%n", "No Files");
            return;
        }
        AtomicInteger count = new AtomicInteger();
        System.out.println("\n");
        System.out.println("ROOT DIRECTORY: "+new File(FileUtility.ROOT_PATH).getAbsolutePath());
        System.out.println("Available Files: \n");

        files.stream()
                .sorted()
                .forEach(f -> {
                    display("\t%s%n", count.incrementAndGet() + ". " + f.toPath()
                            .getFileName().toString());
                });
    }

    public static void handleMenuChoice(String choice) {

        switch (choice) {
            case "1" -> {
                AppUtility.displayFiles(FileUtility.
                        getAllFilesInADirectory(FileUtility.ROOT_PATH));
                handleSubMenuChoice("1");
            }
            case "2" -> {

            }
            case "3" -> {

            }
        }
    }

    public static void handleSubMenuChoice(String choice) {
        switch (choice) {
            case "1" -> {
                //readUserChoice("Enter  * to go back to main menu: ", "*",false);
            }
            case "2" -> {

            }
            case "3" -> {

            }
        }
    }

    public static String readUserChoice(String message, String terminator, boolean isMainMenu) {
        String input = null;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(message);
            input = scanner.nextLine();
//            while ((input = scanner.nextLine()) == null) {
//
//            }
            if (isMainMenu && input != null && terminator.matches("[1-3]")) {
                return input;
            }
        } while (input == null || !input.equals(terminator));
        return input;
    }

}
