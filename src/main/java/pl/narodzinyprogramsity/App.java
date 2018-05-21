package pl.narodzinyprogramsity;

import pl.narodzinyprogramsity.controller.TripController;
import pl.narodzinyprogramsity.dbService.HibernateService;
import pl.narodzinyprogramsity.dbService.MySQLService;
import pl.narodzinyprogramsity.module.ServiceModule;
import pl.narodzinyprogramsity.service.TripAPI;
import pl.narodzinyprogramsity.view.SystemIOTripView;
import pl.narodzinyprogramsity.view.TripView;

public class App {
    public static void main(String[] args) {
        HibernateService service = new MySQLService();
        service.connect("hibernate.cfg.xml");

//        TripView view = new SystemIOTripView();
//
//        TripAPI tripAPI = ServiceModule.getTripService();
//        TripController controller = new TripController(tripAPI, view);
//
//        view.setController(controller);
//        view.loadPage();


        service.disconnect();
    }
}
