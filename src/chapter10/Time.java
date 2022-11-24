package chapter10;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQueries;
import java.util.Date;

public class Time {
    public static void main(String[] args) {
//        Temporal Objects - the objects that changes over the time

        var date = LocalDate.now();
        var time = LocalTime.now();
        var dt = LocalDateTime.now();
        var ins = Instant.now();
        var zdt = ZonedDateTime.now();


        System.out.println(date);
        System.out.println(time);
        System.out.println(dt);
        System.out.println(ins);
        System.out.println(zdt);

        var date1 = LocalDate.of(2012, Month.JANUARY, 01);
        System.out.println(date1);

        System.out.println(ZoneId.getAvailableZoneIds());

        dt.atZone(ZoneId.of("America/Panama"));
        System.out.println(dt);

        System.out.println(Month.FEBRUARY.length(true));
        Month.AUGUST.firstDayOfYear(true);

        System.out.println(LocalDate.now().plusMonths(30));
        LocalDate.now().plus(Period.of(2, 3, 8));
        LocalDate.now().plus(1, ChronoUnit.CENTURIES);

        System.out.println(LocalDate.now().withMonth(1));

        // Adjusters, queries
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println(LocalDate.now().query(TemporalQueries.precision()));
        System.out.println(ZonedDateTime.now().query(TemporalQueries.zone()));

//        java.util.Date
//        java.util.Calendar

        Date date2 = new Date();
        date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

//        java.sql.Date

        new java.sql.Date(new Date().getTime()).toLocalDate();

        System.out.println(LocalDate.parse("2012/01/12", DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        LocalDate today = LocalDate.now();
        LocalDate target = LocalDate.of(2023, 12, 12);

        Period until = today.until(target);
        System.out.println(until);
        System.out.println(until.getDays());

        Period.between(today, target);

        System.out.println(Duration.between(Instant.now(), Instant.now()));

        System.out.println(ChronoUnit.MONTHS.between(today, target));


    }
}
