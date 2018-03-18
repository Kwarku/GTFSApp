package pl.narodzinyprogramsity.utils;

import org.jetbrains.annotations.NotNull;
import pl.narodzinyprogramsity.models.Rout;
import pl.narodzinyprogramsity.models.RoutType;

public class CreateRoute {

    public static Rout getTestRoute() {
        return new Rout("1",
                "1",
                "Głębokie - Potulicka",
                "",
                RoutType.getType(0),
                "http://www.zditm.szczecin.pl/rozklady/index.html",
                "", "");
    }
}
