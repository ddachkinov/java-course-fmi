package bg.sofia.uni.fmi.mjt.flightscanner.flight;

import bg.sofia.uni.fmi.mjt.flightscanner.airport.Airport;
import bg.sofia.uni.fmi.mjt.flightscanner.exception.FlightCapacityExceededException;
import bg.sofia.uni.fmi.mjt.flightscanner.exception.InvalidFlightException;
import bg.sofia.uni.fmi.mjt.flightscanner.passenger.Passenger;

import java.net.PasswordAuthentication;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RegularFlight implements Flight {

    private Airport from;
    private Airport to;
    private String flightId;
    private Integer totalCapacity;
    private Set<Passenger> passengerSet;

    private RegularFlight(String flightId, Airport from, Airport to, int totalCapacity) {
        this.to = to;
        this.from = from;
        this.flightId = flightId;
        this.totalCapacity = totalCapacity;
        passengerSet = new HashSet<>(totalCapacity);
    }

    public static RegularFlight of(String flightId, Airport from, Airport to, int totalCapacity) {
        if (flightId == null || flightId.isBlank() || flightId.isEmpty() || from == null || to == null ||
            totalCapacity < 0) {
            throw new IllegalArgumentException();
        }

        if (from.equals(to)) {
            throw new InvalidFlightException("From and To are the same place");
        }

        return new RegularFlight(flightId, from, to, totalCapacity);
    }

    @Override
    public Airport getFrom() {
        return from;
    }

    @Override
    public Airport getTo() {
        return to;
    }

    @Override
    public void addPassenger(Passenger passenger) throws FlightCapacityExceededException {
        if (passengerSet.size() == totalCapacity) {
            throw new FlightCapacityExceededException("Flight capacity exceeded");
        }
        passengerSet.add(passenger);

    }

    @Override
    public void addPassengers(Collection<Passenger> passengers) throws FlightCapacityExceededException {
        if (passengerSet.size() + passengers.size() > totalCapacity) {
            throw new FlightCapacityExceededException("Flight capacity exceeded");
        }
        passengerSet.addAll(passengers);
    }

    @Override
    public Collection<Passenger> getAllPassengers() {
        return Collections.unmodifiableCollection(passengerSet);
    }

    @Override
    public int getFreeSeatsCount() {
        return totalCapacity - passengerSet.size();
    }

    @Override
    public String toString() {
        return "RegularFlight{" +
            "from=" + from +
            ", to=" + to +
            ", flightId='" + flightId + '\'' +
            ", totalCapacity=" + totalCapacity +
            ", passengerSet=" + passengerSet +
            '}';
    }
}
