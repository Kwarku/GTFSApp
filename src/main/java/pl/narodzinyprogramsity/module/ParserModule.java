package pl.narodzinyprogramsity.module;

import pl.narodzinyprogramsity.models.Agency;
import pl.narodzinyprogramsity.models.Rout;
import pl.narodzinyprogramsity.parsers.AgencyParser;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.parsers.RoutParser;

public class ParserModule {
    private static AgencyParser agencyParser;
    private static RoutParser routParser;

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

}
