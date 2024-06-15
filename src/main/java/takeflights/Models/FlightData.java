package takeflights.Models;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightData {
    @JsonProperty("flight_number")
    private String flightNumber;

    @JsonProperty("departure_at")
    private String departureAt;

    @JsonProperty("origin_airport")
    private String originAirport;

    @JsonProperty("destination_airport")
    private String destinationAirport;

    @JsonProperty("price")
    private double price;

    @JsonProperty("duration")
    private int duration;

    @JsonCreator
    public FlightData(
            @JsonProperty("flight_number") String flightNumber,
            @JsonProperty("depart_date") String departDate,
            @JsonProperty("origin_airport") String originAirport,
            @JsonProperty("destination_airport") String destinationAirport,
            @JsonProperty("price") double price,
            @JsonProperty("duration") int duration) {

        this.flightNumber = flightNumber;
        this.departureAt = departDate;
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.price = price;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departureAt='" + departureAt + '\'' +
                ", originAirport='" + originAirport + '\'' +
                ", destinationAirport='" + destinationAirport + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                '}';
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getOrigin() {
        return originAirport;
    }

    public void setOrigin(String origin) {
        this.originAirport = origin;
    }

    public String getDepartureAt() {
        return departureAt;
    }

    public void setDepartureAt(String departureAt) {
        this.departureAt = departureAt;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
