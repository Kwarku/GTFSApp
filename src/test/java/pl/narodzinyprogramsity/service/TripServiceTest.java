package pl.narodzinyprogramsity.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.narodzinyprogramsity.models.Trip;
import pl.narodzinyprogramsity.parsers.TripParser;
import pl.narodzinyprogramsity.readers.TripReader;
import pl.narodzinyprogramsity.repository.TripRepository;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class TripServiceTest {
    private TripAPI tripService;
    private TripReader spyReader;
    private TripRepository repository;
    private List<Trip> trips;


    @Before
    public void setUp() throws IOException {
        repository = new TripRepository();
        TripReader reader = new TripReader(repository, new TripParser());

        spyReader = Mockito.spy(reader);
        when(spyReader.getFileDir()).thenReturn("./test-resources/test-trips.txt");

        tripService = new TripService(repository, spyReader);
    }

    @Test
    public void loadTripTest() throws IOException {
        tripService.loadTrip();

        assertThat(repository.getAll()).isNotEmpty();
        assertThat(repository.getAll().size()).isEqualTo(10);
    }

    @Test
    public void findByRoutIdTest() throws IOException {
        when(spyReader.getFileDir()).thenReturn("./test-resources/TripsToSearch.txt");
        tripService.loadTrip();

        trips = tripService.findTripByRouteId("7");

        assertThat(trips.size()).isEqualTo(4);
    }

    @Test
    public void getAllTripsTest() {

    }
}