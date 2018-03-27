package pl.narodzinyprogramsity.module;

import pl.narodzinyprogramsity.models.Agency;
import pl.narodzinyprogramsity.models.Route;
import pl.narodzinyprogramsity.models.Trip;
import pl.narodzinyprogramsity.models.Stop;
import pl.narodzinyprogramsity.repository.*;

public class RepositoryModule {
    private static RouteRepository routeRepository;
    private static AgencyRepository agencyRepository;
    private static TripRepository tripRepository;
    private static StopRepository stopRepository;


    public static FeedRepository<Agency> getAgencyRepository() {
        if (agencyRepository == null) {
            agencyRepository = new AgencyRepository();
        }
        return agencyRepository;
    }

    public static FeedRepository<Route> getRouteRepository() {
        if (routeRepository == null) {
            routeRepository = new RouteRepository();
        }
        return routeRepository;
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
