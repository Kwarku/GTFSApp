package pl.narodzinyprogramsity.utils;

import pl.narodzinyprogramsity.models.Shape;

public class CreateShape {
    public static Shape createOriginalShape() {
        return new Shape("1", "53.456420", "14.505499", "1");
    }

    public static Shape createTestShape1() {
        return new Shape("test1ID", "test1LAT", "test1LON", "test1");
    }
    public static Shape createTestShape2() {
        return new Shape("test2ID", "test2LAT", "test2LON", "test2");
    }
    public static Shape createTestShape3() {
        return new Shape("test3ID", "test3LAT", "test3LON", "test3");
    }
    public static Shape createTestShape4() {
        return new Shape("test4ID", "test4LAT", "test4LON", "test4");
    }

}
