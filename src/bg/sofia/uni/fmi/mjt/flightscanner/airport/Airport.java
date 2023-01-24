package bg.sofia.uni.fmi.mjt.flightscanner.airport;

public record Airport(String id, String weatherForecast) {

    public Airport {
        if (id == null || id.isEmpty() || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be null, empty or blank");
        }

    }

    @Override
    public String toString() {
        return "Airport{" +
            "id='" + id + '\'' +
            ", The weather will be: " + weatherForecast + '\'' +
            '}';
    }

}
