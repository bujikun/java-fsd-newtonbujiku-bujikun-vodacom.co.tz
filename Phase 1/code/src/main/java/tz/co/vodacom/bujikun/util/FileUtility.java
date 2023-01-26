package tz.co.vodacom.bujikun.util;

import tz.co.vodacom.bujikun.thread.InitialFilesGeneratorRunnable;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtility {
    public static final String ROOT_PATH = "root";

    public static void createInitialFiles(String[] userFileNames) {
        Thread fileCreatorThread;
        if (userFileNames.length > 0) {
            fileCreatorThread = new Thread(new InitialFilesGeneratorRunnable(userFileNames));
        } else {
            fileCreatorThread = new Thread(new InitialFilesGeneratorRunnable());
        }
        fileCreatorThread.start();
    }

    public static void deleteDirectory(String dirName) {
        var root = new File(Paths.get(dirName).toAbsolutePath().toString());
        if (root.exists()) {
            Arrays.stream(root.listFiles()).forEach(file -> file.delete());
            root.delete();
        }
    }

    public static List<String> getAllFileNamesInADirectory(String directoryName) {
        var directory = new File(Paths.get(directoryName).toAbsolutePath().toString());
        if (directory.exists()) {
            return Arrays.stream(directory.listFiles()).map(f -> f.toPath().getFileName().toString()).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public static List<String> sortBySelectionSort(List<String> files) {
        int pos;
        String temp;
        for (int i = 0; i < files.size(); i++) {
            pos = i;
            for (int j = i + 1; j < files.size(); j++) {
                //find the index of the minimum filename
                //ignoring case
                if (files.get(j).compareTo(files.get(pos)) < 0) {
                    pos = j;
                }
            }
            //swap the current filename with the minimum filename
            temp = files.get(pos);
            files.set(pos, files.get(i));
            files.set(i, temp);
        }
        return files;
    }

    public static void createNewFile() {
        AppUtility.display("\t%s%n%n", "2a. File Creation");
        String fileName = AppUtility.readUserChoice("\tEnter file name or * to go back: ");
        if (fileName.equals("*")) {
            return;
        }
        try {
            if (fileName.contains("*")) {
                throw new InvalidPathException("","");
            }
            var filePath = Paths.get(ROOT_PATH).resolve(fileName);
            if(!Files.exists(Paths.get(ROOT_PATH))){
                Files.createDirectory(Paths.get(ROOT_PATH));
            }
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
            System.out.println("\n\tFile successfully created: " + filePath);
            AppUtility.displayFiles(FileUtility.getAllFileNamesInADirectory(FileUtility.ROOT_PATH));
        } catch (InvalidPathException e) {
            System.out.println("\n\tInvalid filename supplied. Please try to use non alphanumeric characters");

        } catch (IOException e) {
            System.out.println("\n\tFile could not be created due to failed IO operations");
        }

    }

    public static void deleteNewFile() {
        AppUtility.display("\t%s%n", "2b. File Deletion\n");
        var fileNames = FileUtility.getAllFileNamesInADirectory(ROOT_PATH);
        if (fileNames.size() <= 0) {
            //no files to delete
            AppUtility.display("\t%s%n", "No files in the root directory, going back!");
            return;
        }
        AppUtility.displayFiles(fileNames);
        String fileName = AppUtility.readUserChoice("\n\tEnter name of the file to be deleted or * to go back: ");
        if (fileName.equals("*")) {
            return;
        }
        System.out.println();
        try {
            var filePath = Paths.get(ROOT_PATH).resolve(fileName);
            if (Files.exists(filePath)) {
                Files.delete(filePath);
                System.out.println("\n\tFile successfully deleted: " + filePath.toAbsolutePath());
                return;
            }

        } catch (InvalidPathException e) {
            System.out.println("\n\tInvalid filename supplied. Please try to use non alphanumeric characters");


        } catch (NoSuchFileException e) {
            System.out.println("\n\tThe file name you entered does not exist in the directory");

        } catch (DirectoryNotEmptyException e) {
            System.out.println("\n\tYou can not delete a non empty directory");

        } catch (IOException e) {
            System.out.println("\n\tFile could not be deleted due to failed IO operations");
        }
        System.out.println("\n\tThe file name you entered does not exist in the directory");

    }

    public static void searchFile() {
        AppUtility.display("\t%s%n", "2b. File Search\n");
        String fileName = AppUtility.readUserChoice("\tEnter name of the file to be searched or * to go back: ");
        if(fileName.equals("*")){
            return;
        }
        List<String> fileNames = getAllFileNamesInADirectory(ROOT_PATH);
        if (fileNames.size() < 0) {
            System.out.println("\n\tCan not perform search. No files in the root directory");
            return;
        }
        var sortedFileNames = sortBySelectionSort(fileNames);
        if (binarySearch(sortedFileNames, fileName) != -1) {
            System.out.println("\n\tFound file: " + new File(fileName).getAbsolutePath());
            return;
        }
        System.out.println("\n\tFile not present in the root directory");
    }

    public static int binarySearch(List<String> a, String searchString) {
        int low = 0;
        int high = a.size() - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (a.get(mid).compareTo(searchString) < 0) {
                low = mid + 1;
            } else if (a.get(mid).compareTo(searchString) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static boolean containsSubstring(String searchMe, String findMe){
        int searchMeLength = searchMe.length();
        int findMeLength = findMe.length();
        boolean foundIt = false;
        for (int i = 0;
             i <= (searchMeLength - findMeLength);
             i++) {
            if (searchMe.regionMatches(i, findMe, 0, findMeLength)) {
                 foundIt = true;
                break;
            }
        }
        return foundIt;
    }


}
