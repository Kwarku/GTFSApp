package pl.narodzinyprogramsity.repository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.models.Trip;
import pl.narodzinyprogramsity.utils.CreteTrip;

import static org.assertj.core.api.Assertions.assertThat;

public class TripRepositoryTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Trip trip;
    private TripRepository tripRepository;

    @Before
    public void setUp() {
        tripRepository = new TripRepository();
        trip = CreteTrip.getTestTrip();
    }

    @Test
    public void addTest() {
        String id = tripRepository.add(trip);

        assertThat(trip).isEqualTo(tripRepository.get(id));
    }

    @Test
    public void addNullTest() {
        thrown.expect(NullPointerException.class);

        tripRepository.add(null);
    }

    @Test
    public void getAllTest(){
        tripRepository.add(new Trip());
        tripRepository.add(trip);
        tripRepository.add(new Trip());
        tripRepository.add(new Trip());

        assertThat(tripRepository.getAll().size()).isEqualTo(4);
        assertThat(tripRepository.getAll().get(1)).isEqualTo(trip);
    }

    @Test
    public void getNullObjectTest(){
        tripRepository.add(new Trip());
        tripRepository.add(new Trip());

        assertThat(tripRepository.get("10")).isNotNull().isEqualTo(Trip.NOT_FOUND);

    }
}