package pl.narodzinyprogramsity.module;

import pl.narodzinyprogramsity.models.Agency;
import pl.narodzinyprogramsity.models.Rout;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.readers.AgencyReader;
import pl.narodzinyprogramsity.readers.FeedReader;
import pl.narodzinyprogramsity.readers.RouteReader;
import pl.narodzinyprogramsity.repository.FeedRepository;

public class ReaderModule {
    private static AgencyReader agencyReader;
    private static RouteReader routeReader;

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
            routeReader = new RouteReader(RepositoryModule.getRoutRespository(), ParserModule.getRoutParser());
        }
        return routeReader;
    }

}
