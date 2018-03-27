package pl.narodzinyprogramsity.parsers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.models.StopTime;
import pl.narodzinyprogramsity.utils.CreateStopTime;

import static org.assertj.core.api.Assertions.assertThat;

public class StopTimeParserTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private StopTime testStopTime;
    private StopTimeParser parser;

    @Before
    public void setUp() {
        testStopTime = CreateStopTime.createTestStopTime();
        parser = new StopTimeParser();
    }

    @Test
    public void parseTest() throws NotCorrectLineException {
        StopTime stopTime = parser.parseTo("A-7549-POW-1-1-0,04:41:00,04:41:00,84613,1,,0,0");

        assertThat(stopTime).isEqualTo(testStopTime);
    }

    @Test
    public void parseBrokenLineTest() throws NotCorrectLineException {
        thrown.expect(NotCorrectLineException.class);

        parser.parseTo("A-7549-POW-1-1-0,04:41:00,84613,1,,0,0");
        parser.parseTo("A-7549-POW-1-1-0,04:41:00,04:41:00,84613,1");
        parser.parseTo("A-7549-POW-1-1-0,84613,1,,0,0");
        parser.parseTo("04:41:00,04:41:00,84613,1,,0,0");
    }

    @Test
    public void parseEmptyLineTest() throws NotCorrectLineException {
        thrown.expect(NotCorrectLineException.class);

        parser.parseTo(",,,,,,,");

    }
}