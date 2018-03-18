package pl.narodzinyprogramsity.repository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.models.Rout;
import pl.narodzinyprogramsity.utils.CreateRoute;

import static org.assertj.core.api.Assertions.assertThat;

public class RoutRepositoryTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private Rout rout;
    private RoutRepository routRepository;

    @Before
    public void setUp() {
        routRepository = new RoutRepository();
        rout = CreateRoute.getTestRoute();
    }

    @Test
    public void addTest() {
        String id = routRepository.add(rout);

        assertThat(rout).isEqualTo(routRepository.get(id));
    }

    @Test
    public void addNullTest() {
        thrown.expect(NullPointerException.class);

        routRepository.add(null);
    }

    @Test
    public void getAllTest() {
        routRepository.add(new Rout());
        routRepository.add(new Rout());
        routRepository.add(rout);
        routRepository.add(new Rout());

        assertThat(routRepository.getAll().size()).isEqualTo(4);
        assertThat(routRepository.getAll().get(2)).isEqualTo(rout);
    }

    @Test
    public void getNullObjTest() {
        routRepository.add(new Rout());
        routRepository.add(new Rout());
        routRepository.add(new Rout());
        routRepository.add(new Rout());

        assertThat(routRepository.get("15")).isEqualTo(new Rout()).isNotNull();
    }

    @Test
    public void updateTest() {

    }


}