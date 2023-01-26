package tz.co.vodacom.bujikun.util;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class AppUtility {
    public static void displayTitle() {
        System.out.printf("%n\t%s%n", "LockedMe.com - File Management Application");
        System.out.printf("\t%s%n", "Developer: Newton Bujiku - bujikun@vodacom.co.tz");
    }

    public static void displayMainMenu() {
        System.out.printf("%n\t%s%n", "1. Display All Files (Ascending Order)");
        System.out.printf("\t%s%n", "2. File Manipulation");
        System.out.printf("\t%s%n", "3. Exit Application\n");

    }

    public static void displaySubMenu() {
        display("%n\t%s%n", "2. File Manipulation");
        display("\t%s%n", "\ta. Create a new file");
        display("\t%s%n", "\tb. Delete a file");
        display("\t%s%n", "\tc. Search a file");
        display("\t%s%n", "\td. Search a file by character sequence");
        display("\t%s%n", "\t*. Back To Main Screen\n");
    }

    public static void display(String pattern, String message) {
        System.out.printf(pattern, message);
    }

    public static void displayFiles(List<String> files) {
        if (files.size() == 0) {
            display("\t%s%n", "\n\tNo files in the root directory");
            return;
        }
        AtomicInteger count = new AtomicInteger();
        display("\n\t%s%n", "ROOT DIRECTORY: " + new File(FileUtility.ROOT_PATH).getAbsolutePath());
        display("\t%s%n", "Available Files: \n");
        files = FileUtility.sortBySelectionSort(files);//sort file names before displaying
        files.stream().sorted().forEach(f -> {
            display("\t%s%n", count.incrementAndGet() + ". " + f);
        });
    }

    public static void handleMenuChoice(String choice) {
        switch (choice) {
            case "1" -> {
                AppUtility.displayFiles(FileUtility.getAllFileNamesInADirectory(FileUtility.ROOT_PATH));
                AppUtility.readUserChoice("\n\tEnter * to go back to main menu: ", "*", false);
            }
            case "2" -> {
                handlFileManipulationChoice();
            }
        }
    }

    public static void handlFileManipulationChoice() {
        outer:
        do {
            AppUtility.displaySubMenu();
            String choice = readUserChoice("\tChoose an option a/b/c/d/*?: ");
            switch (choice) {
                case "a" -> {
                    FileUtility.createNewFile();
                }
                case "b" -> {
                    FileUtility.deleteNewFile();
                }
                case "c" -> {
                    FileUtility.searchFile();
                }
                case "d" -> {
                    FileUtility.searchBySubstring();
                }
                case "*" -> {
                    break outer;
                }
            }
        } while (true);
    }

    public static String readUserChoice(String message, String terminator, boolean isMainMenu) {
        String input = null;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(message);
            input = scanner.nextLine();
            if (isMainMenu && input != null && terminator.matches("[1-3]")) {
                return input;
            }
        } while (input == null || !input.equals(terminator));
        return input;
    }

    public static String readUserChoice(String message) {
        String input = null;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(message);
            input = scanner.nextLine();
        } while (input == null);
        return input;
    }
}
