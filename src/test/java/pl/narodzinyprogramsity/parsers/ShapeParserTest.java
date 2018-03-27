package pl.narodzinyprogramsity.parsers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.models.Shape;
import pl.narodzinyprogramsity.utils.CreateShape;

import static org.assertj.core.api.Assertions.assertThat;

public class ShapeParserTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Shape testShape;
    private ShapeParser parser;

    @Before
    public void setUp() {
        testShape = CreateShape.createTestShape();
        parser = new ShapeParser();
    }

    @Test
    public void parseLineTest() throws NotCorrectLineException {
        Shape shape = parser.parseTo("1,53.456420,14.505499,1");

        assertThat(shape).isEqualTo(testShape);
    }

    @Test
    public void parseBrokenLineTest() throws NotCorrectLineException {
        thrown.expect(NotCorrectLineException.class);

        parser.parseTo("1,53.456420,14.505499");
        parser.parseTo("1,53.456420,1");
        parser.parseTo("");
        parser.parseTo("1,,1");
    }

    @Test
    public void parseEmptyLineTest() throws NotCorrectLineException {
        Shape shape = parser.parseTo(",,,");

        assertThat(shape.getId()).isBlank();
        assertThat(shape.getShapePtLat()).isBlank();
        assertThat(shape.getShapePtLon()).isBlank();
        assertThat(shape.getShapePtSequence()).isBlank();
        assertThat(shape).isNotNull();
    }
}

