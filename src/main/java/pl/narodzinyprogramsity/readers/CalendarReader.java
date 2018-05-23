package pl.narodzinyprogramsity.readers;

import pl.narodzinyprogramsity.models.Calendar;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.repository.FeedRepository;

public class CalendarReader extends BaseFeedReader<Calendar> {
    public CalendarReader(FeedRepository<Calendar> repository, FeedParser<Calendar> parser) {
        super(repository, parser);
    }

    @Override
    public String getFileDir() {
        return "./resources/calendar_dates.txt";
    }
}
