package tz.co.vodacom.bujikun.sportyshoes.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
    public static String convertDateTimeToString(LocalDateTime localDateTime){
       return  localDateTime.format(DateTimeFormatter.ofPattern("dd - MM - yyyy HH:mm:ss"));
    }
    public static LocalDateTime convertStringToDateTime(String dateString){
        return LocalDateTime.parse(dateString);
    }
}
