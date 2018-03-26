package pl.narodzinyprogramsity.parsers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.models.Rout;
import pl.narodzinyprogramsity.modelType.RoutType;
import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.utils.CreateRoute;

import static org.assertj.core.api.Assertions.assertThat;

public class RoutParserTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private Rout testRoute;
    private RoutParser routParser;

    @Before
    public void setUp() {
        routParser = new RoutParser();
        testRoute = CreateRoute.getTestRoute();
    }



    @Test
    public void parserTest() throws NotCorrectLineException {
        Rout rout = routParser.parseTo("\"1\",\"1\",\"Głębokie - Potulicka\",,0,\"http://www.zditm.szczecin.pl/rozklady/index.html\",,");

        assertThat(rout).isEqualTo(testRoute);
    }

    @Test
    public void parseWrongLineTest() throws NotCorrectLineException {
        thrown.expect(NotCorrectLineException.class);
        thrown.expectMessage("This line is broken");

        routParser.parseTo("\"1\",\"1\",0,\"http://www.zditm.szczecin.pl/rozklady/index.html\",,");
    }

    @Test
    public void emptyLineParseTest() throws NotCorrectLineException {
        Rout rout = routParser.parseTo(" ,,,,,,,");

        assertThat(rout.getRouteColor()).isBlank();
        assertThat(rout.getRouteType()).isEqualTo(RoutType.UNKNOWN);
        assertThat(rout.getId()).isBlank();
        assertThat(rout.getRouteShortName()).isBlank();
    }
}