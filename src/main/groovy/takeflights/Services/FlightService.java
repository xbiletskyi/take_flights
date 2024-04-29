package takeflights.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightService {
    private final RestTemplate restTemplate;
    private final String API_URL = "https://api.travelpayouts.com/v2/prices/latest";

    @Autowired
    public FlightService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String findCheapestFlights(String origin, String token) {
        String url = API_URL + "?origin=" + origin + "&limit=10&sorting=price&token=" + token;
        return restTemplate.getForObject(url, String.class);
    }
}
