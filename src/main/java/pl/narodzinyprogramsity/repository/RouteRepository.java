package pl.narodzinyprogramsity.repository;

import pl.narodzinyprogramsity.models.Route;

public class RouteRepository extends BaseFeedRepository<Route> {

    @Override
    public Route get(String id) {
        Route route = super.get(id);
        if (route != null) {
            return route;
        }
        return Route.NOT_FOUND;
    }
}
