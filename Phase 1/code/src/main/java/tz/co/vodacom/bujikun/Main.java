package tz.co.vodacom.bujikun;

import tz.co.vodacom.bujikun.util.AppUtility;
import tz.co.vodacom.bujikun.util.FileUtility;

import java.io.File;
import java.util.Arrays;

/**
 * Launches the application and presents the user
 * with 3 menu options to manipulate files or exit the application
 * @author Newton Bujiku
 * @since 2023
 */
public class Main {
    private static boolean isNotTerminated = true;

    /**
     * Entry point to the program
     * @param args Command line arguments that
     *             will be used to create files in the root directory
     * @author Newton Bujiku
     * @since 2023
     */
    public static void main(String[] args) {
        FileUtility.createInitialFiles(args);
        runFileWatcher();
        String choice = null;
        do {
            AppUtility.displayTitle();
            AppUtility.displayMainMenu();
            choice = AppUtility.readUserChoice("\tChoose option number 1/2/3? : ", "3", true);
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

    /**
     * Starts a thread that watches the root directory for
     * any file containing * character in its name and deletes it.
     * @author Newton Bujiku
     * @since 2023
     */
    public static void runFileWatcher() {
        new Thread(() -> {
            while (Main.isNotTerminated) {
                var root = new File(FileUtility.ROOT_PATH);
                try {
                    Arrays.stream(root.listFiles()).forEach(f -> {
                        if (f.getName().contains("*")) {
                            System.out.println("resolved *" + f.getAbsolutePath());
                            f.delete();
                        }
                    });
                } catch (Exception e) {
                }
            }
        }).start();
    }
}