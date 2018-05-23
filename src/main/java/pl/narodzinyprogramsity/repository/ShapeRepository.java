package pl.narodzinyprogramsity.repository;

import pl.narodzinyprogramsity.models.Shape;

public class ShapeRepository extends BaseFeedRepository<Shape> {
    @Override
    public Shape get(String id) {
        Shape shape = super.get(id);
        if (shape != null) {
            return shape;
        }
        return Shape.NOT_FOUND;
    }
}
