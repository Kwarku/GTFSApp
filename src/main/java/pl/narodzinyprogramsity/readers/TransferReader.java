package pl.narodzinyprogramsity.readers;

import pl.narodzinyprogramsity.models.Transfer;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.repository.FeedRepository;

public class TransferReader extends BaseFeedReader<Transfer> {

    public TransferReader(FeedRepository<Transfer> repository, FeedParser<Transfer> parser) {
        super(repository, parser);
    }

    @Override
    public String getFileDir() {
        return "./resources/transfers.txt";
    }
}
