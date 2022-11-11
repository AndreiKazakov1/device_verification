package by.iba.kazakov.device_verification.dateformat;


import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateFormat {
        public static String dateFormat(String s) throws ParseException {
            new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(s));
            return s;
        }
}
