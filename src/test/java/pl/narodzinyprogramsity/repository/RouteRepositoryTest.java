package pl.narodzinyprogramsity.repository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.models.Route;
import pl.narodzinyprogramsity.utils.CreateRoute;

import static org.assertj.core.api.Assertions.assertThat;

public class RouteRepositoryTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private Route route;
    private RouteRepository routeRepository;

    @Before
    public void setUp() {
        routeRepository = new RouteRepository();
        route = CreateRoute.getTestRoute();
    }

    @Test
    public void addTest() {
        String id = routeRepository.add(route);

        assertThat(route).isEqualTo(routeRepository.get(id));
    }

    @Test
    public void addNullTest() {
        thrown.expect(NullPointerException.class);

        routeRepository.add(null);
    }

    @Test
    public void getAllTest() {
        routeRepository.add(new Route());
        routeRepository.add(new Route());
        routeRepository.add(route);
        routeRepository.add(new Route());

        assertThat(routeRepository.getAll().size()).isEqualTo(4);
        assertThat(routeRepository.getAll().get(2)).isEqualTo(route);
    }

    @Test
    public void getNullObjTest() {
        routeRepository.add(new Route());
        routeRepository.add(new Route());
        routeRepository.add(new Route());
        routeRepository.add(new Route());

        assertThat(routeRepository.get("15")).isEqualTo(new Route()).isNotNull();
    }

    @Test
    public void updateTest() {

    }


}