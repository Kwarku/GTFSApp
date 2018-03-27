package pl.narodzinyprogramsity.parsers;

import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.models.Shape;

public class ShapeParser extends BaseFeedParser<Shape> {


    private static final int SHAPE_ID_COLUMN = 0;
    private static final int SHAPE_LAT_COLUMN = 1;
    private static final int SHAPE_LON_COLUMN = 2;
    private static final int SHAPE_PT_SEQUENCE_COLUMN = 3;

    private static final int NUMBER_OF_ELEMENTS = 4;

    public ShapeParser() {
        super(NUMBER_OF_ELEMENTS);
    }


    @Override
    public Shape parseTo(String line) throws NotCorrectLineException {
        super.parseTo(line);
        Shape shape = new Shape();
        shape.setId(splitFeedInfo[SHAPE_ID_COLUMN]);
        shape.setShapePtLat(splitFeedInfo[SHAPE_LAT_COLUMN]);
        shape.setShapePtLon(splitFeedInfo[SHAPE_LON_COLUMN]);
        shape.setShapePtSequence(splitFeedInfo[SHAPE_PT_SEQUENCE_COLUMN]);
        return shape;
    }
}
