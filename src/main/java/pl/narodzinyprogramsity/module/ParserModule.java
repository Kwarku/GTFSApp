package pl.narodzinyprogramsity.module;

import pl.narodzinyprogramsity.models.Agency;
import pl.narodzinyprogramsity.models.Route;
import pl.narodzinyprogramsity.models.Trip;
import pl.narodzinyprogramsity.models.Stop;
import pl.narodzinyprogramsity.parsers.*;

public class ParserModule {
    private static AgencyParser agencyParser;
    private static RouteParser routeParser;
    private static TripParser tripParser;
    private static StopParser stopParser;

    public static FeedParser<Agency> getAgencyParser() {
        if (agencyParser == null) {
            agencyParser = new AgencyParser();
        }
        return agencyParser;
    }

    public static FeedParser<Route> getRouteParser() {
        if (routeParser == null) {
            routeParser = new RouteParser();
        }
        return routeParser;
    }

    public static FeedParser<Trip> getTripParser() {
        if (tripParser == null) {
            tripParser = new TripParser();
        }
        return tripParser;
    }

    public static FeedParser<Stop> getStopParser(){
        if (stopParser == null) {
            stopParser = new StopParser();
        }
        return stopParser;
    }

}
