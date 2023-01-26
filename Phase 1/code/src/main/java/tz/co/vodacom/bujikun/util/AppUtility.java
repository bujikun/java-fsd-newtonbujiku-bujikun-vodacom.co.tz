package tz.co.vodacom.bujikun.util;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Groups methods for general application manipulation
 * like displaying content and user navigation
 * @author Newton Bujiku
 * @since 2023
 */
public class AppUtility {
    /**
     * Prints the banner of the screen showing application and developer names
     * @author Newton Bujiku
     * @since 2023
     */
    public static void displayTitle() {
        System.out.printf("%n\t%s%n", "LockedMe.com - File Management Application");
        System.out.printf("\t%s%n", "Developer: Newton Bujiku - bujikun@vodacom.co.tz");
    }

    /**
     * Prints the app menu on the screen
     * @author Newton Bujiku
     * @since 2023
     */
    public static void displayMainMenu() {
        System.out.printf("%n\t%s%n", "1. Display All Files (Ascending Order)");
        System.out.printf("\t%s%n", "2. File Operations");
        System.out.printf("\t%s%n", "3. Exit Application\n");

    }
    /**
     * Prints the app menu on the screen
     * @author Newton Bujiku
     * @since 2023
     */
    public static void displaySubMenu() {
        display("%n\t%s%n", "2. File Operations");
        display("\t%s%n", "\ta. Create a new file");
        display("\t%s%n", "\tb. Delete a file");
        display("\t%s%n", "\tc. Search a file");
        display("\t%s%n", "\td. Search a file by character sequence");
        display("\t%s%n", "\t*. Back To Main Screen\n");
    }

    /**
     * Displays a given string after formatting it
     * @param pattern  a formatter string
     * @param message  the string to be formatted and printed on the screen
     * @author Newton Bujiku
     * @since 2023
     */
    public static void display(String pattern, String message) {
        System.out.printf(pattern, message);
    }

    /**
     * Prints file names on the screen
     * @param files Alist of file names to be printed
     * @author Newton Bujiku
     * @since 2023
     */
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

    /**
     * Responds to user input choice by opening an option
     * to display files or manipulate files
     * @param choice  User choice to be acted upon
     * @author Newton Bujiku
     * @since 2023
     */
    public static void handleMenuChoice(String choice) {
        switch (choice) {
            case "1" -> {
                AppUtility.displayFiles(FileUtility.getAllFileNamesInADirectory(FileUtility.ROOT_PATH));
                AppUtility.readUserChoice("\n\tEnter * to go back to main menu: ", "*", false);
            }
            case "2" -> {
                handlFileOperationChoice();
            }
        }
    }

    /**
     *Handles user operations such as file creation,deletion and searching
     * @author Newton Bujiku
     * @since 2023
     */
    public static void handlFileOperationChoice() {
        outer:
        do {
            AppUtility.displaySubMenu();
            String choice = readUserChoice("\tChoose an option a/b/c/d/*?: ");
            switch (choice) {
                case "a" -> {
                    FileUtility.createNewFile();
                }
                case "b" -> {
                    FileUtility.deleteFile();
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

    /**
     * Reads input from the user and make proper decision.
     * This will act upon either sub menu of file operations or
     * main menu
     * @param message Message prompt directing the user what to do
     * @param terminator Input that will terminate the loop
     * @param isMainMenu Application will react differently depending on where this method is
     *                   invoked
     * @return User entered choice that will be acted upon
     * @author Newton Bujiku
     * @since 2023
     */
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

    /**
     *Overloaded to read user input without listening for a
     * loop termination character
     * @param message Prompt to the user
     * @return User entered choice
     * @author Newton Bujiku
     * @since 2023
     */
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
