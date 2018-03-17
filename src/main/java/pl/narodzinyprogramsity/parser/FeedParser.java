package pl.narodzinyprogramsity.parser;

import pl.narodzinyprogramsity.models.FeedModel;
import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;

public interface FeedParser <T extends FeedModel> {
    public static final String DATA_DELIMITTER = ",";

    T parseTo(String line) throws NotCorrectLineException;
}
