package pl.narodzinyprogramsity.readers;

import pl.narodzinyprogramsity.models.FeedModel;

import java.io.IOException;

public interface FeedReader <T extends FeedModel> {

    void read() throws IOException;
    String getFileDir();

}
