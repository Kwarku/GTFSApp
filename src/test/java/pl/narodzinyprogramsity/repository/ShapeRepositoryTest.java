package pl.narodzinyprogramsity.repository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.models.Shape;
import pl.narodzinyprogramsity.utils.CreateShape;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShapeRepositoryTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private int startListSize;
    private int endListSize;

    private Shape shape1;
    private Shape shape2;
    private Shape shape3;

    private ShapeRepository emptyRepository;
    private ShapeRepository testRepository;

    private List<Shape> results;

    @Before
    public void setUp() {
        startListSize = Integer.MIN_VALUE;
        endListSize = Integer.MIN_VALUE;

        shape1 = CreateShape.createTestShape1();
        shape2 = CreateShape.createTestShape2();
        shape3 = CreateShape.createTestShape3();

        emptyRepository = new ShapeRepository();

        testRepository = new ShapeRepository();
        testRepository.list.add(shape1);
        testRepository.list.add(shape2);
        testRepository.list.add(shape3);

        results = new ArrayList<>();
        results.clear();
    }

    @Test
    public void addTest() {
        startListSize = emptyRepository.getAll().size();

        emptyRepository.add(CreateShape.createOriginalShape());
        endListSize = emptyRepository.list.size();

        assertThat(emptyRepository.getAll().size()).isEqualTo(endListSize).isGreaterThan(startListSize);
    }

    @Test
    public void addNullObjTest() {
        thrown.expect(NullPointerException.class);

        emptyRepository.add(null);
    }

    @Test
    public void getTest() {
        Shape shape = testRepository.get(shape2.getId());

        assertThat(shape).isEqualTo(shape2);
    }

    @Test
    public void getNoExistObjTest() {
        Shape shape = testRepository.get("testID");

        assertThat(shape).isEqualTo(Shape.NOT_FOUND);
    }

    @Test
    public void getByNullStringTest() {
        thrown.expect(NullPointerException.class);

        testRepository.get(null);
    }

    @Test
    public void getAllTest() {
        int size = testRepository.getAll().size();
        results = testRepository.getAll();

        assertThat(size).isEqualTo(3);
        assertThat(results.get(1)).isEqualTo(shape2);
    }

    @Test
    public void updateTest() {
        Shape shape4 = CreateShape.createTestShape4();

        testRepository.update(shape1, shape4);
        results = testRepository.list;

        assertThat(results.get(0)).isEqualTo(shape4);
        assertThat(results.get(1)).isEqualTo(shape2);
        assertThat(results.get(2)).isEqualTo(shape3);
    }

    @Test
    public void updateObjUsingNullObjTest() {
        thrown.expect(NullPointerException.class);

        testRepository.update(shape2, null);
    }

    @Test
    public void updateNotExistObj() {
        Shape shape = new Shape("1", "2", "3", "1");
        testRepository.update(shape, new Shape());

        results = testRepository.list;
        assertThat(results.size()).isEqualTo(3);
        assertThat(results.get(0)).isEqualTo(shape1);
        assertThat(results.get(1)).isEqualTo(shape2);
        assertThat(results.get(2)).isEqualTo(shape3);
    }

    @Test
    public void deleteByObjTest() {
        startListSize = testRepository.getAll().size();

        testRepository.delete(shape1);
        testRepository.delete(shape2);
        endListSize = testRepository.getAll().size();

        assertThat(startListSize).isEqualTo(3).isGreaterThan(endListSize);
        assertThat(endListSize).isEqualTo(1);
    }

    @Test
    public void deleteNoExistObjByObjTest() {
        Shape shape = Shape.NOT_FOUND;
        startListSize = testRepository.getAll().size();

        testRepository.delete(shape);

        assertThat(testRepository.getAll().size()).isEqualTo(startListSize);
    }

    @Test
    public void deleteByUseNullObjTest() {
        thrown.expect(NullPointerException.class);

        testRepository.delete((Shape) null);
    }

    @Test
    public void deleteByStringTest() {
        startListSize = testRepository.getAll().size();

        testRepository.delete(shape1.getId());
        testRepository.delete(shape3.getId());
        endListSize = testRepository.getAll().size();

        assertThat(startListSize).isEqualTo(3).isGreaterThan(endListSize);
        assertThat(endListSize).isEqualTo(1);
    }

    @Test
    public void deleteByNullStringTest() {
        thrown.expect(NullPointerException.class);

        testRepository.delete((String) null);
    }

    @Test
    public void deleteNotExistObjByStringTest() {
        int startSize = testRepository.getAll().size();

        testRepository.delete("test");
        int endSize = testRepository.getAll().size();

        assertThat(startSize).isEqualTo(endSize);
    }
}