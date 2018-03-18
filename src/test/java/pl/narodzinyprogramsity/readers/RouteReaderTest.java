package pl.narodzinyprogramsity.readers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import pl.narodzinyprogramsity.models.Rout;
import pl.narodzinyprogramsity.parsers.RoutParser;
import pl.narodzinyprogramsity.repository.RoutRepository;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class RouteReaderTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private RoutRepository repository;
    private RouteReader reader;

    @Before
    public void setUp() {
        repository = new RoutRepository();
        reader = new RouteReader(repository, new RoutParser());
    }

    @Test
    public void readTest() throws IOException {
        reader.read();

        List<Rout> routes = repository.getAll();
        assertThat(routes).isNotEmpty();
        assertThat(routes.size()).isEqualTo(100);
        assertThat(routes.get(20)).isInstanceOf(Rout.class);
    }

    @Test
    public void dirTest() throws IOException {
        RouteReader spyReader = Mockito.spy(reader);
        when(spyReader.getFileDir()).thenReturn("test.txt");

        thrown.expect(IOException.class);
        spyReader.read();
    }
}