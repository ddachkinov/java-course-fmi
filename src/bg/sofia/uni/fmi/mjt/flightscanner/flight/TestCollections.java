package bg.sofia.uni.fmi.mjt.flightscanner.flight;

import bg.sofia.uni.fmi.mjt.flightscanner.FlightScanner;
import bg.sofia.uni.fmi.mjt.flightscanner.SolutionFlightScanner;
import bg.sofia.uni.fmi.mjt.flightscanner.airport.Airport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestCollections {

    private static Flight directToBali;

    public static void main(String[] args) {

        Airport sofiAirport = new Airport("SOF", "Sunny");
        Airport warsawAirport = new Airport("WAW", "Sunny");

//        Flight toLon = RegularFlight.of("LON12", new Airport("LON"), new Airport("LON"), 200);
        Flight directToBali = RegularFlight.of("LOVE12", sofiAirport, new Airport("DEN", "Sunny"), 200);
        Flight sofiaToLisbon = RegularFlight.of("WINE68", sofiAirport, new Airport("LIS", "Sunny"), 200);
        Flight sofiaToBelgrade = RegularFlight.of("SCA23", sofiAirport, new Airport("BEL", "Rainy"), 200);
        Flight belgradeToWarsaw = RegularFlight.of("SCA233", new Airport("BEL", "Sunny"), warsawAirport, 200);

//        Set<Flight> todayFlights = Set.of(directToBali, sofiaToLisbon, sofiaToBelgrade, belgradeToLisbon);

        SolutionFlightScanner scanner = new SolutionFlightScanner();

        scanner.add(directToBali);
        scanner.add(sofiaToLisbon);
        scanner.add(sofiaToBelgrade);
        scanner.add(belgradeToWarsaw);

//        for (Map.Entry<Airport, Set<Flight>> airportWithFlights : scanner.flights.entrySet()) {
//            System.out.println(airportWithFlights.getKey() + " " + airportWithFlights.getValue());
//        }

        List<Flight> readyFlightPlan = scanner.searchFlights(sofiAirport, sofiaToLisbon.getTo());

        System.out.println(readyFlightPlan);

    }
}
