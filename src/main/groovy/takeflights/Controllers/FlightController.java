//package takeflights.Controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import takeflights.Services.FlightService;
//
//@RestController
//@RequestMapping("/flights")
//public class FlightController {
//    @Autowired
//    private FlightService flightService;
//
//    @GetMapping("/cheapest")
//    public String getCheapestFlights(@RequestParam String origin, @RequestParam String token) {
//        return flightService.findCheapestFlights(origin, token);
//    }
//}
