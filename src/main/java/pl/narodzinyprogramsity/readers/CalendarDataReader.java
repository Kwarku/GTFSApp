package pl.narodzinyprogramsity.readers;

import pl.narodzinyprogramsity.models.CalendarData;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.repository.FeedRepository;

public class CalendarDataReader extends BaseFeedReader<CalendarData> {

    public CalendarDataReader(FeedRepository<CalendarData> repository, FeedParser<CalendarData> parser) {
        super(repository, parser);
    }

    @Override
    public String getFileDir() {
        return "./resources/calendar_dates.txt";
    }
}
