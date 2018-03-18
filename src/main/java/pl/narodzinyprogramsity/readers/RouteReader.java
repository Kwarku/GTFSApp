package pl.narodzinyprogramsity.readers;

import pl.narodzinyprogramsity.models.Rout;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.repository.FeedRepository;

public class RouteReader extends BaseFeedReader<Rout> {

    public RouteReader(FeedRepository<Rout> repository, FeedParser<Rout> parser) {
        super(repository, parser);
    }

    @Override
    public String getFileDir() {
        return "./resources/routes.txt";
    }
}
