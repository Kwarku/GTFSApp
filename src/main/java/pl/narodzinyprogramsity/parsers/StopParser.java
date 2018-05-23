package pl.narodzinyprogramsity.parsers;

import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.modelType.LocationType;
import pl.narodzinyprogramsity.models.Stop;
import pl.narodzinyprogramsity.modelType.WheelchairBoardingType;

public class StopParser extends BaseFeedParser<Stop> {

    private static final int STOP_ID = 0;
    private static final int STOP_CODE = 1;
    private static final int STOP_NAME = 2;
    private static final int STOP_DESC = 3;
    private static final int STOP_LAT = 4;
    private static final int STOP_LON = 5;
    private static final int STOP_URL = 6;
    private static final int LOCATION_TYPE = 7;
    private static final int PARENT_STATION = 8;
    private static final int WHEELCHAIR_BOARDING_TYPE = 9;

    private static final int NUMBER_OF_ELEMENTS = 10;

    public StopParser() {
        super(NUMBER_OF_ELEMENTS);
    }

    @Override
    public Stop parseTo(String line) throws NotCorrectLineException {
        super.parseTo(line);
        Stop stop = new Stop();
        stop.setId(splitFeedInfo[STOP_ID]);
        stop.setStopCode(splitFeedInfo[STOP_CODE]);
        stop.setStopDesc(splitFeedInfo[STOP_DESC]);
        stop.setStopName(splitFeedInfo[STOP_NAME]);
        stop.setStopLat(splitFeedInfo[STOP_LAT]);
        stop.setStopLon(splitFeedInfo[STOP_LON]);
        stop.setStopUrl(splitFeedInfo[STOP_URL]);
        validateLocationType(stop);
        stop.setParentStation(splitFeedInfo[PARENT_STATION]);
        validateWheelchairBoardingType(stop);

        return stop;
    }

    private void validateLocationType(Stop stop) {
        if (splitFeedInfo[LOCATION_TYPE].equals("")){
            stop.setLocationType(LocationType.UNKNOWN);
        }else {
            stop.setLocationType(LocationType.getLocationType(Integer.parseInt(splitFeedInfo[LOCATION_TYPE])));
        }
    }

    private void validateWheelchairBoardingType(Stop stop) {
        if (splitFeedInfo[WHEELCHAIR_BOARDING_TYPE].equals("")){
            stop.setWheelchairBoardingType(WheelchairBoardingType.NO_INFORMATION);
        }else {
            stop.setWheelchairBoardingType(WheelchairBoardingType.getType(Integer.parseInt(splitFeedInfo[WHEELCHAIR_BOARDING_TYPE])));
        }
    }
}
