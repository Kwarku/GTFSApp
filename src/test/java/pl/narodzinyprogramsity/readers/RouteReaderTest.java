package pl.narodzinyprogramsity.readers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import pl.narodzinyprogramsity.models.Route;
import pl.narodzinyprogramsity.parsers.RouteParser;
import pl.narodzinyprogramsity.repository.RouteRepository;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class RouteReaderTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private RouteRepository repository;
    private RouteReader reader;

    @Before
    public void setUp() {
        repository = new RouteRepository();
        reader = new RouteReader(repository, new RouteParser());
    }

    @Test
    public void readTest() throws IOException {
        reader.read();

        List<Route> routes = repository.getAll();
        assertThat(routes).isNotEmpty();
        assertThat(routes.size()).isEqualTo(100);
        assertThat(routes.get(20)).isInstanceOf(Route.class);
    }

    @Test
    public void dirTest() throws IOException {
        RouteReader spyReader = Mockito.spy(reader);
        when(spyReader.getFileDir()).thenReturn("test.txt");

        thrown.expect(IOException.class);
        spyReader.read();
    }
}