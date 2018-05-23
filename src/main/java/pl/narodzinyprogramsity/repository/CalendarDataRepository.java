package pl.narodzinyprogramsity.repository;

import pl.narodzinyprogramsity.models.CalendarData;

public class CalendarDataRepository extends BaseFeedRepository<CalendarData> {

    @Override
    public CalendarData get(String id) {
        CalendarData calendarData = super.get(id);
        if (calendarData != null) {
            return calendarData;
        }
        return CalendarData.NOT_FOUND;
    }

}
