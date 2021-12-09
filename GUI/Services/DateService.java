
package GUI.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateService {
    static SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
//    public static Date toDate(String date, String pattern) {
//        try {
//            formater.applyPattern(pattern);
//            return formater.parse(date);
//        } catch (Exception e) {
//            throw  new RuntimeException(e);
//        }
//    }
     public static Date toDate(String date,String...pattern){
        try {
            if(pattern.length>0)formater.applyPattern(pattern[0]);
            if(date==null)return DateService.now();
            return formater.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex); 
        }
    }
//    public static String toString(Date date, String pattern) {
//        if(date == null) {
//            return "";
//        }
//        formater.applyPattern(pattern);
//        return formater.format(date);
//    }
       public static String toString(Date date, String...pattern){
        if(pattern.length>0)formater.applyPattern(pattern[0]);
        if(date==null)date=DateService.now();
        return formater.format(date);
    }
     
     
    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days*24*60*60*1000);
        return date;
    }
      public static Date now() {
     return new Date(); 
    }
}
