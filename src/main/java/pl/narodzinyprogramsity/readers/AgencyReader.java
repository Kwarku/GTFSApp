package pl.narodzinyprogramsity.readers;

import pl.narodzinyprogramsity.models.Agency;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.repository.FeedRepository;

public class AgencyReader extends BaseFeedReader<Agency> {

    public AgencyReader(FeedRepository<Agency> repository, FeedParser<Agency> parser) {
        super(repository, parser);
    }

    @Override
    public String getFileDir() {
        return "./resources/agency.txt";
    }
}
