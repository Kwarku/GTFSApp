package pl.narodzinyprogramsity.controller;

import pl.narodzinyprogramsity.models.Trip;
import pl.narodzinyprogramsity.service.TripAPI;
import pl.narodzinyprogramsity.view.TripView;

import java.io.IOException;
import java.util.List;

public class TripController {
    private final TripAPI tripAPI;
    private final TripView tripView;

    public TripController(TripAPI tripAPI, TripView tripView) {
        this.tripAPI = tripAPI;
        this.tripView = tripView;
    }

    public void load() throws IOException {
        tripAPI.loadTrip();
    }

    public List<Trip> findTripByRouteId(String routId) {
        return tripAPI.findTripByRouteId(routId);
    }

    public List<Trip> getAllTrips() {
        return tripAPI.getAllTrips();
    }


}
