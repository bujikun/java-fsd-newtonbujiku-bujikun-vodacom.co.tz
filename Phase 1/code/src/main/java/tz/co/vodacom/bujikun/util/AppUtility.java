package tz.co.vodacom.bujikun.util;

public class AppUtility {
    public static void displayTitle(){
        System.out.printf("%n%s%n","LockedMe.com File Management Application");
        System.out.printf("%s%n","Developer: Newton Bujiku - bujikun@vodacom.co.tz\n");
    }

    public static void displayMainMenu(){
        System.out.printf("%n%s%n","1. Display All Files (Ascending Order)");
        System.out.printf("%s%n","2. File Manipulation");
        System.out.printf("%s%n","3. Exit Application\n");

    }

    public static void displaySubMenu(){
        displayTitle();
        System.out.printf("%n%s%n","2. File Manipulation");
        System.out.printf("%s%n","a. Create a new file");
        System.out.printf("%s%n","b. Delete a file");
        System.out.printf("%s%n","c. Search a file");
        System.out.printf("%s%n","d. Go Back To Main Menu\n");

    }

    public static void display(String pattern,String message){
        System.out.printf(pattern,message);
    }


}
