package pl.narodzinyprogramsity.readers;

import pl.narodzinyprogramsity.models.Trip;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.repository.FeedRepository;

public class TripReader extends BaseFeedReader<Trip> {

    public TripReader(FeedRepository<Trip> repository, FeedParser<Trip> parser) {
        super(repository, parser);
    }

    @Override
    public String getFileDir() {
        return "./resources/trips.txt";
    }
}
