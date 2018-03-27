package pl.narodzinyprogramsity.parsers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.models.CalendarData;
import pl.narodzinyprogramsity.utils.CreateCalendarData;

import java.util.zip.DataFormatException;

import static org.assertj.core.api.Assertions.assertThat;

public class CalendarDataParserTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private CalendarDataParser parser;
    private CalendarData testCalendarData;

    @Before
    public void setUp() {
        parser = new CalendarDataParser();
        testCalendarData = CreateCalendarData.getTestCalendarData();
    }

    @Test
    public void calendarDataParseToTest() throws NotCorrectLineException, DataFormatException {
        CalendarData calendarData = parser.parseTo("NIEH,20180325,1");

        assertThat(calendarData).isEqualTo(testCalendarData);
    }

    @Test
    public void calendarDataParseWrongLineTest() throws NotCorrectLineException, DataFormatException {
        thrown.expect(NotCorrectLineException.class);
        thrown.expectMessage("This line is broken");

        parser.parseTo("NIEH,20180325");
        parser.parseTo("NIEH,1");
    }

    @Test
    public void calendarDataParseEmptyLineTest() throws NotCorrectLineException, DataFormatException {
        thrown.expect(NotCorrectLineException.class);

        parser.parseTo(",,");
    }
}