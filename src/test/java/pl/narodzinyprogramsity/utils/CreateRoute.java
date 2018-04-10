package pl.narodzinyprogramsity.utils;

import pl.narodzinyprogramsity.modelType.RoutType;
import pl.narodzinyprogramsity.models.Route;

public class CreateRoute {

    public static Route getOriginalRoute() {
        return new Route("1",
                "1",
                "Głębokie - Potulicka",
                "",
                RoutType.getType(0),
                "http://www.zditm.szczecin.pl/rozklady/index.html",
                "",
                "");
    }

    public static Route testRoute1() {
        return new Route("testId1",
                "testShortName1",
                "testLongName1",
                "testDesc1",
                RoutType.getType(1),
                "testURL1",
                "testColor1",
                "TestTextColor1");
    }

    public static Route testRoute2() {
        return new Route("testId2",
                "testShortName2",
                "testLongName2",
                "testDesc2",
                RoutType.getType(2),
                "testURL2",
                "testColor2",
                "TestTextColor2");
    }

    public static Route testRoute3() {
        return new Route("testId3",
                "testShortName3",
                "testLongName3",
                "testDesc3",
                RoutType.getType(3),
                "testURL3",
                "testColor3",
                "TestTextColor3");
    }

    public static Route testRoute4() {
        return new Route("testId4",
                "testShortName4",
                "testLongName4",
                "testDesc4",
                RoutType.getType(4),
                "testURL4",
                "testColor14",
                "TestTextColor4");
    }


}
