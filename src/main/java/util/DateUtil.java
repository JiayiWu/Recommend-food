package util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jiayiwu on 17/4/14.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public class DateUtil {
    public static int dayForWeek() throws Exception {
        SimpleDateFormat   format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(getDate()));
        int dayForWeek = 0;
        if(c.get(Calendar.DAY_OF_WEEK) == 1){
            dayForWeek = 7;
        }else{
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }
    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    public static boolean isLate(){
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int day = 0;
        try {
             day = dayForWeek();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (day == 1 || day == 2 || day ==3){
            if (hour>7&&minute>15)
                return true;
        }
        return false;
    }
}
