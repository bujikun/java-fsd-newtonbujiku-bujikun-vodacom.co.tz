package tz.co.vodacom.bujikun.kitchenstories.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class DateUtil {
    private static final String DATE_TIME_PATTERN = "dd-MM-yyyy HH:mm:ss";
    public  String fromLocalDateTime(LocalDateTime localDateTime){
        return localDateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
    }
    public  LocalDateTime fromString(String timeString){
        return LocalDateTime.parse(timeString,DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
    }

    public  LocalDateTime now(){
        return LocalDateTime.now();
    }
}
