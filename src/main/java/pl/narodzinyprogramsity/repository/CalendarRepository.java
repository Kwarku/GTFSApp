package pl.narodzinyprogramsity.repository;

import pl.narodzinyprogramsity.models.Calendar;

public class CalendarRepository extends BaseFeedRepository<Calendar> {

    @Override
    public Calendar get(String id) {
        Calendar calendar = super.get(id);
        if (calendar != null) {
            return calendar;
        }
        return Calendar.NOT_FOUND;
    }
}
