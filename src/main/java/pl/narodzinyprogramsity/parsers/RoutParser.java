package pl.narodzinyprogramsity.parsers;

import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.models.Rout;
import pl.narodzinyprogramsity.models.RoutType;

public class RoutParser extends BaseFeedParser<Rout> {

    private static final int ROUTE_ID = 0;
    private static final int ROUTE_SHORT_NAME = 1;
    private static final int ROUTE_LONG_NAME = 2;
    private static final int ROUTE_DESC = 3;
    private static final int ROUTE_TYPE = 4;
    private static final int ROUTE_URL = 5;
    private static final int ROUTE_COLOR = 6;
    private static final int ROUTE_TEXT_COLOR = 7;
    private static final int ROUTE_ELEMENTS = 8;

    public RoutParser() {
        super(ROUTE_ELEMENTS);
    }


    @Override
    public Rout parseTo(String line) throws NotCorrectLineException {
        super.parseTo(line);
        Rout rout = new Rout();
        rout.setId(splitFeedInfo[ROUTE_ID]);
        rout.setRouteShortName(splitFeedInfo[ROUTE_SHORT_NAME]);
        rout.setRouteLongName(splitFeedInfo[ROUTE_LONG_NAME]);
        rout.setRouteDesc(splitFeedInfo[ROUTE_DESC]);
        validateFeedInfo(rout);
        rout.setRouteUrl(splitFeedInfo[ROUTE_URL]);
        rout.setRouteColor(splitFeedInfo[ROUTE_COLOR]);
        rout.setRouteTextColor(splitFeedInfo[ROUTE_TEXT_COLOR]);
        return rout;
    }

    private void validateFeedInfo(Rout rout) {
        if (splitFeedInfo[ROUTE_TYPE].equals("")) {
            rout.setRouteType(RoutType.UNKNOWN);
        } else {
            rout.setRouteType(RoutType.getType(Integer.parseInt(splitFeedInfo[ROUTE_TYPE])));
        }
    }
}
