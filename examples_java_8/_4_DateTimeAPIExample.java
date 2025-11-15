/*
 * PROGRAM OBJECTIVE:
 * This program demonstrates Java 8 Date and Time API:
 * 1. LocalDate, LocalTime, LocalDateTime
 * 2. Date formatting and parsing
 * 3. Date calculations and comparisons
 * 4. Working with time zones
 */

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class _4_DateTimeAPIExample {
    public static void main(String[] args) {
        System.out.println("=== Java 8 Date and Time API ===");
        
        // 1. Basic Date and Time
        System.out.println("\n1. Basic Date and Time:");
        
        LocalDate today = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime now = LocalDateTime.now();
        
        System.out.println("Today: " + today);
        System.out.println("Current time: " + currentTime);
        System.out.println("Now: " + now);
        
        // 2. Creating Specific Dates
        System.out.println("\n2. Creating Specific Dates:");
        
        LocalDate birthday = LocalDate.of(1990, Month.JANUARY, 15);
        LocalTime meetingTime = LocalTime.of(14, 30);
        LocalDateTime appointment = LocalDateTime.of(2024, 12, 25, 10, 0);
        
        System.out.println("Birthday: " + birthday);
        System.out.println("Meeting time: " + meetingTime);
        System.out.println("Appointment: " + appointment);
        
        // 3. Date Formatting
        System.out.println("\n3. Date Formatting:");
        
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        
        System.out.println("Formatted date 1: " + today.format(formatter1));
        System.out.println("Formatted date 2: " + today.format(formatter2));
        
        // 4. Date Calculations
        System.out.println("\n4. Date Calculations:");
        
        LocalDate nextWeek = today.plusWeeks(1);
        LocalDate lastMonth = today.minusMonths(1);
        LocalDate nextYear = today.plusYears(1);
        
        System.out.println("Next week: " + nextWeek);
        System.out.println("Last month: " + lastMonth);
        System.out.println("Next year: " + nextYear);
        
        // 5. Date Comparisons
        System.out.println("\n5. Date Comparisons:");
        
        LocalDate date1 = LocalDate.of(2024, 1, 1);
        LocalDate date2 = LocalDate.of(2024, 12, 31);
        
        System.out.println("Date1 is before Date2: " + date1.isBefore(date2));
        System.out.println("Date1 is after Date2: " + date1.isAfter(date2));
        
        // 6. Period and Duration
        System.out.println("\n6. Period and Duration:");
        
        Period period = Period.between(birthday, today);
        System.out.println("Age: " + period.getYears() + " years, " + 
                          period.getMonths() + " months, " + 
                          period.getDays() + " days");
        
        long daysBetween = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("Days lived: " + daysBetween);
        
        // 7. Time Zones
        System.out.println("\n7. Time Zones:");
        
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime tokyoTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        
        System.out.println("UTC time: " + utcTime);
        System.out.println("Tokyo time: " + tokyoTime);
    }
}