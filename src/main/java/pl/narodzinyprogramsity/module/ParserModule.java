package pl.narodzinyprogramsity.module;

import pl.narodzinyprogramsity.models.Agency;
import pl.narodzinyprogramsity.models.Rout;
import pl.narodzinyprogramsity.models.Trip;
import pl.narodzinyprogramsity.models.Stop;
import pl.narodzinyprogramsity.parsers.*;

public class ParserModule {
    private static AgencyParser agencyParser;
    private static RoutParser routParser;
    private static TripParser tripParser;
    private static StopParser stopParser;

    public static FeedParser<Agency> getAgencyParser() {
        if (agencyParser == null) {
            agencyParser = new AgencyParser();
        }
        return agencyParser;
    }

    public static FeedParser<Rout> getRoutParser() {
        if (routParser == null) {
            routParser = new RoutParser();
        }
        return routParser;
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
