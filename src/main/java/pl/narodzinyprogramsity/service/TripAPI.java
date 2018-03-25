package pl.narodzinyprogramsity.service;

import pl.narodzinyprogramsity.models.Trip;

import java.io.IOException;
import java.util.List;

public interface TripAPI {
    void loadTrip() throws IOException;

    List<Trip> findTripByRouteId(String routeId);

    List<Trip> getAllTrips();

}
