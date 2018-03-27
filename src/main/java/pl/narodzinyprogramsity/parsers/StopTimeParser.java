package pl.narodzinyprogramsity.parsers;

import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.modelType.DropOffType;
import pl.narodzinyprogramsity.modelType.PickupType;
import pl.narodzinyprogramsity.models.StopTime;
import pl.narodzinyprogramsity.utils.ParseStringToLocalTime;

import java.time.LocalTime;

public class StopTimeParser extends BaseFeedParser<StopTime> {

    private static final int TRIP_ID_COLUMN = 0;
    private static final int ARRIVAL_TIME_COLUMN = 1;
    private static final int DEPARTURE_TIME_COLUMN = 2;
    private static final int STOP_ID_COLUMN = 3;
    private static final int STOP_SEQUENCE_COLUMN = 4;
    private static final int STOP_HEADSIGN_COLUMN = 5;
    private static final int PICK_UP_TYPE_COLUMN = 6;
    private static final int DROP_OFF_TYPE_COLUMN = 7;

    private static final int NUMBER_OF_ELEMENTS = 8;

    public StopTimeParser() {
        super(NUMBER_OF_ELEMENTS);
    }

    //A-7549-POW-1-1-0,04:41:00,04:41:00,84613,1,,0,0
    @Override
    public StopTime parseTo(String line) throws NotCorrectLineException {
        super.parseTo(line);
        StopTime stopTime = new StopTime();

        stopTime.setTripId(splitFeedInfo[TRIP_ID_COLUMN]);
        stopTime.setArrivalTime(getParseTime(ARRIVAL_TIME_COLUMN));
        stopTime.setDepartureTime(getParseTime(DEPARTURE_TIME_COLUMN));
        stopTime.setStopId(splitFeedInfo[STOP_ID_COLUMN]);
        stopTime.setStopSequence(splitFeedInfo[STOP_SEQUENCE_COLUMN]);
        stopTime.setStopHeadsign(splitFeedInfo[STOP_HEADSIGN_COLUMN]);
        stopTime.setPickupType(getPickupType());
        stopTime.setDropOffType(getDropOffType());

        return stopTime;
    }

    private LocalTime getParseTime(int column) throws NotCorrectLineException {
        return ParseStringToLocalTime.parse(splitFeedInfo[column]);
    }

    private PickupType getPickupType() {
        return PickupType.getPickupType(Integer.parseInt(splitFeedInfo[PICK_UP_TYPE_COLUMN]));
    }

    private DropOffType getDropOffType() {
        return DropOffType.getDropOffType(Integer.parseInt(splitFeedInfo[DROP_OFF_TYPE_COLUMN]));
    }
}
