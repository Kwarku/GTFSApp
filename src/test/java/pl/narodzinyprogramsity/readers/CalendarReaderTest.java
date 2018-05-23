package pl.narodzinyprogramsity.readers;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import pl.narodzinyprogramsity.models.Calendar;
import pl.narodzinyprogramsity.parsers.CalendarParser;
import pl.narodzinyprogramsity.repository.CalendarRepository;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class CalendarReaderTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private CalendarReader spyReader;
    private CalendarRepository repository;

    @Before
    public void setUp() {
        repository = new CalendarRepository();


        spyReader = Mockito.spy(new CalendarReader(repository, new CalendarParser()));
        when(spyReader.getFileDir()).thenReturn("./test-resources/test-calendar.txt");
    }

    //fixme nie dziala dalaje!!
    @Test
    public void readTest() throws IOException {
        spyReader.read();

        List<Calendar> calendarList = repository.getAll();

        assertThat(calendarList).isNotEmpty();
        assertThat(calendarList.size()).isEqualTo(10);
        assertThat(calendarList.get(1)).isInstanceOf(Calendar.class);
    }

    @Test
    public void wrongDirFileTest() throws IOException {
        when(spyReader.getFileDir()).thenReturn("wrong dir file test");

        thrown.expect(IOException.class);

        spyReader.read();
    }
}