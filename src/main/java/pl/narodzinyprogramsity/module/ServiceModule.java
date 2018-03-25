package pl.narodzinyprogramsity.module;

import pl.narodzinyprogramsity.models.Trip;
import pl.narodzinyprogramsity.readers.FeedReader;
import pl.narodzinyprogramsity.repository.FeedRepository;
import pl.narodzinyprogramsity.service.TripAPI;
import pl.narodzinyprogramsity.service.TripService;

public class ServiceModule {
    private static TripAPI tripService;

    public static TripAPI getTripService(FeedRepository<Trip> repository, FeedReader<Trip> reader) {
        if (tripService == null) {
            tripService = new TripService(repository, reader);
        }
        return tripService;
    }

    public static TripAPI getTripService() {
        if (tripService == null) {
            tripService = new TripService(RepositoryModule.getTripResources(), ReaderModule.getTripReader());
        }
        return tripService;
    }
}
