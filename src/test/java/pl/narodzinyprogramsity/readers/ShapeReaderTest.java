package pl.narodzinyprogramsity.readers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import pl.narodzinyprogramsity.models.Shape;
import pl.narodzinyprogramsity.parsers.ShapeParser;
import pl.narodzinyprogramsity.repository.ShapeRepository;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ShapeReaderTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private ShapeReader spyReader;
    private ShapeRepository repository;

    @Before
    public void setUp() {
        repository = new ShapeRepository();

        spyReader = Mockito.spy(new ShapeReader(repository, new ShapeParser()));
        when(spyReader.getFileDir()).thenReturn("./test-resources/test-shapes.txt");
    }

    @Test
    public void readTest() throws IOException {
        spyReader.read();

        List<Shape> shapeList = repository.getAll();

        assertThat(shapeList).isNotEmpty();
        assertThat(shapeList.size()).isEqualTo(10);
        assertThat(shapeList.get(1)).isInstanceOf(Shape.class);
    }

    @Test
    public void wrongDirFileTest() throws IOException {
        when(spyReader.getFileDir()).thenReturn("wrong dir file test");

        thrown.expect(IOException.class);

        spyReader.read();
    }
}