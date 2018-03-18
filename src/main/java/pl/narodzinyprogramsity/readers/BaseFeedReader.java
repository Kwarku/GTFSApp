package pl.narodzinyprogramsity.readers;

import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.models.FeedModel;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.repository.FeedRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class BaseFeedReader<T extends FeedModel> implements FeedReader<T> {
    private final FeedRepository<T> repository;
    private final FeedParser<T> parser;

    public BaseFeedReader(FeedRepository<T> repository, FeedParser<T> parser) {
        this.parser = parser;
        this.repository = repository;
    }

    @Override
    public void read() throws IOException {
            Files.lines(Paths.get(getFileDir())).skip(1).forEach(line -> {
                try {
                    repository.add(parser.parseTo(line));
                } catch (NotCorrectLineException e) {
                    e.printStackTrace();
                }
            });
  }
}
