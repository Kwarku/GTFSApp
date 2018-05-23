package pl.narodzinyprogramsity.readers;

import pl.narodzinyprogramsity.models.Stop;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.repository.FeedRepository;

public class StopReaders extends BaseFeedReader<Stop> {

    public StopReaders(FeedRepository<Stop> repository, FeedParser<Stop> parser) {
        super(repository, parser);
    }

    @Override
    public String getFileDir() {
        return "./resources/stops.txt";
    }
}
