package pl.narodzinyprogramsity.utils;

import pl.narodzinyprogramsity.modelType.DropOffType;
import pl.narodzinyprogramsity.modelType.PickupType;
import pl.narodzinyprogramsity.models.StopTime;

import java.time.LocalTime;

public class CreateStopTime {
    public static StopTime createTestStopTime() {
        return new StopTime("A-7549-POW-1-1-0",
                LocalTime.of(4, 41, 0),
                LocalTime.of(4, 41, 0),
                "84613",
                "1",
                "",
                PickupType.REGULARLY,
                DropOffType.REGULARLY);
    }
}
