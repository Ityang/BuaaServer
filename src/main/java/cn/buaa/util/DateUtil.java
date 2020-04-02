
package cn.buaa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类名: DateUtil<br>
 * 类描述: 日期时间工具类<br>
 * Letter Date or Time Component Presentation Examples: <br>
 * G Era designator Text AD<br>
 * y Year Year 1996; 96<br>
 * M Month in year Month July; Jul; 07<br>
 * w Week in year Number 27<br>
 * W Week in month Number 2<br>
 * D Day in year Number 189<br>
 * d Day in month Number 10<br>
 * F Day of week in month Number 2<br>
 * E Day in week Text Tuesday; Tue<br>
 * a Am/pm marker Text PM<br>
 * H Hour in day (0-23) Number 0<br>
 * k Hour in day (1-24) Number 24<br>
 * K Hour in am/pm (0-11) Number 0<br>
 * h Hour in am/pm (1-12) Number 12<br>
 * m Minute in hour Number 30<br>
 * s Second in minute Number 55<br>
 * S Millisecond Number 978<br>
 * z Time zone General time zone Pacific Standard Time; PST; GMT-08:00<br>
 * Z Time zone RFC 822 time zone -0800<br>
 */
public class DateUtil {

    /**
     * Date Format without time: yyyy-MM-dd
     */
    public static final String FORMAT_DATE_01 = "yyyy-MM-dd";

    /**
     * Date Format without time: yyyyMMdd
     */
    public static final String FORMAT_DATE_02 = "yyyyMMdd";

    /**
     * Date Format with time: yyyy/MM/dd HH:mm:ss
     */
    public static final String FORMAT_TIME_01 = "yyyy/MM/dd HH:mm:ss";

    /**
     * Date Format with time: yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMAT_TIME_02 = "yyyy-MM-dd HH:mm:ss";

    /**
     * Date Format with time: yyyy-MM-dd HH:mm
     */
    public static final String FORMAT_TIME_03 = "yyyy-MM-dd HH:mm";

    /**
     * Date Format with time: yyyyMMddHHmmss
     */
    public static final String FORMAT_TIME_04 = "yyyyMMddHHmmss";

    /**
     * Date Format with time: yyyyMMddHH
     */
    public static final String FORMAT_TIME_05 = "yyyyMMddHH";

    /**
     * Date Format with time: yyyyMMddHHmm
     */
    public static final String FORMAT_TIME_06 = "yyyyMMddHHmm";

    /**
     * Date Format with time: yy/MM/dd HH:mm:ss
     */
    public static final String FORMAT_TIME_07 = "yy/MM/dd HH:mm:ss";

    /**
     * Date Format with time: yyyymmddhhmmss
     */
    public static final String FORMAT_TIME_08 = "yyyymmddhhmmss";

    /**
     * Date Format with time: HH:mm
     */
    public static final String FORMAT_TIME_09 = "HH:mm";

    /**
     * Date Format with time: yyyy年MM月dd日 E HH:mm:ss
     */
    public static final String FORMAT_TIME_10 = "yyyy年MM月dd日 E HH:mm:ss";

    /**
     * Date Format with time: yyyy年MM月dd日 E HH:mm
     */
    public static final String FORMAT_TIME_11 = "yyyy年MM月dd日 E HH:mm";

    /**
     * Date Format with time: 	yyyyMMddHHmmssSSS
     */
    public static final String FORMAT_TIME_12 = "yyyyMMddHHmmssSSS";

    /**
     * Date Format with time: yyyy-MM-dd HH:mm:ss.SSS 监控某些字段用到这个类型
     */
    public static final String FORMAT_TIME_13 = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * Date Format with time: yyyy/MM/dd
     */
    public static final String FORMAT_DATE_03 = "yyyy/MM/dd";

    /**
     * Date Format of weekday: E
     */
    public static final String FORMAT_WEERK_DAY = "E";

    /**
     * Time separator: ':'
     */
    public static final String TIME_SEPARATOR = ":";

    /**
     * 类名: WeekDay<br>
     * 类描述: 星期 - 枚举<br>
     */
    public enum WeekDay {
        SUN(0, "星期天"), MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4,
                "星期四"), FRI(5, "星期五"), SAT(6, "星期六");

        private int index;
        private String value;

        private WeekDay(int index, String value) {
            this.index = index;
            this.value = value;
        }

        /**
         * 获取星期枚举的序号
         *
         * @return int
         */
        public int getIndex() {
            return this.index;
        }

        /**
         * 获取星期枚举的描述（中文）
         *
         * @return String
         */
        public String getValue() {
            return this.value;
        }

        /**
         * 重写toString方法
         */
        @Override
        public String toString() {
            return this.value;
        }
    }

    /**
     * Slf4j logger
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DateUtil.class);

    /**
     * 将Date对象按指定的时间格式解析成String
     *
     * @param date    Date
     * @param pattern String, 时间格式, 如yyyy/MM/dd HH:mm:ss
     * @return String
     */
    public static String format(Date date, String pattern) {
        if (date == null || StringUtil.isNull(pattern)) {
            return null;
        }

        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 将Date对象按指定的时间格式解析成String
     *
     * @param date    Date
     * @param pattern String, 时间格式, 如yyyy/MM/dd HH:mm:ss
     * @param locale  Local, 地区格式
     * @return String
     */
    public static String format(Date date, String pattern, Locale locale) {
        if (date == null || StringUtil.isNull(pattern) || locale == null) {
            return null;
        }

        return new SimpleDateFormat(pattern, locale).format(date);
    }

    /**
     * 将Date对象按指定的时间格式解析成String，若Date对象为空，则返回当前时间
     *
     * @param date    Date
     * @param pattern String, 时间格式, 如yyyy/MM/dd HH:mm:ss
     * @return String
     */
    public static String formatAdvance(Date date, String pattern) {
        if (date == null) {
            date = new Date();
        }

        return format(date, pattern);
    }

    /**
     * 将String按指定的时间格式转化成Date对象
     *
     * @param str     String
     * @param pattern String, 时间格式, 如yyyy/MM/dd HH:mm:ss
     * @return Date
     */
    public static Date parse(String str, String pattern) {
        if (StringUtil.isNull(str) || StringUtil.isNull(pattern)) {
            return null;
        }

        Date date = null;
        try {
            date = new SimpleDateFormat(pattern).parse(str);
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return date;
    }

    /**
     * 将String按指定的时间格式转化成Date对象，若String为空，则返回当前时间
     *
     * @param str     String
     * @param pattern String, 时间格式, 如yyyy/MM/dd HH:mm:ss
     * @return Date
     */
    public static Date parseAdvance(String str, String pattern) {
        if (StringUtil.isNull(str)) {
            return new Date();
        }

        return parse(str, pattern);
    }

    /**
     * 获取两个时间点的间隔时长（秒），不区分先后顺序，即不会返回负值
     *
     * @param before Date
     * @param after  Date
     * @return long 时间间隔（秒）
     */
    public static long compareSec(Date before, Date after) {
        if (before == null || after == null) {
            return 0L;
        }
        long dif = after.getTime() - before.getTime();
        dif = Math.abs(dif);
        return dif / 1000;
    }


    /**
     * 获取两个时间点的间隔时长（分钟），不区分先后顺序，即不会返回负值
     *
     * @param before Date
     * @param after  Date
     * @return long 时间间隔（分钟）
     */
    public static long compareMin(Date before, Date after) {
        return compareSec(before, after) / 60;
    }

    /**
     * 获取两个时间点的间隔时长（分钟），不区分先后顺序，即不会返回负值
     *
     * @param before  String
     * @param after   String
     * @param pattern String, 时间格式, 如yyyy/MM/dd HH:mm:ss
     * @return long 时间间隔（分钟）
     */
    public static long compareMin(String before, String after, String pattern) {
//		return compareSec(before, after, pattern) / 60;
		return 0;
    }

    /**
     * 获取两个时间点的间隔时长（小时），不区分先后顺序，即不会返回负值
     *
     * @param before Date
     * @param after  Date
     * @return long 时间间隔（小时）
     */
    public static long compareHour(Date before, Date after) {
        return compareMin(before, after) / 60;
    }

    /**
     * 获取两个时间点的间隔时长（小时），不区分先后顺序，即不会返回负值
     *
     * @param before  String
     * @param after   String
     * @param pattern String, 时间格式, 如yyyy/MM/dd HH:mm:ss
     * @return long 时间间隔（小时）
     */
    public static long compareHour(String before, String after, String pattern) {
        return compareMin(before, after, pattern) / 60;
    }

    /**
     * 获取两个时间点的间隔时长（天），不区分先后顺序，即不会返回负值
     *
     * @param before Date
     * @param after  Date
     * @return long 时间间隔（天）
     */
    public static long compareDay(Date before, Date after) {
        return compareHour(before, after) / 24;
    }

    /**
     * 获取两个时间点的间隔时长（天），不区分先后顺序，即不会返回负值
     *
     * @param before  String
     * @param after   String
     * @param pattern String, 时间格式, 如yyyy/MM/dd HH:mm:ss
     * @return long 时间间隔（天）
     */
    public static long compareDay(String before, String after, String pattern) {
        return compareHour(before, after, pattern) / 24;
    }

    /**
     * 获取入参日期是星期几
     *
     * @param date Date
     * @return WeekDay 星期枚举
     */
    public static WeekDay convertWeek(Date date) {
        if (date == null) {
            return null;
        }

        String eDate = new SimpleDateFormat("E").format(date);
        for (WeekDay weekday : WeekDay.values()) {
            if (weekday.getValue().equals(eDate)) {
                return weekday;
            }
        }
        return null;
    }

    /**
     * 获取指定时间间隔分钟后的时间
     *
     * @param date Date
     * @param min  int
     * @return Date
     */
    public static Date addMinutes(Date date, int min) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, min);
        return calendar.getTime();
    }

    /**
     * 获取指定时间间隔秒后的时间
     *
     * @param date Date
     * @param sec  int
     * @return Date
     */
    public static Date addSecond(Date date, int sec) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, sec);
        return calendar.getTime();
    }

    /**
     * 获取当前时间间隔分钟后的时间
     *
     * @param min int
     * @return Date
     */
    public static Date addMinutes(int min) {
        return addMinutes(new Date(), min);
    }

    /**
     * 获取当前时间间隔秒后的时间
     *
     * @param sec int
     * @return Date
     */
    public static Date addSecond(int sec) {
        return addSecond(new Date(), sec);
    }

    /**
     * 获取当前时间对应的月份
     *
     * @return int
     */
    public static int getMonth(Date date) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        int month = now.get(Calendar.MONTH);
        return month;
    }

    /**
     * 判断两个时间是否处于同年同周
     *
     * @param first  Date
     * @param second Date
     * @return boolean
     */
    public static boolean inSameWeek(Date first, Date second) {
        if (first == null || second == null) {
            return false;
        }
        Calendar c1 = Calendar.getInstance();
        c1.setTime(first);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(second);
        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
                && c1.get(Calendar.WEEK_OF_YEAR) == c2
                .get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 判断两个时间是否处于同年同月同日
     *
     * @param first  Date
     * @param second Date
     * @return boolean
     */
    public static boolean isSameDay(Date first, Date second) {
        return ((format(first, FORMAT_DATE_02).substring(0, 8)).equals(format(
                second, FORMAT_DATE_02).substring(0, 8)));
    }

    /**
     * 判断两个时间是否处于同年同月同日同时
     *
     * @param first  Date
     * @param second Date
     * @return boolean
     */
    public static boolean isSameHour(Date first, Date second) {
        return ((format(first, FORMAT_TIME_05).substring(0, 10)).equals(format(
                second, FORMAT_TIME_05).substring(0, 10)));
    }

    /**
     * 判断两个时间是否处于同年同月同日同时同分
     *
     * @param first  Date
     * @param second Date
     * @return boolean
     */
    public static boolean isSameMin(Date first, Date second) {
        return ((format(first, FORMAT_TIME_06).substring(0, 12)).equals(format(
                second, FORMAT_TIME_06).substring(0, 12)));
    }

    /**
     * 获取当日零点时间
     *
     * @return long
     */
    public static long getInitTimeToday() {
        return getInitTime(new Date());
    }

    /**
     * 获取指定日前的零点时间
     *
     * @param date Date
     * @return long
     */
    public static long getInitTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }


    /**
     * 描 述：将当前时间转换成指定的格式字符串<br/>
     * 作 者：王天一<br/>
     * 历 史: (版本) 作者 时间 注释 <br/>
     *
     * @param pattern
     * @return String
     */
    public static String getCurrentTime(String pattern) {
        return format(new Date(), pattern);
    }

    /**
     * 描 述：根据传入的时间获取某一天的开始时间<br/>
     * 作 者：tian meng<br/>
     * 创 建： 2013-9-5<br/>
     * 版 本：1.3.0<br/>
     * <p>
     * 历 史: (版本) 作者 时间 注释 <br/>
     *
     * @param date 传入的时间
     * @param day  传入时间的某一天
     * @return
     */
    public static Date getSomeDayStartTime(Date date, int day) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(date);
        todayStart.add(Calendar.DAY_OF_MONTH, day);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 描 述：根据传入的时间获取某一天的结束时间<br/>
     * 作 者：tian meng<br/>
     * 创 建： 2013-9-5<br/>
     * 版 本：1.3.0<br/>
     * <p>
     * 历 史: (版本) 作者 时间 注释 <br/>
     *
     * @param date 传入的时间
     * @param day  传入时间的某一天
     * @return
     */
    public static Date getSomeDayEndTime(Date date, int day) {
        Calendar dateEnd = Calendar.getInstance();
        dateEnd.setTime(date);
        dateEnd.add(Calendar.DAY_OF_MONTH, day);
        dateEnd.set(Calendar.HOUR_OF_DAY, 23);
        dateEnd.set(Calendar.MINUTE, 59);
        dateEnd.set(Calendar.SECOND, 59);
        dateEnd.set(Calendar.MILLISECOND, 0);
        return dateEnd.getTime();
    }


    /**
     * 描 述： 返回昨天的开始时间 例如：2013-06-24 00:00:00<br/>
     * 作 者：廖东川<br/>
     * 日期: 2013-7-8  <br/>
     * 版本:1.2.0
     *
     * @return
     */
    public static Date getYesterdayStartTime() {
        return getSomeDayStartTime(new Date(), -1);
    }

    /**
     * 描 述： 返回昨天的结束时间 例如：2013-06-24 23:59:59<br/>
     * 作 者：廖东川<br/>
     * 日期: 2013-7-16  <br/>
     * 版本:1.2.0
     *
     * @return
     */
    public static Date getYesterdayzEndTime() {
        return getSomeDayEndTime(new Date(), -1);
    }


}
