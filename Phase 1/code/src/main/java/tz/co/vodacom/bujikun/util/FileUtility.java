package tz.co.vodacom.bujikun.util;

import tz.co.vodacom.bujikun.thread.InitialFilesGeneratorRunnable;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This contains static methods for file operations
 * @author Newton Bujiku
 * @since 2023
 */
public class FileUtility {
    /**
     * Root directory name
     */
    public static final String ROOT_PATH = "root";

    /**
     * Launches a thread to create initial files in the directory
     * from the command line arguments.
     * @param userFileNames An array of user provided strings to be used
     *                      as filenames
     * @author Newton Bujiku
     * @since 2023
     */
    public static void createInitialFiles(String[] userFileNames) {
        new Thread(new InitialFilesGeneratorRunnable(userFileNames)).start();
    }

    /**
     * Deletes a directory after looping through each contained file and deleting them.
     * @param dirName Name of the directory to be deleted
     * @author Newton Bujiku
     * @since 2023
     */
    public static void deleteDirectory(String dirName) {
        var root = new File(Paths.get(dirName).toAbsolutePath().toString());
        if (root.exists()) {
            Arrays.stream(root.listFiles()).forEach(file -> file.delete());
            root.delete();
        }
    }

    /**
     * Fetches all the names of the files in the directory
     *
     * @param directoryName Name of the directory
     * @return List of file names
     * @author Newton Bujiku
     * @since 2023
     */
    public static List<String> getAllFileNamesInADirectory(String directoryName) {
        var directory = new File(Paths.get(directoryName).toAbsolutePath().toString());
        if (directory.exists()) {
            return Arrays.stream(directory.listFiles()).map(f -> f.toPath().getFileName().toString()).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    /**
     * Sorts a given list using a Selection Sort
     * @param files A list of file names to be sorted
     * @return A list contained sorted file names in ascending order
     * @author Newton Bujiku
     * @since 2023
     */
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

    /**
     * Creates a new file in the directory if it adheres to the provided rules
     * @author Newton Bujiku
     * @since 2023
     */
    public static void createNewFile() {
        AppUtility.display("\t%s%n%n", "2a. File Creation");
        String fileName = AppUtility.readUserChoice("\tEnter file name or * to go back: ");
        if (fileName.equals("*")) {
            return;
        }
        try {
            if (fileName.contains("*")) {
                throw new InvalidPathException("", "");
            }
            var filePath = Paths.get(ROOT_PATH).resolve(fileName);
            if (!Files.exists(Paths.get(ROOT_PATH))) {
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

    /**
     * Reads input from the user for a file name and deletes it if
     * it's present.
     * @author Newton Bujiku
     * @since 2023
     */
    public static void deleteFile() {
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

    /**
     * Reads input from the user for an exact file name and searches for it and
     * prints the results on the screen
     * @author Newton Bujiku
     * @since 2023
     */
    public static void searchFile() {
        AppUtility.display("\t%s%n", "2b. File Search\n");
        String fileName = AppUtility.readUserChoice("\tEnter exact name of the file to be searched or * to go back: ");
        if (fileName.equals("*")) {
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

    /**
     * Reads input from the user for a sequence of characters and checks if
     * it matches any file names and prints the results on the screen
     * @author Newton Bujiku
     * @since 2023
     */
    public static void searchBySubstring() {
        AppUtility.display("\t%s%n", "2b. File Search By Character Sequence\n");
        String charSeq = AppUtility.readUserChoice("\tEnter character(s) to  be used in search or * to go back: ");
        if (charSeq.equals("*")) {
            return;
        }
        List<String> fileNames = getAllFileNamesInADirectory(ROOT_PATH);
        if (fileNames.size() < 0) {
            System.out.println("\n\tCan not perform search. No files in the root directory");
            return;
        }
        var sortedFileNames = sortBySelectionSort(fileNames);
        //do search
        List<String> found = fileNames.stream()
                .filter(s -> containsSubstring(s, charSeq))
                .collect(Collectors.toList());
        if (found.size() > 0) {
            System.out.println("\n\tFound " + found.size() + " files : \n");
            found.stream().forEach(s -> System.out.println("\t\t" + s));
            return;
        }
        System.out.println("\n\tNo file with a name like that");
    }

    /**
     * Does a binary search of a given string from a list of file names
     *
     * @param list A list of file names to be searched
     * @param searchString A string to be used for searching
     * @return An integer value indicating if  the search string was
     * found.
     * @author Newton Bujiku
     * @since 2023
     */
    public static int binarySearch(List<String> list, String searchString) {
        int low = 0;
        int high = list.size() - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (list.get(mid).compareTo(searchString) < 0) {
                low = mid + 1;
            } else if (list.get(mid).compareTo(searchString) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Checks if the givem character sequence appears on a given string
     * @param searchMe A string to checked
     * @param findMe a string that will be looked at if it appears in another string
     * @return a boolean value indicating if a substring was found or not
     * @author Newton Bujiku
     * @since 2023
     */
    public static boolean containsSubstring(String searchMe, String findMe) {
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
