package tz.co.vodacom.bujikun.util;

import tz.co.vodacom.bujikun.thread.InitialFilesGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileUtility {

    public static void createInitialFiles(String[] userFileNames){
        Thread fileCreatorThread;
        if(userFileNames.length>0){
             fileCreatorThread  = new Thread(new InitialFilesGenerator(userFileNames));
        }else{
            fileCreatorThread  = new Thread(new InitialFilesGenerator());
        }
        fileCreatorThread.start();
    }

    public static void deleteRootDirectory() {
        Path root = Paths.get("root");
        if(Files.exists(root)){
            Iterator<Path> itr= root.iterator();
            while (itr.hasNext()){
                try {
                    Files.deleteIfExists(itr.next());
                    System.out.println("deleted "+itr.next());
                } catch (IOException e) {
                    //throw new RuntimeException(e);
                }
            }
        }
    }

    public List<Path> getAllFilesInADirectory(String directoryName) {
        Path root = Paths.get("root");
        if(Files.exists(root)){
            Iterator<Path> itr= root.iterator();
            while (itr.hasNext()){
                try {
                    Files.deleteIfExists(itr.next());
                    System.out.println("deleted "+itr.next());
                } catch (IOException e) {
                    //throw new RuntimeException(e);
                }
            }
        }
        return new ArrayList<>();
    }

}
