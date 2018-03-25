package pl.narodzinyprogramsity.service;

import pl.narodzinyprogramsity.models.Trip;
import pl.narodzinyprogramsity.readers.FeedReader;
import pl.narodzinyprogramsity.repository.FeedRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TripService implements TripAPI {
    private FeedReader<Trip> reader;
    private FeedRepository<Trip> repository;


    public TripService(FeedRepository<Trip> repository, FeedReader<Trip> reader) {
        this.repository = repository;
        this.reader = reader;
    }

    @Override
    public void loadTrip() throws IOException {
        reader.read();
    }

    @Override
    public List<Trip> findTripByRouteId(String routeId) {
        List<Trip> routeList = new ArrayList<>();
        for (Trip trip : repository.getAll()){
            if (trip.getRouteId().equals(routeId)) {
                routeList.add(trip);
            }
        }
        return routeList;
    }

    @Override
    public List<Trip> getAllTrips() {
        return repository.getAll();
    }
}
