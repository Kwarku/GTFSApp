package pl.narodzinyprogramsity.utils;

import pl.narodzinyprogramsity.models.Agency;

public class CreateAgency {
    public static Agency getTestAgency(){
        return  new Agency("ZDiTM Szczecin", "http://www.zditm.szczecin.pl", "Europe/Warsaw", "pl", "91 480 04 03");
    }
}
