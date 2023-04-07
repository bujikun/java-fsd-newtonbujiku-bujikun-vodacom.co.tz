package tz.co.vodacom.bujikun.sportyshoes.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
    public static String convertDateTimeToString(LocalDateTime localDateTime){
       return  localDateTime.format(DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss"));
    }
    public static String convertDateToString(LocalDate localDate){
        return  localDate.format(DateTimeFormatter.ofPattern("uuuu-MM-dd"));
    }
//    public static LocalDate convertStringToDate(String dateString){
//        //return LocalDate.parse(dateString,DateTimeFormatter.ofPattern("uuuu-M-d"));
//        return LocalDate.parse(dateString,DateTimeFormatter.ofPattern("d-M-uuuu"));
//
//    }

}
