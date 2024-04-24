package obile.takeflights.com.takeflights.SideFunctions;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Loads environment variables from a .env file and sets them as system properties
 * so that they can be used directly in Spring Boot configurations.
 */
public class EnvPropertyLoader {

    public static void loadProperties() {
        Dotenv dotenv = Dotenv.load();
        // Map .env variables to Spring Boot's property names and set them as system properties
        System.setProperty("spring.datasource.url", String.format("jdbc:postgresql://%s:%s/%s", 
            dotenv.get("DB_HOST"), dotenv.get("DB_PORT"), dotenv.get("DB_NAME")));
        System.setProperty("spring.datasource.username", dotenv.get("DB_USER"));
        System.setProperty("spring.datasource.password", dotenv.get("DB_PASSWORD"));
        System.setProperty("spring.datasource.driver-class-name", "org.postgresql.Driver");
        System.setProperty("spring.security.user.name", dotenv.get("SPRING_SECURITY_USER_NAME"));
        System.setProperty("spring.security.user.password", dotenv.get("SPRING_SECURITY_USER_PASSWORD"));
    }

    public static void main(String[] args) {
        loadProperties();
        // This main method is only for testing purposes
        System.out.println("Database URL: " + System.getProperty("spring.datasource.url"));
        System.out.println("Database User: " + System.getProperty("spring.datasource.username"));
        System.out.println("Security User: " + System.getProperty("spring.security.user.name"));
    }
}
