package com.jph.myblog.utils;

import java.util.Calendar;

public class DateUtils {

    public static String getCurrentYear() {
        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    }
}
