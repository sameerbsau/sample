package java8features;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DateTimeAPI {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("current date==" + today);

        LocalDate firstDayOf2014 = LocalDate.of(2014, Month.JANUARY, 1);
        System.out.println(firstDayOf2014);

        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(todayKolkata);

        LocalDate datefromBase = LocalDate.ofEpochDay(365);
        System.out.println(datefromBase);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime specificTime = LocalTime.of(12, 20, 25, 40);
        System.out.println(specificTime);

        LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Time in IST=" + timeKolkata);


        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(localDateTime);

        LocalDateTime specificDate = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
        System.out.println("Specific Date=" + specificDate);

        LocalDateTime todayKolkata1 = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date in IST=" + todayKolkata1);

        Instant timestamp = Instant.now();
        System.out.println(timestamp);

        //Temporal Adjuster

        LocalDate date = LocalDate.now();
        System.out.println("is leap year::" + date.isLeapYear());

        System.out.println("is before 01/01/2015::" + today.isBefore(LocalDate.of(2015, 1, 1)));

        System.out.println("10 day from now will be::" + today.plusDays(10));
        System.out.println("3 weeks from now will be::" + today.plusWeeks(3));
        System.out.println("3 months from now will be::" + today.plusMonths(3));

        System.out.println("First day of this month will be::" + today.with(TemporalAdjusters.firstDayOfMonth()));


        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());

        Period period = today.until(lastDayOfYear);
        System.out.println("Period format::" + period);

        //formating
        //default format
        System.out.println("Default format of LocalDate=" + date);
        System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM:uuuu")));
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));


    }
}