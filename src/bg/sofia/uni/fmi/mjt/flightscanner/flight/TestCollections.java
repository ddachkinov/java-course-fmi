package bg.sofia.uni.fmi.mjt.flightscanner.flight;

import bg.sofia.uni.fmi.mjt.flightscanner.FlightScanner;
import bg.sofia.uni.fmi.mjt.flightscanner.SolutionFlightScanner;
import bg.sofia.uni.fmi.mjt.flightscanner.airport.Airport;
import bg.sofia.uni.fmi.mjt.flightscanner.exception.FlightCapacityExceededException;
import bg.sofia.uni.fmi.mjt.flightscanner.passenger.Gender;
import bg.sofia.uni.fmi.mjt.flightscanner.passenger.Passenger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestCollections {

//    private static Flight directToBali;
    public static void main(String[] args) {

        Airport sofiAirport = new Airport("SOF", "Sunny");
        Airport warsawAirport = new Airport("WAW", "Sunny");

//Create new passengers
        Passenger dimitar = new Passenger("1231231231", "Dimitar", Gender.MALE);
        Passenger veronika = new Passenger("1212123232", "Veronika",Gender.FEMALE);

//Create new flight destinations
        Flight directToBali = RegularFlight.of("LOVE12", sofiAirport, new Airport("DEN", "Sunny"), 200);
        Flight sofiaToLisbon = RegularFlight.of("WINE68", sofiAirport, new Airport("LIS", "Sunny"), 200);
        Flight sofiaToBelgrade = RegularFlight.of("SCA23", sofiAirport, new Airport("BEL", "Rainy"), 200);
        Flight belgradeToWarsaw = RegularFlight.of("SCA233", new Airport("BEL", "Sunny"), warsawAirport, 200);

//Instantiate new scanner
        SolutionFlightScanner scanner = new SolutionFlightScanner();

//Add flights to the scanner
        scanner.add(directToBali);
        scanner.add(sofiaToLisbon);
        scanner.add(sofiaToBelgrade);
        scanner.add(belgradeToWarsaw);

//List flights using enhanced for loop
//        for (Map.Entry<Airport, Set<Flight>> airportWithFlights : scanner.flights.entrySet()) {
//            System.out.println(airportWithFlights.getKey() + " " + airportWithFlights.getValue());
//        }

//Search for flights by the given criteria
        List<Flight> readyFlightPlan = scanner.searchFlights(sofiAirport, sofiaToLisbon.getTo());


//Assign the value of the first element in the readyFlightPlan list to foundFlight
        Flight foundFlight = readyFlightPlan.get(0);

//Add passengers to this flight
        try {
            foundFlight.addPassengers(List.of(veronika,dimitar));
        } catch (FlightCapacityExceededException e) {
            throw new RuntimeException(e);
        }

//Print foundFlight
        System.out.println(foundFlight);

    }
}
