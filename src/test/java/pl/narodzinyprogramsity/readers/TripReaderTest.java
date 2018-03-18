package pl.narodzinyprogramsity.readers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import pl.narodzinyprogramsity.models.Trip;
import pl.narodzinyprogramsity.parsers.TripParser;
import pl.narodzinyprogramsity.repository.TripRepository;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class TripReaderTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private TripRepository tripRepository;
    private TripReader spyReader;


    @Before
    public void setUp() {
        tripRepository = new TripRepository();


        spyReader = Mockito.spy(new TripReader(tripRepository, new TripParser()));
        when(spyReader.getFileDir()).thenReturn("./test-resources/test-trips.txt");
    }

    @Test
    public void readTest() throws IOException {
        spyReader.read();

        List<Trip> trips = tripRepository.getAll();

        assertThat(trips).isNotEmpty();
        assertThat(trips.size()).isEqualTo(10);
        assertThat(trips.get(2)).isInstanceOf(Trip.class);
    }

    @Test
    public void wrongDirTest() throws IOException {
        when(spyReader.getFileDir()).thenReturn("wrongPath");
        thrown.expect(IOException.class);
        spyReader.read();

    }
}