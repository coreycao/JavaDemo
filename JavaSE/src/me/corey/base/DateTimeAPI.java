package me.corey.base;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * demo the basic use of java date & time api
 * ref: http://www.importnew.com/16814.html
 */
public class DateTimeAPI {
    public static void main(String[] args) {
//        getToday();
//        getYMD();
//        generateDate();
//        compareDate();
//        monthDay();

//        getNowTime();
//        computeTime();
//        computeDate();

//        computeDate2();

//        getNow();

//        getClock();

//        compareWithClock();

//        beforeOrAfter();

//        getZoneDateTime();

//        getYearMonth();

//        checkLeapYear();

//        getPeriod();

//        format();

        customFormat();

        dateToString();
    }


    private static void getToday() {
        LocalDate today = LocalDate.now();
        System.out.println(today);
    }

    private static void getYMD() {
        LocalDate today = LocalDate.now();
        System.out.println(today.getYear());
        System.out.println(today.getMonth());
        System.out.println(today.getMonthValue());
        System.out.println(today.getDayOfMonth());
    }

    private static void generateDate() {
        LocalDate birthday = LocalDate.of(1991, 10, 1);
        System.out.println(birthday);
    }

    private static void compareDate() {
        LocalDate date = LocalDate.of(2018, 2, 11);
        LocalDate today = LocalDate.now();
        System.out.println(date.equals(today));
    }

    private static void monthDay() {
        LocalDate birthday = LocalDate.of(2011, 2, 11);
        MonthDay monthDay = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.now();
        System.out.println(currentMonthDay.equals(monthDay));
    }

    private static void getNowTime() {
        LocalTime time = LocalTime.now();
        System.out.println(time);
    }

    private static void computeTime() {
        LocalTime nowTime = LocalTime.now();
        LocalTime newTime = nowTime.plusHours(1).plusMinutes(2);
        System.out.println(newTime);
    }

    // 获取一周后的日期
    private static void computeDate() {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        nextWeek = today.plus(2, ChronoUnit.CENTURIES);
        System.out.println(nextWeek);
    }

    private static void computeDate2() {
        LocalDate today = LocalDate.now();
        System.out.println(today.minus(1, ChronoUnit.YEARS));
        System.out.println(today.plus(1, ChronoUnit.YEARS));
    }

    // 获取当前时间的一些方法
    private static void getNow() {
        System.out.println(new Date());
        System.out.println(new Date().getTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(Instant.now());
        System.out.println(new Date().toInstant());
    }

    private static void getClock() {
        Clock clock = Clock.systemUTC();
        System.out.println(clock);

        clock = Clock.systemDefaultZone();
        System.out.println(clock);
    }

    private static void compareWithClock() {
        Clock clock = Clock.systemUTC();

        LocalDate oldDate = LocalDate.of(2011, 11, 11);
        System.out.println(oldDate.isBefore(LocalDate.now(clock)));
    }

    private static void beforeOrAfter() {
        LocalTime now = LocalTime.now();
        LocalTime eve = now.minus(1, ChronoUnit.HOURS);
        System.out.println(now.isBefore(eve));
        System.out.println(now.isAfter(eve));
        System.out.println(now.isAfter(now));
        System.out.println(now.isBefore(now));
    }

    // timezone
    private static void getZoneDateTime() {

        ZoneId newyork = ZoneId.of("America/New_York");
        ZoneId shanghai = ZoneId.of("Asia/Shanghai");

        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime newyorktime = ZonedDateTime.of(localDateTime, newyork);
        ZonedDateTime shanghaitime = ZonedDateTime.of(localDateTime, shanghai);

        System.out.println(newyorktime);
        System.out.println(newyorktime.toLocalDate());
        System.out.println(newyorktime.toLocalTime());
        System.out.println(newyorktime.toLocalDateTime());
        System.out.println(newyorktime.toOffsetDateTime());
        System.out.println(newyorktime.getZone() + "\n");

        System.out.println(shanghaitime);
        System.out.println(shanghaitime.toLocalDate());
        System.out.println(shanghaitime.toLocalTime());
        System.out.println(shanghaitime.toLocalDateTime());
        System.out.println(shanghaitime.toOffsetDateTime());
        System.out.println(shanghaitime.getZone() + "\n");

        System.out.println(OffsetDateTime.of(localDateTime, shanghaitime.getOffset()));
        System.out.println(OffsetDateTime.of(localDateTime, newyorktime.getOffset()));

    }

    private static void getYearMonth() {
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth.getMonth());
        System.out.println(yearMonth.lengthOfMonth());

        YearMonth nextMonth = YearMonth.of(2018, Month.MARCH);
    }

    private static void checkLeapYear() {
        LocalDate now = LocalDate.now();
        System.out.println(now.isLeapYear());
    }

    private static void getPeriod() {
        LocalDate birthday = LocalDate.of(1991, 10, 10);
        LocalDate today = LocalDate.now();
        Period age = Period.between(birthday, today);
        System.out.println(age.getYears());
        System.out.println(age.getMonths());
        System.out.println(age.getDays());
        System.out.println(age.toTotalMonths());

        System.out.println(ChronoUnit.DAYS.between(birthday, today));
    }

    private static void format() {
        String today = "20180213";
        LocalDate formatedToday = LocalDate.parse(today, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(formatedToday);
    }

    private static void customFormat() {
        String holiday = "Apr 18 2014";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        LocalDate date = LocalDate.parse(holiday, formatter);
        System.out.println(date);
    }

    private static void dateToString() {
        LocalDateTime arrvialDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        String landing = arrvialDate.format(formatter);
        System.out.println(landing);
    }

}
