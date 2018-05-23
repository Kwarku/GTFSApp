package pl.narodzinyprogramsity.readers;

import pl.narodzinyprogramsity.models.Route;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.repository.FeedRepository;

public class RouteReader extends BaseFeedReader<Route> {

    public RouteReader(FeedRepository<Route> repository, FeedParser<Route> parser) {
        super(repository, parser);
    }

    @Override
    public String getFileDir() {
        return "./resources/routes.txt";
    }
}
