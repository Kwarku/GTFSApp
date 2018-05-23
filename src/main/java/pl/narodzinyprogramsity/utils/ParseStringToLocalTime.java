package pl.narodzinyprogramsity.utils;

import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;

import java.time.LocalTime;

public class ParseStringToLocalTime {
    private static final int HOUR_INDEX = 0;
    private static final int MINUTES_INDEX = 1;
    private static final int SECOND_INDEX = 2;

    public static LocalTime parse(String time) throws NotCorrectLineException {
        if (time.length() != 8) {
            throw new NotCorrectLineException();
        }

        String[] splitTime = time.split(":");

        int hour = Integer.parseInt(splitTime[HOUR_INDEX]);
        int min = Integer.parseInt(splitTime[MINUTES_INDEX]);
        int second = Integer.parseInt(splitTime[SECOND_INDEX]);

        return LocalTime.of(hour, min, second);
    }
}
