package pl.narodzinyprogramsity.utils;

import pl.narodzinyprogramsity.models.Route;
import pl.narodzinyprogramsity.modelType.RoutType;

public class CreateRoute {

    public static Route getTestRoute() {
        return new Route("1",
                "1",
                "Głębokie - Potulicka",
                "",
                RoutType.getType(0),
                "http://www.zditm.szczecin.pl/rozklady/index.html",
                "", "");
    }
}
