package br.com.api.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class UtilsDate {

    private static UtilsDate instance;

    public Date getDateCurrent() {
        return Calendar.getInstance().getTime();
    }

    public String getDateCurrentAsString() {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                .format(Calendar.getInstance().getTime());
    }

    public static UtilsDate getInstance() {
        return instance == null ? new UtilsDate() : instance;
    }

    public Date incMinute(Date date, Integer minute) {
        if (date == null)
            date = getDateCurrent();
        date.setTime(date.getTime() + minute);
        return date;
    }

}
