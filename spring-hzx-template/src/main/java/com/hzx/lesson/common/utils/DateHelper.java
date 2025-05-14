package com.hzx.lesson.common.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author shenzh
 */
@UtilityClass
@Slf4j
public class DateHelper {

    public final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public final DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
    public final List<Integer> hoursList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23);
    private final ZoneId defaultZone = ZoneId.of("+08:00");

    /**
     * 收集起始时间到结束时间之间所有的时间并以字符串集合方式返回
     */
    public static List<String> collectLocalDates(LocalDate start, LocalDate end) {
        return Stream.iterate(start, localDate -> localDate.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end) + 1)
                .map(dateFormatter::format)
                .collect(Collectors.toList());
    }

    public static String getDateString(LocalDateTime time) {
        ZonedDateTime dateTime = ZonedDateTime.of(time, defaultZone);
        return dateTime.toString();
    }

    public static String getDateString(long time) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(time), defaultZone);
        return getDateString(localDateTime);
    }

    public static LocalDateTime getDateTime(long time) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(time), defaultZone);
    }

    /**
     * 获取当前时间戳
     */
    public static long now() {
        return Instant.now().getEpochSecond();
    }

    /**
     * 将时间转换成时间戳
     */
    public static Long toEpochSecond(LocalDateTime value) {
        if (null != value) {
            return value.atZone(defaultZone).toEpochSecond();
        }
        return null;
    }

    public static Integer toEpochSecond(LocalDate value) {
        return Optional.ofNullable(value)
                .map(LocalDate::atStartOfDay)
                .map(DateHelper::toEpochSecond)
                .map(Long::intValue)
                .orElse(null);
    }

    /**
     * 时间戳转LocalDateTime
     * @param seconds 秒
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(long seconds) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(seconds), defaultZone);
    }


    /**
     * 月天数
     */
    public static int getMaxDaysOfMonth(int yearMonth) {
        // 将输入的整型转换为年份和月份
        // 提取前四位作为年份
        int year = yearMonth / 100;
        // 提取后两位作为月份
        int month = yearMonth % 100;
        // 创建YearMonth对象
        YearMonth yearMonthObj = YearMonth.of(year, month);
        // 获取该月份的最大天数
        return yearMonthObj.lengthOfMonth();
    }

    //

    /**
     * 当前年月日
     */
    public static String getCurrentDate() {
        long l = System.currentTimeMillis();
        //new日期对象
        Date date = new Date(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(date);
    }

    public static String getCurrentDate(long timestamp) {
        //new日期对象
        Date date = new Date(timestamp * 1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    public static String getYesterdayDate() {
        // 获取当前日期的实例
        Calendar calendar = Calendar.getInstance();
        // 将日期减去一天
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        // 获取昨天的日期
        Date yesterday = calendar.getTime();
        // 格式化日期
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(yesterday);
    }

    /**
     * 指定时间戳的年月日
     */
    public static String getCurrentDateByTimestamp(long l) {
        //new日期对象
        Date date = new Date(l * 1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(date);
    }

    public static String getCurrentHoursByTimestamp(long l) {
        //new日期对象
        Date date = new Date(l * 1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
        return dateFormat.format(date);
    }

    /**
     * 当前年月日时分秒
     */
    public static String getCurrentDateWithT() {
        long l = System.currentTimeMillis();
        //new日期对象
        Date date = new Date(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return dateFormat.format(date);
    }

    /**
     * 今天0点的时间戳
     */
    public static long getTimestampWithYMD(long time) {
        try {
            String yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(new Date(time * 1000));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.parse(yyyyMMdd).getTime() / 1000;
        } catch (ParseException e) {
            log.error("getTimestampWithYMD error", e);
            return 0;
        }

    }

    /**
     * 字符串日期转时间戳
     * @param dateTimeString 字符串日期
     * @return 时间戳
     */
    public static long convertToTimestamp(String dateTimeString) {
        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");

        // 解析字符串为 LocalDateTime 对象
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

        // 转换为时间戳
        return toEpochSecond(dateTime);
    }

    /**
     * 获取当天七点整的时间戳
     * @return 时间戳
     */
    public static long getToday7AMTimestamp() {
        // 获取当前日期的 7 点整时间
        LocalDateTime today7AM = LocalDate.now().atTime(7, 0);

        // 将 LocalDateTime 转换为 ZonedDateTime，指定时区
        ZonedDateTime zonedDateTime = today7AM.atZone(ZoneId.systemDefault());

        // 转换为时间戳（秒级别）
        return zonedDateTime.toEpochSecond();
    }

    public static long convertToTimestamp(String dateTimeString, String pattern) {
        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        // 解析字符串为 LocalDateTime 对象
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

        // 转换为时间戳
        return toEpochSecond(dateTime);
    }

    /**
     * @return 返回过去12个月的月份数组
     */
    public static List<Integer> getLast12Months() {
        List<Integer> last12Months = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");

        for (int i = 12; i > 0; i--) {
            LocalDate date = currentDate.minusMonths(i);
            last12Months.add(Integer.parseInt(date.format(formatter)));
        }

        return last12Months;
    }

    /**
     * 输入yyyyMM，返回数组yyyyMMdd
     * @param yearMonth
     * @return
     */
    public static List<String> generateDateList(String yearMonth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        YearMonth ym = YearMonth.parse(yearMonth, formatter);

        List<String> dateList = new ArrayList<>();
        LocalDate startDate = ym.atDay(1);
        int lengthOfMonth = ym.lengthOfMonth();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        for (int day = 1; day <= lengthOfMonth; day++) {
            LocalDate date = startDate.plusDays(day - 1);
            dateList.add(date.format(dateFormatter));
        }

        return dateList;
    }

    /**
     * 过去三十天,今天不算在内
     * @return List<String>
     */
    public static List<String> getLastThirtyDays() {
        List<String> dates = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        for (int i = 1; i <= 30; i++) {
            String formattedDate = currentDate.minusDays(i).format(formatter);
            dates.add(formattedDate);
        }

        return dates;
    }

    public static List<String> getLastSevenDays() {
        List<String> dates = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        for (int i = 1; i <= 7; i++) {
            String formattedDate = currentDate.minusDays(i).format(formatter);
            dates.add(formattedDate);
        }

        return dates;
    }

    public static int getWeekOfYear(String dateStr) {
        // 定义解析日期的格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        // 将字符串转换为LocalDate对象
        LocalDate date = LocalDate.parse(dateStr, formatter);

        // 获取与系统默认区域相关的WeekFields实例
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        // 获取年份
        int year = date.getYear();
        // 获取日期在今年的第几周
        int weekOfYear = date.get(weekFields.weekOfYear());

        // 如果周数是个位数，前面补零
        String weekStr = String.format("%02d", weekOfYear);

        // 组合成"yyyyWW"格式并转换为整型
        return Integer.parseInt(year + weekStr);
    }

    public static LinkedHashMap<Integer, List<Integer>> groupDatesByWeek(List<Integer> dateList) {
        // 定义一个Map来存储周数和日期的对应关系
        LinkedHashMap<Integer, List<Integer>> weekToDatesMap = new LinkedHashMap<>(16);

        // 遍历输入的日期列表
        for (Integer dateInt : dateList) {
            // 将整数日期转换为字符串
            String dateString = dateInt.toString();

            // 使用DateTimeFormatter解析日期，格式为yyyyMMdd
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate date = LocalDate.parse(dateString, formatter);

            // 获取该日期所在年的第几周
            // ISO标准，以周一为一周的第一天
            WeekFields weekFields = WeekFields.ISO;
            int weekOfYear = date.get(weekFields.weekOfWeekBasedYear());
            int year = date.getYear();

            // 将周数和年份组合成类似202409的格式
            int weekKey = year * 100 + weekOfYear;

            // 将日期加入对应周的列表中
            weekToDatesMap.computeIfAbsent(weekKey, k -> new ArrayList<>()).add(dateInt);
        }

        return weekToDatesMap;
    }

    public static LinkedHashMap<Integer, List<Integer>> groupDatesByMonth(List<Integer> dateList) {
        // 定义一个Map来存储月份和日期的对应关系
        LinkedHashMap<Integer, List<Integer>> monthToDatesMap = new LinkedHashMap<>(16);

        // 遍历输入的日期列表
        for (Integer dateInt : dateList) {
            // 将整数日期转换为字符串
            String dateString = dateInt.toString();

            // 使用DateTimeFormatter解析日期，格式为yyyyMMdd
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate date = LocalDate.parse(dateString, formatter);

            // 获取该日期所在的月份
            int monthOfYear = date.getMonthValue();
            int year = date.getYear();

            // 将年份与月份组合成类似202406的格式
            int monthKey = year * 100 + monthOfYear;

            // 将日期加入对应月份的列表中
            monthToDatesMap.computeIfAbsent(monthKey, k -> new ArrayList<>()).add(dateInt);
        }

        return monthToDatesMap;
    }
}
