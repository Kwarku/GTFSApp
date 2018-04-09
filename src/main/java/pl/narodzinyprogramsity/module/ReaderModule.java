package pl.narodzinyprogramsity.module;

import pl.narodzinyprogramsity.models.*;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.readers.*;
import pl.narodzinyprogramsity.repository.FeedRepository;

public class ReaderModule {
    private static AgencyReader agencyReader;
    private static CalendarReader calendarReader;
    private static CalendarDataReader calendarDataReader;
    private static RouteReader routeReader;
    private static ShapeReader shapeReader;
    private static StopTimeReader stopTimeReader;
    private static StopReaders stopReader;
    private static TransferReader transferReader;
    private static TripReader tripReader;

    public static FeedReader<Agency> getAgencyReader(FeedRepository<Agency> repository, FeedParser<Agency> parser) {
        if (agencyReader == null) {
            agencyReader = new AgencyReader(repository, parser);
        }
        return agencyReader;
    }

    public static FeedReader<Agency> getAgencyReader() {
        if (agencyReader == null) {
            agencyReader = new AgencyReader(RepositoryModule.getAgencyRepository(), ParserModule.getAgencyParser());
        }
        return agencyReader;
    }

    public static FeedReader<Calendar> getCalendarReader(FeedRepository<Calendar> repository, FeedParser<Calendar> parser) {
        if (calendarReader == null) {
            calendarReader = new CalendarReader(repository, parser);
        }
        return calendarReader;
    }

    public static FeedReader<Calendar> getCalendarReader() {
        if (calendarReader == null) {
            calendarReader = new CalendarReader(RepositoryModule.getCalendarRepositry(), ParserModule.getCalendarParser());
        }
        return calendarReader;
    }

    public static FeedReader<CalendarData> getCalendarDataReader(FeedRepository<CalendarData> repository, FeedParser<CalendarData> parser) {
        if (calendarDataReader == null) {
            calendarDataReader = new CalendarDataReader(repository, parser);
        }
        return calendarDataReader;
    }

    public static FeedReader<CalendarData> getCalendarDataReader() {
        if (calendarDataReader == null) {
            calendarDataReader = new CalendarDataReader(RepositoryModule.getCalendarDataRepository(), ParserModule.getCalendarDataParser());
        }
        return calendarDataReader;
    }

    public static FeedReader<Route> getRoutReader(FeedRepository<Route> repository, FeedParser<Route> parser) {
        if (routeReader == null) {
            routeReader = new RouteReader(repository, parser);
        }
        return routeReader;
    }

    public static FeedReader<Route> getRoutReader() {
        if (routeReader == null) {
            routeReader = new RouteReader(RepositoryModule.getRouteRepository(), ParserModule.getRouteParser());
        }
        return routeReader;
    }

    public static FeedReader<Shape> getShapeReader(FeedRepository<Shape> repository, FeedParser<Shape> parser) {
        if (shapeReader == null) {
            shapeReader = new ShapeReader(repository, parser);
        }
        return shapeReader;
    }

    public static FeedReader<Shape> getShapeReader() {
        if (shapeReader == null) {
            shapeReader = new ShapeReader(RepositoryModule.getShapeRepository(), ParserModule.getShapeParser());
        }
        return shapeReader;
    }

    public static FeedReader<StopTime> getStopTimeReader(FeedRepository<StopTime> repository, FeedParser<StopTime> parser) {
        if (stopTimeReader == null) {
            stopTimeReader = new StopTimeReader(repository, parser);
        }
        return stopTimeReader;
    }

    public static FeedReader<StopTime> getStopTimeReader() {
        if (stopTimeReader == null) {
            stopTimeReader = new StopTimeReader(RepositoryModule.getStopTimeRepository(), ParserModule.getStopTimeParser());
        }
        return stopTimeReader;
    }

    public static FeedReader<Stop> getStopReader(FeedRepository<Stop> repository, FeedParser<Stop> parser) {
        if (stopReader == null) {
            stopReader = new StopReaders(repository, parser);
        }
        return stopReader;
    }

    public static FeedReader<Stop> getStopReader() {
        if (stopReader == null) {
            stopReader = new StopReaders(RepositoryModule.getStopRepository(), ParserModule.getStopParser());
        }
        return stopReader;
    }

    public static FeedReader<Transfer> getTransferReader(FeedRepository<Transfer> repository, FeedParser<Transfer> parser) {
        if (transferReader == null) {
            transferReader = new TransferReader(repository, parser);
        }
        return transferReader;
    }

    public static FeedReader<Transfer> getTransferReader() {
        if (transferReader == null) {
            transferReader = new TransferReader(RepositoryModule.getTransferRepository(), ParserModule.getTransferParser());
        }
        return transferReader;
    }

    public static FeedReader<Trip> getTripReader(FeedRepository<Trip> repository, FeedParser<Trip> parser) {
        if (tripReader == null) {
            tripReader = new TripReader(repository, parser);
        }
        return tripReader;
    }

    public static FeedReader<Trip> getTripReader() {
        if (tripReader == null) {
            tripReader = new TripReader(RepositoryModule.getTripResources(), ParserModule.getTripParser());
        }
        return tripReader;
    }


}
