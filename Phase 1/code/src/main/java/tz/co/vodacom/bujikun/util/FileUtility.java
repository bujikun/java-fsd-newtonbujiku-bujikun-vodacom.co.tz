package tz.co.vodacom.bujikun.util;

import tz.co.vodacom.bujikun.thread.InitialFilesGeneratorRunnable;

import java.io.File;
import java.nio.file.Paths;
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
            Arrays.stream(root.listFiles())
                    .forEach(file -> file.delete());
            root.delete();
        }
    }

    public static List<String> getAllFileNamesInADirectory(String directoryName) {
        var directory = new File(Paths.get(directoryName).toAbsolutePath().toString());
        if (directory.exists()) {
            return Arrays.stream(directory.listFiles())
                    .map(f -> f.toPath().getFileName().toString())
                    .collect(Collectors.toList());
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
                if (files.get(j).compareTo(files.get(pos)) < 0)
                {
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

}
