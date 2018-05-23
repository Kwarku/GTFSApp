package pl.narodzinyprogramsity.view;

import pl.narodzinyprogramsity.controller.TripController;
import pl.narodzinyprogramsity.models.Trip;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SystemIOTripView implements TripView {
    private final Scanner scanner;
    private TripController tripController;


    public SystemIOTripView() {
        scanner = new Scanner(System.in);
    }


    @Override
    public void loadPage() {
        int choice;
        while (true) {
            printMenu();
            choice = scanner.nextInt();

            switch (MenuOption.getOption(choice)) {
                case LOAD:
                    loadTrips();
                    break;
                case SHOW_ALL:
                    showAllTrips();
                    break;
                case FIND_ROUT_BY_ID:
                    findTrip();
                    break;
                case EXIT:
                    closeProgram();
                    break;
                case OTHER:
                    otherOption();
                    break;
            }
        }

    }

    @Override
    public void setController(TripController tripController) {
        this.tripController = tripController;
    }

    private void printMenu() {
        System.out.printf("Choose number: \n" +
                        "%d - load page\n" +
                        "%d - show all trips\n" +
                        "%d - find some trip by rout number\n" +
                        "%d - exit program\n\n" +
                        "Enter your number : ",
                MenuOption.LOAD.getNumber(),
                MenuOption.SHOW_ALL.getNumber(),
                MenuOption.FIND_ROUT_BY_ID.getNumber(),
                MenuOption.EXIT.getNumber());
    }

    private void loadTrips(){
        try {
            tripController.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findTrip() {
        System.out.println("Enter interested you route");
        String routeId = scanner.next();

        displayTrips(tripController.findTripByRouteId(routeId));
    }

    private void showAllTrips() {
        displayTrips(tripController.getAllTrips());

    }


    private void displayTrips(List<Trip> trips) {
        trips.forEach(System.out::println);
    }

    private void closeProgram() {
        System.out.println("Have a nice day. Thanks for use this program");
        System.exit(0);

    }

    private void otherOption() {
        System.out.println("Sorry this option not exist");
    }
}
