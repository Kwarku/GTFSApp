package pl.narodzinyprogramsity.readers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import pl.narodzinyprogramsity.models.Stop;
import pl.narodzinyprogramsity.parsers.StopParser;
import pl.narodzinyprogramsity.repository.StopRepository;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class StopReadersTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private StopRepository repository;
    private StopReaders spyReaders;


    @Before
    public void setUp() {
        repository = new StopRepository();
        StopReaders readers = new StopReaders(repository, new StopParser());
        spyReaders = Mockito.spy(readers);
        when(spyReaders.getFileDir()).thenReturn("./test-resources/test-stops.txt");
    }

    @Test
    public void readTest() throws IOException {
        spyReaders.read();

        List<Stop> stops = repository.getAll();

        assertThat(stops).isNotEmpty();
        assertThat(stops.size()).isEqualTo(10);
    }

    @Test
    public void dirTest() throws IOException {
        when(spyReaders.getFileDir()).thenReturn("test");

        thrown.expect(IOException.class);
        spyReaders.read();

    }
}