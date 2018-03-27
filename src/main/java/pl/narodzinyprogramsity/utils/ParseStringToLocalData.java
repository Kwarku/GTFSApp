package pl.narodzinyprogramsity.utils;

import org.jetbrains.annotations.NotNull;
import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.models.CalendarData;

import java.time.LocalDate;
import java.time.Month;

public class ParseStringToLocalData {
    private static final int YEAR_START = 0;
    private static final int YEAR_END = 4;
    private static final int MONTH_END = 6;

    private static final int CORRECT_DATA_STRING_LENGTH = 8;


    @NotNull
    public static LocalDate parse(String stringData) throws NotCorrectLineException {
        if (stringData.length() != CORRECT_DATA_STRING_LENGTH) {
            throw new NotCorrectLineException();
        }
        int year = getYearFromString(stringData);
        Month month = getMonthFromString(stringData);
        int day = getDayFromString(stringData);

        return LocalDate.of(year, month, day);
    }

    private static int getDayFromString(String stringData) {
        String dayString = stringData.substring(MONTH_END);
        return Integer.parseInt(dayString);
    }

    private static Month getMonthFromString(String stringData) {
        String monthString = stringData.substring(YEAR_END, MONTH_END);
        int intMonth = Integer.parseInt(monthString);
        return Month.of(intMonth);
    }

    private static int getYearFromString(String stringData) {
        String yearString = (stringData.substring(YEAR_START, YEAR_END));
        return Integer.parseInt(yearString);
    }
}
