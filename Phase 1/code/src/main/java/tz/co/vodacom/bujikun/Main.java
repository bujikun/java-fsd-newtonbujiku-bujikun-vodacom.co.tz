package tz.co.vodacom.bujikun;

import tz.co.vodacom.bujikun.util.AppUtility;
import tz.co.vodacom.bujikun.util.FileUtility;

import java.io.File;
import java.util.Arrays;

public class Main {
    private static boolean isNotTerminated = true;

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