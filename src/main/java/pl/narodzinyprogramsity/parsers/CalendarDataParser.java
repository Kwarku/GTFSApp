package pl.narodzinyprogramsity.parsers;

import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.models.CalendarData;
import pl.narodzinyprogramsity.utils.ParseStringInToBoolean;
import pl.narodzinyprogramsity.utils.ParseStringToLocalData;

import java.time.LocalDate;

public class CalendarDataParser extends BaseFeedParser<CalendarData> {
    private static final int SERVICE_ID_COLUMN = 0;
    private static final int DATA_COLUMN = 1;
    private static final int DATA_AVAILABLE_COLUMN = 2;

    private static final int NUMBER_OF_ELEMENTS = 3;


    public CalendarDataParser() {
        super(NUMBER_OF_ELEMENTS);
    }

    @Override
    public CalendarData parseTo(String line) throws NotCorrectLineException {
        super.parseTo(line);
        CalendarData calendarData = new CalendarData();

        calendarData.setServiceId(splitFeedInfo[SERVICE_ID_COLUMN]);
        calendarData.setData(ParseStringToLocalData.parse(splitFeedInfo[DATA_COLUMN]));
        calendarData.setDataAvailable(ParseStringInToBoolean.parse(splitFeedInfo[DATA_AVAILABLE_COLUMN]));
        return calendarData;
    }


}
