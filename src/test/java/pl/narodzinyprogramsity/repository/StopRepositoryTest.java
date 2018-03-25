package pl.narodzinyprogramsity.repository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.models.Stop;
import pl.narodzinyprogramsity.utils.CreateStop;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StopRepositoryTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private StopRepository repository;
    private StopRepository testRepository;
    private Stop testStop;
    private List<Stop> stops;

    @Before
    public void setUp() {
        stops = new ArrayList<>();
        repository = new StopRepository();
        testStop = CreateStop.getTestStop();

        testRepository = new StopRepository();
        testRepository.list.add(new Stop());
        testRepository.list.add(Stop.NOT_FOUND);
        testRepository.list.add(testStop);

    }

    @Test
    public void addTest() {
        String result = repository.add(testStop);

        assertThat(result).isEqualToIgnoringCase(testStop.getId()).isNotEmpty();
        assertThat(repository.getAll().size()).isEqualTo(1);
    }

    @Test
    public void addNullTest() {
        thrown.expect(NullPointerException.class);
        repository.add(null);
        repository.list.add(null);
    }

    @Test
    public void getTest() {
        Stop stop = testRepository.get("");
        assertThat(stop.getId()).isBlank();

        stop = testRepository.get(testStop.getId());
        assertThat(stop).isEqualTo(testStop);
    }

    @Test
    public void getNullTest() {
        Stop stop = testRepository.get("123");

        assertThat(stop).isNotNull().isEqualTo(Stop.NOT_FOUND);
        assertThat(stop.getId()).isBlank();

    }

    @Test
    public void getByNullStringTest() {
        thrown.expect(NullPointerException.class);
        repository.get(null);
    }

    @Test
    public void getAllTest() {
        stops = testRepository.getAll();

        assertThat(stops).isNotEmpty().contains(new Stop());
        assertThat(stops.size()).isEqualTo(3);
        assertThat(stops.get(2)).isEqualTo(testStop);
    }


    @Test
    public void updateTest() {
        testRepository.update(new Stop(), testStop);

        Stop stop = testRepository.get(testStop.getId());
        assertThat(stop).isNotEqualTo(new Stop()).isEqualTo(testStop).isNotNull();
    }

    @Test
    public void deleteByObjectTest() {
        stops = testRepository.getAll();
        int startSize = stops.size();

        testRepository.delete(testStop);

        stops = testRepository.getAll();
        int endSize = stops.size();

        assertThat(startSize).isEqualTo(3).isNotEqualTo(endSize);
        assertThat(endSize).isEqualTo(2);
    }

    @Test
    public void deleteByNullObjTest() {
        thrown.expect(NullPointerException.class);

        testRepository.delete((Stop) null);

    }

    @Test
    public void deleteByIdTest() {
        stops = testRepository.getAll();
        int startSize = stops.size();

        testRepository.delete(testStop.getId());
        testRepository.delete(new Stop().getId());
        stops = testRepository.getAll();
        int endSize = stops.size();

        assertThat(startSize).isEqualTo(3).isNotEqualTo(endSize);
        assertThat(endSize).isEqualTo(1);
    }

    @Test
    public void deleteByNullIdTest() {
        thrown.expect(NullPointerException.class);

        testRepository.delete((String) null);
    }


}