package pl.narodzinyprogramsity.parsers;

import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.models.Route;
import pl.narodzinyprogramsity.modelType.RoutType;

public class RouteParser extends BaseFeedParser<Route> {

    private static final int ROUTE_ID = 0;
    private static final int ROUTE_SHORT_NAME = 1;
    private static final int ROUTE_LONG_NAME = 2;
    private static final int ROUTE_DESC = 3;
    private static final int ROUTE_TYPE = 4;
    private static final int ROUTE_URL = 5;
    private static final int ROUTE_COLOR = 6;
    private static final int ROUTE_TEXT_COLOR = 7;
    private static final int ROUTE_ELEMENTS = 8;

    public RouteParser() {
        super(ROUTE_ELEMENTS);
    }


    @Override
    public Route parseTo(String line) throws NotCorrectLineException {
        super.parseTo(line);
        Route route = new Route();
        route.setId(splitFeedInfo[ROUTE_ID]);
        route.setRouteShortName(splitFeedInfo[ROUTE_SHORT_NAME]);
        route.setRouteLongName(splitFeedInfo[ROUTE_LONG_NAME]);
        route.setRouteDesc(splitFeedInfo[ROUTE_DESC]);
        validateFeedInfo(route);
        route.setRouteUrl(splitFeedInfo[ROUTE_URL]);
        route.setRouteColor(splitFeedInfo[ROUTE_COLOR]);
        route.setRouteTextColor(splitFeedInfo[ROUTE_TEXT_COLOR]);
        return route;
    }

    private void validateFeedInfo(Route route) {
        if (splitFeedInfo[ROUTE_TYPE].equals("")) {
            route.setRouteType(RoutType.UNKNOWN);
        } else {
            route.setRouteType(RoutType.getRouteType(Integer.parseInt(splitFeedInfo[ROUTE_TYPE])));
        }
    }
}
