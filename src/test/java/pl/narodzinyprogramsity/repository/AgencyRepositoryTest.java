package pl.narodzinyprogramsity.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.models.Agency;
import pl.narodzinyprogramsity.utils.CreateAgency;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AgencyRepositoryTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Agency testAgency;
    private AgencyRepository emptyRepository;
    private AgencyRepository testRepository;

    private int startSize;
    private int endSize;

    private List<Agency> result;

    @Before
    public void setUp() {
        testAgency = CreateAgency.getTestAgency();

        emptyRepository = new AgencyRepository();
        testRepository = new AgencyRepository();
        testRepository.list.add(CreateAgency.getTestAgency());

        startSize = Integer.MIN_VALUE;
        endSize = Integer.MIN_VALUE;

        result = new ArrayList<>();
    }

    @After
    public void tearDown() {
        result.clear();
    }

    @Test
    public void addTest() {
        startSize = emptyRepository.list.size();

        emptyRepository.add(testAgency);
        endSize = emptyRepository.list.size();

        assertThat(startSize).isLessThan(endSize).isEqualTo(0);
        assertThat(endSize).isEqualTo(1);
    }

    @Test
    public void addNullObjTest() {
        thrown.expect(NullPointerException.class);

        emptyRepository.add(null);
    }

    @Test
    public void getTest() {
        String id = testAgency.getId();

        Agency agency = testRepository.get(id);

        assertThat(agency).isEqualTo(testAgency);
    }

    @Test
    public void getNoExistTest() {
        String id = "no exist id";

        Agency agency = testRepository.get(id);

        assertThat(agency).isEqualTo(Agency.NOT_FOUND);
    }

    @Test
    public void getByNullIDTest() {
        thrown.expect(NullPointerException.class);

        testRepository.get(null);
    }

    @Test
    public void getAll() {
        startSize = testRepository.list.size();

        result = testRepository.getAll();
        endSize = result.size();

        assertThat(startSize).isEqualTo(endSize).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo(testAgency);

    }

    @Test
    public void updateTest() {
        Agency agency = Agency.NOT_FOUND;
        startSize = testRepository.list.size();

        testRepository.update(testAgency, agency);
        Agency testAgency = testRepository.get(agency.getId());
        endSize = testRepository.list.size();

        assertThat(testAgency).isEqualTo(agency);
        assertThat(startSize).isEqualTo(endSize).isEqualTo(1);
    }

    @Test
    public void updateUsingNullObjTest() {
        thrown.expect(NullPointerException.class);

        testRepository.update(testAgency, null);
    }

    @Test
    public void updateNoExistObj() {
        Agency agency = Agency.NOT_FOUND;

        testRepository.update(agency, agency);
        Agency testAgency = testRepository.getAll().get(0);

        assertThat(testAgency).isNotEqualTo(agency);
    }

    @Test
    public void deleteByObjTest() {
        startSize = testRepository.list.size();

        testRepository.delete(testAgency);
        endSize = testRepository.list.size();

        assertThat(startSize).isGreaterThan(endSize).isEqualTo(1);
        assertThat(endSize).isLessThan(startSize).isEqualTo(0);
    }

    @Test
    public void deleteByStringTest() {
        startSize = testRepository.list.size();

        testRepository.delete(testAgency.getId());
        endSize = testRepository.list.size();

        assertThat(startSize).isGreaterThan(endSize).isEqualTo(1);
        assertThat(endSize).isLessThan(startSize).isEqualTo(0);

    }

    @Test
    public void deleteNoExistObjTest() {
        startSize = emptyRepository.list.size();

        emptyRepository.delete(testAgency);
        endSize = emptyRepository.list.size();

        assertThat(startSize).isEqualTo(endSize).isEqualTo(0);

    }

    @Test
    public void deleteByNullTest() {
        thrown.expect(NullPointerException.class);

        testRepository.delete((String) null);
        testRepository.delete((Agency) null);
    }
}