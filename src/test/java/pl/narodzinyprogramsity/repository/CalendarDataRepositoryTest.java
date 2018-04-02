package pl.narodzinyprogramsity.repository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.models.CalendarData;
import pl.narodzinyprogramsity.utils.CreateCalendarData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalendarDataRepositoryTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private CalendarData testCalendarData;
    private CalendarDataRepository repository;
    private CalendarDataRepository testRepository;
    private List<CalendarData> result;

    private CalendarData data1;
    private CalendarData data2;
    private CalendarData data3;

    @Before
    public void setUp() {
        testCalendarData = CreateCalendarData.getTestCalendarData();
        repository = new CalendarDataRepository();
        testRepository = new CalendarDataRepository();


        data1 = testCalendarData;
        data2 = CalendarData.NOT_FOUND;
        data3 = new CalendarData();

        testRepository.list.add(data1);
        testRepository.list.add(data2);
        testRepository.list.add(data3);

        result = new ArrayList<>();
        result.clear();
    }

    @Test
    public void addTest() {
        String id = repository.add(testCalendarData);


        assertThat(repository.list.size()).isEqualTo(1);
        assertThat(repository.get(id)).isEqualTo(testCalendarData);
    }

    @Test
    public void addNullObjTest() {
        thrown.expect(NullPointerException.class);

        repository.add(null);
    }

    @Test
    public void getTest() {
        String id = testCalendarData.getId();
        CalendarData calendarData = testRepository.get(id);

        assertThat(calendarData).isEqualTo(testCalendarData);
    }

    @Test
    public void getNoExistObjTest() {
        CalendarData calendarData = repository.get("test");

        assertThat(calendarData).isNotNull().isEqualTo(CalendarData.NOT_FOUND);
    }

    //fixme what sens this test have? If string is null than throw nullPointerException. If use null string than application die.
    @Test
    public void getByNullIDTest() {
        thrown.expect(NullPointerException.class);

        repository.get(null);
    }

    @Test
    public void getAllTest() {
        result = testRepository.getAll();

        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0)).isEqualTo(testCalendarData);
    }

    @Test
    public void updateTest() {
        CalendarData newObj = CalendarData.NOT_FOUND;
        newObj.setServiceId("testServiceId");
        newObj.setId("testID");

        testRepository.update(CalendarData.NOT_FOUND, newObj);

        assertThat(testRepository.get(newObj.getId())).isEqualTo(newObj);
        assertThat(testRepository.getAll().size()).isEqualTo(3);
    }

    @Test
    public void updateObjUsingNullObj() {
        thrown.expect(NullPointerException.class);

        testRepository.update(CalendarData.NOT_FOUND, null);
    }

    @Test
    public void updateNoExistObj() {
        CalendarData toUpdate = new CalendarData("1234", LocalDate.MAX, true);
        CalendarData updated = new CalendarData();
        updated.setDataAvailable(true);
        updated.setServiceId("testID");

        testRepository.update(toUpdate, updated);

        result = testRepository.getAll();
        assertThat(result.get(0)).isEqualTo(data1);
        assertThat(result.get(1)).isEqualTo(data2);
        assertThat(result.get(2)).isEqualTo(data3);
    }

    @Test
    public void deleteByObjTest() {
        int listSizeOnStart = testRepository.getAll().size();

        testRepository.delete(data1);
        int listSizeAfterDeleteOneObj = testRepository.getAll().size();
        testRepository.delete(data2);
        int listSizeAfterDeleteTwoObj = testRepository.getAll().size();

        assertThat(listSizeOnStart).isEqualTo(3);
        assertThat(listSizeAfterDeleteOneObj).isEqualTo(2);
        assertThat(listSizeAfterDeleteTwoObj).isEqualTo(1);
    }


    @Test
    public void deleteNoExitObjByObjTest() {
        int size = testRepository.getAll().size();
        CalendarData calendarData = new CalendarData("test", LocalDate.MAX, true);

        testRepository.delete(calendarData);

        assertThat(testRepository.getAll().size()).isEqualTo(size);
    }

    @Test
    public void deleteObjByNullObjTest() {
        thrown.expect(NullPointerException.class);

        testRepository.delete((CalendarData) null);
    }

    @Test
    public void deleteByStringTest() {
        int listSizeOnStart = testRepository.getAll().size();

        testRepository.delete(data1.getId());
        int listSizeAfterDeleteOneObj = testRepository.getAll().size();
        testRepository.delete(data2.getId());
        int listSizeAfterDeleteTwoObj = testRepository.getAll().size();

        assertThat(listSizeOnStart).isEqualTo(3);
        assertThat(listSizeAfterDeleteOneObj).isEqualTo(2);
        assertThat(listSizeAfterDeleteTwoObj).isEqualTo(1);
    }

    @Test
    public void deleteNoExistObjByString() {
        int startSize = testRepository.getAll().size();

        testRepository.delete("deleteTestId");
        int endSize = testRepository.getAll().size();

        assertThat(startSize).isEqualTo(endSize).isEqualTo(3);
    }

    @Test
    public void deleteObjByNullString() {
        thrown.expect(NullPointerException.class);

        testRepository.delete((String) null);
    }
}