package pl.narodzinyprogramsity.parsers;

import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.models.Calendar;
import pl.narodzinyprogramsity.utils.ParseStringInToBoolean;
import pl.narodzinyprogramsity.utils.ParseStringToLocalData;

public class CalendarParser extends BaseFeedParser<Calendar> {

    private static final int SERVICE_ID_COLUMN = 0;
    private static final int MONDAY_VALUE_COLUMN = 1;
    private static final int TUESDAY_VALUE_COLUMN = 2;
    private static final int WEDNESDAY_VALUE_COLUMN = 3;
    private static final int THURSDAY_VALUE_COLUMN = 4;
    private static final int FRIDAY_VALUE_COLUMN = 5;
    private static final int SATURDAY_VALUE_COLUMN = 6;
    private static final int SUNDAY_VALUE_COLUMN = 7;
    private static final int START_DATA_COLUMN = 8;
    private static final int END_DATA_COLUMN = 9;

    private static final int NUMBER_OF_ELEMENTS = 10;

    public CalendarParser() {
        super(NUMBER_OF_ELEMENTS);
    }


    @Override
    public Calendar parseTo(String line) throws NotCorrectLineException {
        super.parseTo(line);
        Calendar calendar = new Calendar();

        setServiceId(calendar);
        setWeekAvailable(calendar);
        setStartData(calendar);
        setEndData(calendar);

        return calendar;
    }

    private void setWeekAvailable(Calendar calendar) {
        setMonday(calendar);
        setTuesday(calendar);
        setWednesday(calendar);
        setThursday(calendar);
        setFriday(calendar);
        setSaturday(calendar);
        setSunday(calendar);
    }

    private void setServiceId(Calendar calendar) {
        calendar.setServiceId(splitFeedInfo[SERVICE_ID_COLUMN]);
    }

    private void setEndData(Calendar calendar) throws NotCorrectLineException {
        calendar.setEndDate(ParseStringToLocalData.parse(splitFeedInfo[END_DATA_COLUMN]));
    }

    private void setStartData(Calendar calendar) throws NotCorrectLineException {
        calendar.setStartDate(ParseStringToLocalData.parse(splitFeedInfo[START_DATA_COLUMN]));
    }

    private void setSunday(Calendar calendar) {
        calendar.setSunday(ParseStringInToBoolean.parse(splitFeedInfo[SUNDAY_VALUE_COLUMN]));
    }

    private void setSaturday(Calendar calendar) {
        calendar.setSaturday(ParseStringInToBoolean.parse(splitFeedInfo[SATURDAY_VALUE_COLUMN]));
    }

    private void setFriday(Calendar calendar) {
        calendar.setFriday(ParseStringInToBoolean.parse(splitFeedInfo[FRIDAY_VALUE_COLUMN]));
    }

    private void setThursday(Calendar calendar) {
        calendar.setThursday(ParseStringInToBoolean.parse(splitFeedInfo[THURSDAY_VALUE_COLUMN]));
    }

    private void setWednesday(Calendar calendar) {
        calendar.setWednesday(ParseStringInToBoolean.parse(splitFeedInfo[WEDNESDAY_VALUE_COLUMN]));
    }

    private void setTuesday(Calendar calendar) {
        calendar.setTuesday(ParseStringInToBoolean.parse(splitFeedInfo[TUESDAY_VALUE_COLUMN]));
    }

    private void setMonday(Calendar calendar) {
        calendar.setMonday(ParseStringInToBoolean.parse(splitFeedInfo[MONDAY_VALUE_COLUMN]));
    }

}
