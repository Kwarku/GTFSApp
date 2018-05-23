package pl.narodzinyprogramsity.repository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.models.Calendar;
import pl.narodzinyprogramsity.utils.CreateCalendar;
import pl.narodzinyprogramsity.utils.TextUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalendarRepositoryTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private CalendarRepository repository;
    private Calendar testCalendar;
    private List<Calendar> list;
    private CalendarRepository testRepository;

    @Before
    public void setUp() {
        repository = new CalendarRepository();
        testCalendar = CreateCalendar.getTestCalendar();

        testRepository = new CalendarRepository();
        testRepository.list.add(testCalendar);
        testRepository.list.add(Calendar.NOT_FOUND);
        testRepository.list.add(new Calendar());

    }

    @Test
    public void addTest() {
        String id = repository.add(testCalendar);

        assertThat(id).isEqualTo(testCalendar.getId());
    }

    @Test
    public void addNullObjTest() {
        thrown.expect(NullPointerException.class);
        repository.add(null);
    }

    @Test
    public void getTest() {
        Calendar calendar = testRepository.get("");
        Calendar calendar1 = testRepository.get(testCalendar.getId());
        
        assertThat(calendar).isNotNull();
        assertThat(calendar1).isEqualTo(testCalendar);
    }

    @Test
    public void getNullObjTest() {
        Calendar calendar = repository.get("test");

        assertThat(calendar).isNotNull().isEqualTo(Calendar.NOT_FOUND);
        assertThat(calendar.getServiceId()).isBlank();
    }

    @Test
    public void getByNullStringTest() {
        thrown.expect(NullPointerException.class);

        repository.get(null);
    }

    @Test
    public void getAllTest() {
        list = testRepository.getAll();

        assertThat(list.size()).isEqualTo(3);
        assertThat(list).isNotEmpty();
        assertThat(list.get(2)).isEqualTo(new Calendar());
    }

    @Test
    public void updateTest() {
        testCalendar.setId("test");

        Calendar testUpdateCalendar = testCalendar;
        testRepository.update(new Calendar(), testUpdateCalendar);

        Calendar calendar = testRepository.get(testUpdateCalendar.getId());
        assertThat(calendar).isEqualTo(testUpdateCalendar).isNotEqualTo(new Calendar());
    }

    @Test
    public void updateByNullObjTest() {
        thrown.expect(NullPointerException.class);

        testRepository.update(testCalendar, null);
    }

    @Test
    public void deleteByObjectTest() {
        testRepository.delete(new Calendar());

        List<Calendar> restOfElement = testRepository.getAll();

        assertThat(restOfElement.size()).isEqualTo(2);
    }

    @Test
    public void deleteByNullObjTest() {
        thrown.expect(NullPointerException.class);

        testRepository.delete((Calendar) null);
    }


    @Test
    public void deleteByStringTest() {
        testRepository.delete(testCalendar.getId());
        testRepository.delete(TextUtils.EMPTY_STRING);

        List<Calendar> restOfElement = testRepository.getAll();

        assertThat(restOfElement.size()).isEqualTo(1);
    }

    @Test
    public void deleteByNullStringTest() {
        thrown.expect(NullPointerException.class);

        testRepository.delete((String) null);
    }

    @Test
    public void deleteNotExistObjTest() {
        int startSize = testRepository.getAll().size();

        testRepository.delete("test");
        int endSize = testRepository.getAll().size();

        assertThat(startSize).isEqualTo(endSize).isEqualTo(3);
    }
}