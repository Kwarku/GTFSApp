package pl.narodzinyprogramsity.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.models.Trip;
import pl.narodzinyprogramsity.utils.CreteTrip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TripRepositoryTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Trip testTrip;
    private Trip trip1;
    private Trip trip2;
    private Trip trip3;
    private Trip noAddToRepositoryTrip;

    private TripRepository emptyRepository;
    private TripRepository testRepository;

    private int startSize;
    private int endSize;

    private List<Trip> result;

    @Before
    public void setUp() {
        testTrip = CreteTrip.getOriginalTrip();
        trip1 = CreteTrip.testTrip1();
        trip2 = CreteTrip.testTrip2();
        trip3 = CreteTrip.testTrip3();
        noAddToRepositoryTrip = CreteTrip.testTrip4();

        emptyRepository = new TripRepository();
        testRepository = new TripRepository();
        testRepository.list.addAll(Arrays.asList(trip1, trip2, trip3));

        result = new ArrayList<>();

        startSize = Integer.MIN_VALUE;
        endSize = Integer.MIN_VALUE;
    }

    @After
    public void tearDown() {
        result.clear();
    }

    @Test
    public void addTest() {
        startSize = emptyRepository.list.size();

        String id1 = emptyRepository.add(testTrip);
        String id2 = emptyRepository.add(trip1);
        endSize = emptyRepository.list.size();

        assertThat(id1).isEqualTo(testTrip.getId());
        assertThat(id2).isEqualTo(trip1.getId());
        assertThat(startSize).isLessThan(endSize).isEqualTo(0);
        assertThat(endSize).isGreaterThan(startSize).isEqualTo(2);
    }

    @Test
    public void addNullTest() {
        thrown.expect(NullPointerException.class);

        emptyRepository.add(null);
    }

    @Test
    public void getTest() {
        String id = trip2.getId();

        Trip someTrip = testRepository.get(id);

        assertThat(someTrip).isEqualTo(trip2);
    }

    @Test
    public void getNoExistObjTest() {
        String id = noAddToRepositoryTrip.getId();

        Trip noExistTrip1 = testRepository.get(id);
        Trip noExistTrip2 = emptyRepository.get(id);

        assertThat(noExistTrip1).isEqualTo(Trip.NOT_FOUND).isNotEqualTo(noAddToRepositoryTrip);
        assertThat(noExistTrip2).isEqualTo(Trip.NOT_FOUND);
    }

    @Test
    public void getObjUsingNullStringTest() {
        thrown.expect(NullPointerException.class);

        testRepository.get(null);
    }

    @Test
    public void updateTest() {
        testRepository.update(trip2, noAddToRepositoryTrip);
        startSize = testRepository.list.size();

        Trip tripAfterUpdate = testRepository.get(noAddToRepositoryTrip.getId());
        result = testRepository.getAll();

        assertThat(tripAfterUpdate).isEqualTo(noAddToRepositoryTrip);
        assertThat(startSize).isEqualTo(result.size());
    }

    @Test
    public void updateNoExistObjTest() {
        testRepository.update(noAddToRepositoryTrip, noAddToRepositoryTrip);

        Trip tripAfterUpdate = testRepository.get(noAddToRepositoryTrip.getId());

        assertThat(tripAfterUpdate).isEqualTo(Trip.NOT_FOUND).isNotEqualTo(noAddToRepositoryTrip);
    }

    @Test
    public void updateUsingNullObjTest() {
        thrown.expect(NullPointerException.class);

        testRepository.update(trip2, null);
    }

    @Test
    public void deleteByObjTest() {
        startSize = testRepository.list.size();

        testRepository.delete(trip1);
        testRepository.delete(trip3);
        endSize = testRepository.list.size();

        assertThat(startSize).isGreaterThan(endSize).isEqualTo(3);
        assertThat(endSize).isLessThan(startSize).isEqualTo(1);

    }

    @Test
    public void deleteByStringTest() {
        startSize = testRepository.list.size();

        testRepository.delete(trip2.getId());
        testRepository.delete(trip1.getId());
        endSize = testRepository.list.size();

        assertThat(startSize).isGreaterThan(endSize).isEqualTo(3);
        assertThat(endSize).isLessThan(startSize).isEqualTo(1);
    }

    @Test
    public void deleteNoExistObjTest() {
        startSize = testRepository.list.size();

        testRepository.delete("no exist id");
        testRepository.delete(noAddToRepositoryTrip);
        endSize = testRepository.list.size();

        assertThat(startSize).isEqualTo(endSize).isEqualTo(3);
    }

    @Test
    public void deleteByNullTest() {
        thrown.expect(NullPointerException.class);

        testRepository.delete((Trip) null);
        testRepository.delete((String) null);
        emptyRepository.delete((Trip) null);
        emptyRepository.delete((String) null);
    }
}