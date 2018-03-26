package pl.narodzinyprogramsity.parsers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.modelType.LocationType;
import pl.narodzinyprogramsity.models.Stop;
import pl.narodzinyprogramsity.modelType.WheelchairBoardingType;
import pl.narodzinyprogramsity.utils.CreateStop;

import static org.assertj.core.api.Assertions.assertThat;

public class StopParserTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private StopParser stopParser;
    private Stop testStop;

    @Before
    public void setUp() {
        stopParser = new StopParser();
        testStop = CreateStop.getTestStop();
    }

    @Test
    public void parseTest() throws NotCorrectLineException {
        Stop stop = stopParser.parseTo("1271,\"1271\",\"Kołłątaja 11-15\",\"\",53.443798,14.548237,\"http://www.zditm.szczecin.pl/rozklady/\",1,,");

        assertThat(stop).isEqualTo(testStop);
    }

    @Test
    public void parseWrongLineTest() throws NotCorrectLineException {
        thrown.expect(NotCorrectLineException.class);
        thrown.expectMessage("This line is broken");

        stopParser.parseTo("1271,\"1271\",\"\",53.443798,14.548237,\"http://www.zditm.szczecin.pl/rozklady/\",1,,");
        stopParser.parseTo("1271,\"1271\",\"Kołłątaja 11-15\",\"\",53.443798,14.548237,\"http://www.zditm.szczecin.pl/rozklady/\",1");
    }

    @Test
    public void emptyLineParserTest() throws NotCorrectLineException {
        Stop stop = stopParser.parseTo(",,,,,,,,,");

        assertThat(stop).isNotNull();
        assertThat(stop.getStopLat()).isBlank();
        assertThat(stop.getLocationType()).isEqualTo(LocationType.UNKNOWN);
        assertThat(stop.getWheelchairBoardingType()).isEqualTo(WheelchairBoardingType.NO_INFORMATION);

    }
}