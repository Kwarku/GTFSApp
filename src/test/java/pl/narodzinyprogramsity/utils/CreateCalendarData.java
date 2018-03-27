package pl.narodzinyprogramsity.utils;

import pl.narodzinyprogramsity.models.CalendarData;

import java.time.LocalDate;
import java.time.Month;

public class CreateCalendarData {
    public static CalendarData getTestCalendarData(){
        return new CalendarData("NIEH", LocalDate.of(2018, Month.of(03),25), true);
    }
}
