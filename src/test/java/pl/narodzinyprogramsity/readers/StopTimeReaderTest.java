package pl.narodzinyprogramsity.readers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import pl.narodzinyprogramsity.models.StopTime;
import pl.narodzinyprogramsity.parsers.StopTimeParser;
import pl.narodzinyprogramsity.repository.StopTimeRepository;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class StopTimeReaderTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private StopTimeRepository repository;
    private StopTimeReader spyReader;

    @Before
    public void setUp() {
        repository = new StopTimeRepository();

        spyReader = Mockito.spy(new StopTimeReader(repository, new StopTimeParser()));
        when(spyReader.getFileDir()).thenReturn("./test-resources/test-stop_times.txt");
    }


    @Test
    public void readTest() throws IOException {
        spyReader.read();

        List<StopTime> stopTimes = repository.getAll();

        assertThat(stopTimes).isNotEmpty();
        assertThat(stopTimes.size()).isEqualTo(10);
    }

    @Test
    public void wrongDirTest() throws IOException {
        when(spyReader.getFileDir()).thenReturn("wrong path test");

        thrown.expect(IOException.class);

        spyReader.read();
    }
}