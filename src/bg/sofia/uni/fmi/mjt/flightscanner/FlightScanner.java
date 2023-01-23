package bg.sofia.uni.fmi.mjt.flightscanner;

import bg.sofia.uni.fmi.mjt.flightscanner.airport.Airport;
import bg.sofia.uni.fmi.mjt.flightscanner.exception.InvalidFlightException;
import bg.sofia.uni.fmi.mjt.flightscanner.flight.Flight;


import java.util.*;

public class FlightScanner implements FlightScannerAPI{

//    private final Map<Airport, Set<Flight>> flights;
    public final Map<Airport, Set<Flight>> flights;

    public FlightScanner(){
        this.flights = new HashMap<>();
    }

        @Override
    public void add(Flight flight) {
        if(flight == null){
            throw new IllegalArgumentException("Flight cannot be null");
        }

        Airport from = flight.getFrom();
        flights.putIfAbsent(from, new HashSet<>());
        var flightsFrom = flights.get(from);
        flightsFrom.add(flight);
    }

    @Override
    public void addAll(Collection<Flight> flights) {

    }

    @Override
    public List<Flight> searchFlights(Airport from, Airport to) {
        if (!flights.containsKey(from)) {
            return new ArrayList<>();
        }
        return ;
    }

    @Override
    public List<Flight> getFlightsSortedByFreeSeats(Airport from) {
        return null;
    }

    @Override
    public List<Flight> getFlightsSortedByDestination(Airport from) {
        return null;
    }
}
