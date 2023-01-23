package bg.sofia.uni.fmi.mjt.flightscanner.flight;

import bg.sofia.uni.fmi.mjt.flightscanner.FlightScanner;
import bg.sofia.uni.fmi.mjt.flightscanner.SolutionFlightScanner;
import bg.sofia.uni.fmi.mjt.flightscanner.airport.Airport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestCollections {

    public static void main(String[] args) {

        Airport sofiAirport = new Airport("SOF");
        Airport warsawAirport = new Airport("WAW");

//        Flight toLon = RegularFlight.of("LON12", new Airport("LON"), new Airport("LON"), 200);
        Flight toBali = RegularFlight.of("LOVE12", sofiAirport, new Airport("DEN"), 200);
        Flight toLisbon = RegularFlight.of("WINE68", sofiAirport, new Airport("LIS"), 200);
        Flight SOFBEL = RegularFlight.of("SCA23", sofiAirport, new Airport("BEL"), 200);
        Flight BELWAW = RegularFlight.of("SCA233", new Airport("BEL"), warsawAirport, 200);

//        Set<Flight> myFlights = Set.of(toBali, toLisbon, toBelgrade, SOFBEL, BELWAW);

        SolutionFlightScanner scanner = new SolutionFlightScanner();

        scanner.add(toBali);
        scanner.add(toLisbon);
        scanner.add(SOFBEL);
        scanner.add(BELWAW);


//        scanner.flights.keySet().forEach(key ->System.out.println( key + ": " + scanner.flights.get(key)));
//        for (Map.Entry<Airport, Set<Flight>> airportWithFlights : scanner.flights.entrySet()) {
//            System.out.println(airportWithFlights.getKey() + " " + airportWithFlights.getValue());
//        }

        List<Flight> readyFlightPlan = scanner.searchFlights(sofiAirport, toLisbon.getTo());

        System.out.println(readyFlightPlan);

    }
}
