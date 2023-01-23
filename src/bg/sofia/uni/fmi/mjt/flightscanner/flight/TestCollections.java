package bg.sofia.uni.fmi.mjt.flightscanner.flight;

import bg.sofia.uni.fmi.mjt.flightscanner.FlightScanner;
import bg.sofia.uni.fmi.mjt.flightscanner.SolutionFlightScanner;
import bg.sofia.uni.fmi.mjt.flightscanner.airport.Airport;

import java.util.HashMap;

public class TestCollections {

    public static void main(String[] args) {
        Flight toLondon = RegularFlight.of("ID1", new Airport("Sofia"),
            new Airport("London"), 100);

        SolutionFlightScanner scanner = new SolutionFlightScanner();

//        scanner.add(toLondon);
//        scanner.add(toLondon);
//        scanner.add(toLondon);
//        scanner.add(toLondon);
//        scanner.add(toLondon);

        scanner.flights.keySet().forEach(key ->System.out.println( key + ": " + scanner.flights.get(key)));


    }
}
