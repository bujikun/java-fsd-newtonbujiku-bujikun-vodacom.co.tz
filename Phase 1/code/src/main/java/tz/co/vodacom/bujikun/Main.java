package tz.co.vodacom.bujikun;

import tz.co.vodacom.bujikun.util.AppUtility;
import tz.co.vodacom.bujikun.util.FileUtility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private  static boolean isNotTerminated = true;

    public static void main(String[] args) {
        FileUtility.createInitialFiles(args);
        runFileWatcher(isNotTerminated);
        String choice = null;
        do {
            AppUtility.displayTitle();
            AppUtility.displayMainMenu();
            choice = AppUtility.readUserChoice("\tChoose option number 1/2/3? : ",
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

    public static  void runFileWatcher(boolean isNotTerminated){
        new Thread(()->{
            while(isNotTerminated){
                var invalidFile = Paths.get(FileUtility.ROOT_PATH);
                if(invalidFile.getFileName().toString().matches("'^[^*&%\\s]+$'")&&Files.exists(invalidFile)){
                    System.out.println("resolved *"+invalidFile.toAbsolutePath());
                    try {
                        Files.delete(invalidFile);
                    } catch (IOException e) {
                        //throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
}