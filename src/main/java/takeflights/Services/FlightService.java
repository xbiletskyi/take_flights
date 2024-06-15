package takeflights.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import takeflights.Models.FlightData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final String API_URL = "https://api.travelpayouts.com/aviasales/v3/prices_for_dates";
    private final String REQUEST_PARAMETERS =
            "&unique=false&sorting=price&direct=false&currency=eur&limit=1000&page=1&one_way=true";
    @Value("${travelpayouts.token}")
    private String token;
    @Autowired
    public FlightService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public List<FlightData> findCheapestFlights(String origin, String departureAt) {
        String url = API_URL + "?origin=" + origin + "&departure_at=" + departureAt + "&token=" + token +
                REQUEST_PARAMETERS;
        String response = restTemplate.getForObject(url, String.class);
        List<FlightData> flights = new ArrayList<>();
        try{
            JsonNode rootNode = objectMapper.readTree(response);
            JsonNode dataNode = rootNode.get("data");
            flights = objectMapper.readValue(dataNode.toString(), new TypeReference<List<FlightData>>() {});
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return flights;
    }
}
