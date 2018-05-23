package pl.narodzinyprogramsity.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.models.Route;
import pl.narodzinyprogramsity.utils.CreateRoute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RouteRepositoryTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Route testRoute;
    private Route route1;
    private Route route2;
    private Route route3;
    private Route noAddToRepositoryRoute;

    private RouteRepository emptyRepository;
    private RouteRepository testRepository;

    private int startSize;
    private int endSize;

    private List<Route> result;



    @Before
    public void setUp() {
        testRoute = CreateRoute.getOriginalRoute();
        route1 = CreateRoute.testRoute1();
        route2 = CreateRoute.testRoute2();
        route3 = CreateRoute.testRoute3();
        noAddToRepositoryRoute = CreateRoute.testRoute4();

        emptyRepository = new RouteRepository();
        testRepository = new RouteRepository();

        testRepository.list.addAll(Arrays.asList(route1, route2, route3));

        result = new ArrayList<>();
    }

    @After
    public void tearDown() {
        result.clear();
    }

    @Test
    public void addTest() {
        startSize = emptyRepository.list.size();

        String id1 = emptyRepository.add(testRoute);
        String id2 = emptyRepository.add(route1);
        endSize = emptyRepository.list.size();

        assertThat(id1).isEqualTo(testRoute.getId());
        assertThat(id2).isEqualTo(route1.getId());
        assertThat(startSize).isLessThan(endSize).isEqualTo(0);
        assertThat(endSize).isEqualTo(2);
    }

    @Test
    public void addNullTest() {
        thrown.expect(NullPointerException.class);

        emptyRepository.add(null);
    }

    @Test
    public void getTest() {
        String id = route3.getId();

        Route getRoute = testRepository.get(id);

        assertThat(getRoute).isEqualTo(route3);
    }

    @Test
    public void getNoExistObjTest() {
        String id = "no exist id";

        Route noExistRoute = testRepository.get(id);

        assertThat(noExistRoute).isEqualTo(Route.NOT_FOUND);
    }

    @Test
    public void getByNullTest() {
        thrown.expect(NullPointerException.class);

        testRepository.get(null);
        emptyRepository.get(null);
    }

    @Test
    public void getAllTest() {
        startSize = testRepository.list.size();

        result = testRepository.getAll();
        endSize = result.size();

        assertThat(result.get(1)).isInstanceOf(Route.class);
        assertThat(startSize).isEqualTo(endSize).isEqualTo(3);
    }

    @Test
    public void updateTest() {
        testRepository.update(route3, noAddToRepositoryRoute);

        Route routeAfterUpdate = testRepository.get(noAddToRepositoryRoute.getId());

        assertThat(routeAfterUpdate).isEqualTo(noAddToRepositoryRoute);
    }

    @Test
    public void updateNoExistObjTest() {
        startSize = testRepository.list.size();

        testRepository.update(noAddToRepositoryRoute, testRoute);
        Route afterUpdate = testRepository.get(noAddToRepositoryRoute.getId());
        endSize = testRepository.list.size();

        assertThat(afterUpdate).isNotEqualTo(testRoute).isEqualTo(Route.NOT_FOUND);
        assertThat(startSize).isEqualTo(endSize);
    }

    @Test
    public void updateByNullObjTest() {
        thrown.expect(NullPointerException.class);

        testRepository.update(testRoute, null);
    }

    @Test
    public void deleteByObjTest() {
        startSize = testRepository.list.size();

        testRepository.delete(route2);
        testRepository.delete(route3);
        endSize = testRepository.list.size();

        assertThat(startSize).isGreaterThan(endSize).isEqualTo(3);
        assertThat(endSize).isLessThan(startSize).isEqualTo(1);
        assertThat(testRepository.get(route3.getId())).isEqualTo(Route.NOT_FOUND);
    }

    @Test
    public void deleteByStringTest() {
        startSize = testRepository.list.size();

        testRepository.delete(route1.getId());
        testRepository.delete(route2.getId());
        testRepository.delete(route3.getId());
        endSize = testRepository.list.size();
        result = testRepository.getAll();

        assertThat(startSize).isGreaterThan(endSize).isEqualTo(3);
        assertThat(endSize).isLessThan(startSize).isEqualTo(0);
        assertThat(result).isEmpty();
    }

    @Test
    public void deleteNoExistObjTest() {
        startSize = testRepository.list.size();

        testRepository.delete("no exist obj");
        testRepository.delete(testRoute);
        endSize = testRepository.list.size();

        assertThat(startSize).isEqualTo(endSize).isEqualTo(3);
    }

    @Test
    public void deleteByNullTest() {
        thrown.expect(NullPointerException.class);

        testRepository.delete((String) null);
        testRepository.delete((Route) null);
    }
}