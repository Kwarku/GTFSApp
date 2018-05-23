package pl.narodzinyprogramsity.utils;

import pl.narodzinyprogramsity.models.Calendar;

import java.time.LocalDate;
import java.time.Month;

public class CreateCalendar {
    public static Calendar getTestCalendar() {
        return new Calendar("POW", true, true, true,
                true, true, false, false,
                LocalDate.of(2018, Month.of(3), 5),
                LocalDate.of(2018, Month.of(6), 23));
    }

}
