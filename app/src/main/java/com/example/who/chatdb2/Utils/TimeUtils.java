package com.example.who.chatdb2.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by who on 22.07.2017.
 */

public class TimeUtils {
    public static String getNormalizedTime(String oldTime) {
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat myFormat = new SimpleDateFormat("HH:mm");
        String reformattedStr = "";
        try {
            reformattedStr = myFormat.format(fromUser.parse(oldTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return reformattedStr;
    }
}
