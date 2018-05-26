package pl.narodzinyprogramsity.repository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.models.StopTime;
//import pl.narodzinyprogramsity.utils.CreateStopTime;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StopTimeRepositoryTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private StopTime st1;
    private StopTime st2;
    private StopTime st3;

    private StopTime testStopTime;

    private StopTimeRepository emptyRepository;
    private StopTimeRepository testRepository;

    private List<StopTime> result = new ArrayList<>();

    private int startListSize;
    private int endListSize;

    @Before
    public void setUp() {
//        st1 = CreateStopTime.createTestStopTime1();
//        st2 = CreateStopTime.createTestStopTime2();
//        st3 = CreateStopTime.createTestStopTime3();
//        testStopTime = CreateStopTime.createOriginalStopTime();

        emptyRepository = new StopTimeRepository();
        testRepository = new StopTimeRepository();

        testRepository.list.add(st1);
        testRepository.list.add(st2);
        testRepository.list.add(st3);

        result.clear();

        startListSize = Integer.MIN_VALUE;
        endListSize = Integer.MIN_VALUE;
    }

    @Test
    public void addTest() {
        startListSize = emptyRepository.list.size();

        String st1ID = emptyRepository.add(st1);
        String st2ID = emptyRepository.add(st2);
        endListSize = emptyRepository.list.size();

        assertThat(startListSize).isEqualTo(0).isLessThan(endListSize);
        assertThat(endListSize).isEqualTo(2);
        assertThat(st1ID).isEqualToIgnoringCase(st1.getId());
        assertThat(st2ID).isEqualToIgnoringCase(st2.getId());
    }

    @Test
    public void addNullObjTest() {
        thrown.expect(NullPointerException.class);

        emptyRepository.add(null);
    }

    @Test
    public void getTest() {
        StopTime stopTime = testRepository.get(st3.getId());

        assertThat(stopTime).isEqualTo(st3).isNotEqualTo(st2);
    }

    @Test
    public void getNoExistObjTest() {
        StopTime stopTime = testRepository.get("noExistID");

        assertThat(stopTime).isNotNull().isEqualTo(StopTime.NOT_FOUND);
    }

    @Test
    public void getFromEmptyListTest() {
        StopTime stopTime = emptyRepository.get("test");

        assertThat(stopTime).isEqualTo(StopTime.NOT_FOUND);
    }

    @Test
    public void getByNullStringTest() {
        thrown.expect(NullPointerException.class);

        testRepository.get(null);
    }

    @Test
    public void getAllTest() {
        result = testRepository.getAll();

        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0)).isEqualTo(st1);
    }

    @Test
    public void updateTest() {
        StopTime beforeUpdate = testRepository.get(st2.getId());

        testRepository.update(beforeUpdate, testStopTime);
        StopTime afterUpdate = testRepository.get(testStopTime.getId());

        assertThat(beforeUpdate).isNotNull().isNotEqualTo(afterUpdate).isEqualTo(st2);
        assertThat(afterUpdate).isEqualTo(testStopTime);
    }

    @Test
    public void updateNoExistObjTest() {
        testRepository.update(StopTime.NOT_FOUND, testStopTime);

        result = testRepository.getAll();
        assertThat(result.get(0)).isEqualTo(st1);
        assertThat(result.get(1)).isEqualTo(st2);
        assertThat(result.get(2)).isEqualTo(st3);
    }

    @Test
    public void updateUsingNullObjTest() {
        thrown.expect(NullPointerException.class);

        testRepository.update(st1, null);
    }

    @Test
    public void deleteByObjTest() {
        startListSize = testRepository.getAll().size();

        testRepository.delete(st1);
        testRepository.delete(st2);
        testRepository.delete(st3);
        result = testRepository.getAll();
        endListSize = result.size();

        assertThat(startListSize).isEqualTo(3).isGreaterThan(endListSize);
        assertThat(endListSize).isEqualTo(0);
        assertThat(result).isEmpty();

    }

    @Test
    public void deleteByStringTest() {
        startListSize = testRepository.getAll().size();

        testRepository.delete(st1.getId());
        testRepository.delete(st2.getId());
        testRepository.delete(st3.getId());
        result = testRepository.getAll();
        endListSize = result.size();

        assertThat(startListSize).isEqualTo(3).isGreaterThan(endListSize);
        assertThat(endListSize).isEqualTo(0);
        assertThat(result).isEmpty();
    }

    @Test
    public void deleteByNullTest() {
        thrown.expect(NullPointerException.class);

        testRepository.delete((String) null);
        testRepository.delete((StopTime) null);
    }

    @Test
    public void deleteNoExistObjByStringTest() {
        startListSize = testRepository.getAll().size();

        testRepository.delete("noExistId");
        endListSize = testRepository.getAll().size();

        assertThat(startListSize).isEqualTo(endListSize).isEqualTo(3);
    }

    @Test
    public void deleteNoExistObjByObjTest() {
        startListSize = testRepository.getAll().size();

//        testRepository.delete(CreateStopTime.createTestStopTime4());
        endListSize = testRepository.getAll().size();

        assertThat(startListSize).isEqualTo(endListSize).isEqualTo(3);
    }



}