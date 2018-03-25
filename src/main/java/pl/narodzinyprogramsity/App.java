package pl.narodzinyprogramsity;

import pl.narodzinyprogramsity.controller.TripController;
import pl.narodzinyprogramsity.models.Agency;
import pl.narodzinyprogramsity.models.Rout;
import pl.narodzinyprogramsity.module.ParserModule;
import pl.narodzinyprogramsity.module.ReaderModule;
import pl.narodzinyprogramsity.module.RepositoryModule;
import pl.narodzinyprogramsity.module.ServiceModule;
import pl.narodzinyprogramsity.parsers.FeedParser;
import pl.narodzinyprogramsity.readers.FeedReader;
import pl.narodzinyprogramsity.repository.FeedRepository;
import pl.narodzinyprogramsity.service.TripAPI;
import pl.narodzinyprogramsity.view.SystemIOTripView;
import pl.narodzinyprogramsity.view.TripView;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        TripView view = new SystemIOTripView();

        TripAPI tripAPI = ServiceModule.getTripService();
        TripController controller = new TripController(tripAPI, view);

        view.setController(controller);
        view.loadPage();

    }
}
