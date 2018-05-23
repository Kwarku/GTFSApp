package pl.narodzinyprogramsity.readers;

import pl.narodzinyprogramsity.models.StopTime;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.repository.FeedRepository;

public class StopTimeReader extends BaseFeedReader<StopTime> {

    public StopTimeReader(FeedRepository<StopTime> repository, FeedParser<StopTime> parser) {
        super(repository, parser);
    }

    @Override
    public String getFileDir() {
        return "./resources/stop_times.txt";
    }
}
