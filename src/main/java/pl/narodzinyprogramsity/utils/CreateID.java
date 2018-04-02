package pl.narodzinyprogramsity.utils;

public class CreateID {
    private static int id = 0;

    public static String createId(){
        id++;
        return "randomId" + id;
    }
}
