package pl.narodzinyprogramsity.parsers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.models.Route;
import pl.narodzinyprogramsity.modelType.RoutType;
import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.utils.CreateRoute;

import static org.assertj.core.api.Assertions.assertThat;

public class RouteParserTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private Route testRoute;
    private RouteParser routeParser;

    @Before
    public void setUp() {
        routeParser = new RouteParser();
        testRoute = CreateRoute.getTestRoute();
    }



    @Test
    public void parserTest() throws NotCorrectLineException {
        Route route = routeParser.parseTo("\"1\",\"1\",\"Głębokie - Potulicka\",,0,\"http://www.zditm.szczecin.pl/rozklady/index.html\",,");

        assertThat(route).isEqualTo(testRoute);
    }

    @Test
    public void parseWrongLineTest() throws NotCorrectLineException {
        thrown.expect(NotCorrectLineException.class);
        thrown.expectMessage("This line is broken");

        routeParser.parseTo("\"1\",\"1\",0,\"http://www.zditm.szczecin.pl/rozklady/index.html\",,");
    }

    @Test
    public void emptyLineParseTest() throws NotCorrectLineException {
        Route route = routeParser.parseTo(" ,,,,,,,");

        assertThat(route.getRouteColor()).isBlank();
        assertThat(route.getRouteType()).isEqualTo(RoutType.UNKNOWN);
        assertThat(route.getId()).isBlank();
        assertThat(route.getRouteShortName()).isBlank();
    }
}