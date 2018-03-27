package pl.narodzinyprogramsity.parsers;

import pl.narodzinyprogramsity.models.FeedModel;
import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;

import java.util.zip.DataFormatException;

public interface FeedParser <T extends FeedModel> {
    String DATA_DELIMITTER = ",";

    T parseTo(String line) throws NotCorrectLineException;
}
