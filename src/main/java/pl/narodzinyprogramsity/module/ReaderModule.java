package pl.narodzinyprogramsity.module;

import pl.narodzinyprogramsity.models.Agency;
import pl.narodzinyprogramsity.models.Rout;
import pl.narodzinyprogramsity.models.Trip;
import pl.narodzinyprogramsity.models.Stop;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.readers.*;
import pl.narodzinyprogramsity.repository.FeedRepository;

public class ReaderModule {
    private static AgencyReader agencyReader;
    private static RouteReader routeReader;
    private static TripReader tripReader;
    private static StopReaders stopReader;

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

    public static FeedReader<Rout> getRoutReader(FeedRepository<Rout> repository, FeedParser<Rout> parser) {
        if (routeReader == null) {
            routeReader = new RouteReader(repository, parser);
        }
        return routeReader;
    }

    public static FeedReader<Rout> getRoutReader() {
        if (routeReader == null) {
            routeReader = new RouteReader(RepositoryModule.getRoutRepository(), ParserModule.getRoutParser());
        }
        return routeReader;
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





}
