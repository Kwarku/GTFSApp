package pl.narodzinyprogramsity.module;

import pl.narodzinyprogramsity.models.Agency;
import pl.narodzinyprogramsity.models.Rout;
import pl.narodzinyprogramsity.models.Trip;
import pl.narodzinyprogramsity.models.Stop;
import pl.narodzinyprogramsity.repository.*;

public class RepositoryModule {
    private static RoutRepository routRepository;
    private static AgencyRepository agencyRepository;
    private static TripRepository tripRepository;
    private static StopRepository stopRepository;


    public static FeedRepository<Agency> getAgencyRepository() {
        if (agencyRepository == null) {
            agencyRepository = new AgencyRepository();
        }
        return agencyRepository;
    }

    public static FeedRepository<Rout> getRoutRepository() {
        if (routRepository == null) {
            routRepository = new RoutRepository();
        }
        return routRepository;
    }

    public static FeedRepository<Trip> getTripResources() {
        if (tripRepository == null) {
            tripRepository = new TripRepository();
        }
        return tripRepository;
    }

    public static FeedRepository<Stop> getStopRepository(){
        if (stopRepository == null) {
            stopRepository = new StopRepository();
        }
        return stopRepository;
    }
}
