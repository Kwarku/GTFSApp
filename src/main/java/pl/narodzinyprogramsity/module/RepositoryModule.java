package pl.narodzinyprogramsity.module;

import pl.narodzinyprogramsity.models.*;
import pl.narodzinyprogramsity.repository.*;

public class RepositoryModule {
    private static AgencyRepository agencyRepository;
    private static CalendarRepository calendarRepository;
    private static CalendarDataRepository calendarDataRepository;
    private static RouteRepository routeRepository;
    private static ShapeRepository shapeRepository;
    private static StopTimeRepository stopTimeRepository;
    private static StopRepository stopRepository;
    private static TransferRepository transferRepository;
    private static TripRepository tripRepository;


    public static FeedRepository<Agency> getAgencyRepository() {
        if (agencyRepository == null) {
            agencyRepository = new AgencyRepository();
        }
        return agencyRepository;
    }

    public static FeedRepository<Calendar> getCalendarRepositry() {
        if (calendarRepository == null) {
            calendarRepository = new CalendarRepository();
        }
        return calendarRepository;
    }

    public static FeedRepository<CalendarData> getCalendarDataRepository() {
        if (calendarDataRepository == null) {
            calendarDataRepository = new CalendarDataRepository();
        }
        return calendarDataRepository;
    }

    public static FeedRepository<Route> getRouteRepository() {
        if (routeRepository == null) {
            routeRepository = new RouteRepository();
        }
        return routeRepository;
    }

    public static FeedRepository<Shape> getShapeRepository() {
        if (shapeRepository == null) {
            shapeRepository = new ShapeRepository();
        }
        return shapeRepository;
    }

    public static FeedRepository<StopTime> getStopTimeRepository() {
        if (stopTimeRepository == null) {
            stopTimeRepository = new StopTimeRepository();
        }
        return stopTimeRepository;
    }

    public static FeedRepository<Stop> getStopRepository() {
        if (stopRepository == null) {
            stopRepository = new StopRepository();
        }
        return stopRepository;
    }

    public static FeedRepository<Transfer> getTransferRepository() {
        if (transferRepository == null) {
            transferRepository = new TransferRepository();
        }
        return transferRepository;
    }

    public static FeedRepository<Trip> getTripResources() {
        if (tripRepository == null) {
            tripRepository = new TripRepository();
        }
        return tripRepository;
    }
}
