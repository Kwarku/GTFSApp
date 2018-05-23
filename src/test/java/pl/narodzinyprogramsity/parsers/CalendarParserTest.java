package pl.narodzinyprogramsity.parsers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.models.Calendar;
import pl.narodzinyprogramsity.utils.CreateCalendar;

import static org.assertj.core.api.Assertions.assertThat;

public class CalendarParserTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Calendar testCalendar;
    private CalendarParser parser;

    @Before
    public void setUp() {
        testCalendar = CreateCalendar.getTestCalendar();
        parser = new CalendarParser();
    }

    @Test
    public void parseTest() throws NotCorrectLineException {
        Calendar calendar = parser.parseTo("POW,1,1,1,1,1,0,0,20180305,20180623");

        assertThat(calendar).isEqualTo(testCalendar);
    }

    @Test
    public void parseBrokenLineTest() throws NotCorrectLineException {
        thrown.expect(NotCorrectLineException.class);
        thrown.expectMessage("This line is broken");

        parser.parseTo("POW,1,1,1,1,1,0,20180305,20180623");
        parser.parseTo("1,1,0,0,20180305,20180623");
        parser.parseTo("POW,1,1,1,1,1,0,0");
    }

    @Test
    public void parseEmptyLineTest() throws NotCorrectLineException {
        thrown.expect(NotCorrectLineException.class);

        parser.parseTo(",,,,,,,,,");
    }
}