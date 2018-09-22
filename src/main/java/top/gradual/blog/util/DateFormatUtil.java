package top.gradual.blog.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 日期格式化类
 * @Author: gradual
 * @Date: 2018-09-06 21:50
 */
public class DateFormatUtil {

    public static String format(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }
}
