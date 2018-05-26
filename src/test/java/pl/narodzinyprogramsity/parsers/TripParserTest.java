package pl.narodzinyprogramsity.parsers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.models.Trip;
//import pl.narodzinyprogramsity.utils.CreteTrip;

import static org.assertj.core.api.Assertions.assertThat;

public class TripParserTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Trip testTrip;
    private TripParser tripParser;

    @Before
    public void setUp() {
        tripParser = new TripParser();
//        testTrip = CreteTrip.getOriginalTrip();
    }

    @Test
    public void parserTest() throws NotCorrectLineException {
        Trip trip = tripParser.parseTo("\"A\",\"POW\",\"A-7549-POW-1-1-0\",\"Plac Rodła\",\"0\",\"A/1\",665,0,1");

        assertThat(trip).isEqualTo(testTrip);
    }

    @Test
    public void parserWrongLineTest() throws NotCorrectLineException {
        thrown.expect(NotCorrectLineException.class);
        thrown.expectMessage("This line is broken");

        tripParser.parseTo("\"A\",\"POW\",\"A-7549-POW-1-1-0\",\"Plac Rodła\",\"0\",\"A/1\",665,0");
        tripParser.parseTo("\"A\",\"POW\",\"A-7549-POW-1-1-0\",\"0\",\"A/1\",665,0,1");
    }

    @Test
    public void emptyLineParseTest() throws NotCorrectLineException {
        Trip trip = tripParser.parseTo(",,,,,,,,");

        assertThat(trip.getBlockId()).isBlank();
        assertThat(trip).isNotNull();
    }
}
