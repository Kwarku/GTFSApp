package pl.narodzinyprogramsity.parsers;

import pl.narodzinyprogramsity.models.FeedModel;
import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;

import java.util.zip.DataFormatException;

public abstract class BaseFeedParser <T extends FeedModel> implements FeedParser<T> {
    private int numberOfElements;
    protected String[] splitFeedInfo;

    public BaseFeedParser(int numberOfElements){
        super();
        this.numberOfElements = numberOfElements;
    }

    public T parseTo(String line) throws NotCorrectLineException {
        line = line.replaceAll("\"", "");
        splitFeedInfo = line.split(DATA_DELIMITTER, -1);
        if (numberOfElements != splitFeedInfo.length) {
            throw new NotCorrectLineException();
        }
        return null;
    }
}
