package obile.takeflights.com.takeflights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import obile.takeflights.com.takeflights.SideFunctions.EnvPropertyLoader;

@SpringBootApplication
public class TakeFlightsApplication {
    public static void main(String[] args) {
        EnvPropertyLoader.loadProperties();
        SpringApplication.run(TakeFlightsApplication.class, args);
    }
}
