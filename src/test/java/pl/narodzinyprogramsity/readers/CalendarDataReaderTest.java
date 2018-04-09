package pl.narodzinyprogramsity.readers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import pl.narodzinyprogramsity.models.CalendarData;
import pl.narodzinyprogramsity.parsers.CalendarDataParser;
import pl.narodzinyprogramsity.repository.CalendarDataRepository;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class CalendarDataReaderTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private CalendarDataReader spyReader;
    private CalendarDataRepository repository;

    @Before
    public void setUp() {
        repository = new CalendarDataRepository();

        spyReader = Mockito.spy(new CalendarDataReader(repository, new CalendarDataParser()));
        when(spyReader.getFileDir()).thenReturn("./test-resources/test-calendar_dates.txt");
    }


    @Test
    public void readTest() throws IOException {
        spyReader.read();
        List<CalendarData> calendarDataList = repository.getAll();

        assertThat(calendarDataList).isNotEmpty();
        assertThat(calendarDataList.size()).isEqualTo(10);
        assertThat(calendarDataList.get(5)).isInstanceOf(CalendarData.class);
    }

    @Test
    public void wrongDirTest() throws IOException {
        when(spyReader.getFileDir()).thenReturn("wrong path test");
        thrown.expect(IOException.class);

        spyReader.read();
    }
}