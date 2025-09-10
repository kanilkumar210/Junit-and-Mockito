package com.company.employeeapplication;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Scheduler {

    // Runs every 1 second (1000 ms)
    @Scheduled(fixedRate = 1000)
    public void runAtFixedRate() {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = current.format(format);
        System.out.println("Running with fixed rate " + formattedDateTime);
    }

    // Runs 5 seconds after the previous execution finishes
    @Scheduled(fixedDelay = 5000)
    public void runWithFixedDelay() {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = current.format(format);
        System.out.println("Running with fixedDelay " + formattedDateTime);
    }

    // Starts after 10 seconds, then runs every 5 seconds
    @Scheduled(fixedRate = 5000, initialDelay = 10000)
    public void runWithInitialDelay() {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = current.format(format);
        System.out.println("Running with initialDelay " + formattedDateTime);
    }
//
//    PT3S means Period of Time = 3 Seconds
//
//    PT10M → 10 minutes
//
//    PT1H → 1 hour
//
//    P1D → 1 day
    @Scheduled(fixedRateString = "PT3S", initialDelay = 10000)
    public void runWithInitialDelayAndFixedRateString() {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = current.format(format);
        System.out.println("Running with initialDelay with Fixed Rate String " + formattedDateTime);
    }
}
