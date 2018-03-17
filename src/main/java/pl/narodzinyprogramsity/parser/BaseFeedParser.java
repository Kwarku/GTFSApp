package pl.narodzinyprogramsity.parser;

import pl.narodzinyprogramsity.models.FeedModel;
import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;

public abstract class BaseFeedParser <T extends FeedModel> implements FeedParser<T> {
    private int numberOfElements;
    protected String[] splitFeedInfo;

    public BaseFeedParser(int numberOfElements){
        super();
        this.numberOfElements = numberOfElements;
    }

    public T parseTo(String line) throws NotCorrectLineException {
        line = line.replaceAll("\"", "");
        splitFeedInfo = line.split(FeedParser.DATA_DELIMITTER, -1);
        if (numberOfElements != splitFeedInfo.length) {
            throw new NotCorrectLineException();
        }
        return null;
    }
}
