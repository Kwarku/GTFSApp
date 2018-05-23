package pl.narodzinyprogramsity.readers;

import pl.narodzinyprogramsity.models.Shape;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.repository.FeedRepository;

public class ShapeReader extends BaseFeedReader<Shape> {
    public ShapeReader(FeedRepository<Shape> repository, FeedParser<Shape> parser) {
        super(repository, parser);
    }

    @Override
    public String getFileDir() {
        return "./resources/shapes.txt";
    }
}
