package co.tz.vodacom.bujikun.flyaway.config;

import co.tz.vodacom.bujikun.flyaway.entity.*;
import co.tz.vodacom.bujikun.flyaway.service.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class DataInit {
    private static final List<Airline> AIRLINES;
    private static final List<Passenger> PASSENGERS;
    private static final List<Place> PLACES;
    private static final List<Flight> FLIGHTS;

    static {
        AIRLINES = getAirlineList();
        PASSENGERS = getPassengers();
        PLACES = getPlaces();
        FLIGHTS = getFlights();
    }

    public static void populateDatabase() {
        var as = new AirlineService();
        var pas = new PassengerService();
        var plc = new PlaceService();
        var fl = new FlightService();


        AIRLINES.forEach(a -> as.create(a));
        PASSENGERS.forEach(p -> pas.create(p));
        PLACES.forEach(p -> plc.create(p));
        FLIGHTS.forEach(f -> fl.create(f));
        new UserService().create(User.builder().username("admin")
                .password(BCrypt.hashpw("password", BCrypt.gensalt(10)))
                .role("admin").build());

    }

    private static List<Flight> getFlights() {
        return List.of(
                Flight.builder().code("AC23").date(LocalDate.now()).departure(LocalTime.now())
                        .arrival(LocalTime.now().plusHours(6)).placeSource(PLACES.get(1)).placeDest(PLACES.get(3))
                        .price(500.99).airline(AIRLINES.get(0)).build(),
                Flight.builder().code("AF45").date(LocalDate.now()).departure(LocalTime.now())
                        .arrival(LocalTime.now().plusHours(4)).placeSource(PLACES.get(3)).placeDest(PLACES.get(6))
                        .price(499.99).airline(AIRLINES.get(1)).build(),
                Flight.builder().code("AI98").date(LocalDate.now()).departure(LocalTime.now())
                        .arrival(LocalTime.now().plusHours(8)).placeSource(PLACES.get(7)).placeDest(PLACES.get(2))
                        .price(800.59).airline(AIRLINES.get(3)).build()
        );
    }

    private static List<Place> getPlaces() {
        return List.of(
                Place.builder().name("Madrid").build(),
                Place.builder().name("London").build(),
                Place.builder().name("Tokyo").build(),
                Place.builder().name("Toronto").build(),
                Place.builder().name("New York").build(),
                Place.builder().name("Paris").build(),
                Place.builder().name("Lisbon").build(),
                Place.builder().name("New Delhi").build()
        );
    }

    private static List<Passenger> getPassengers() {
        return List.of(
                Passenger.builder().firstName("Newton").lastName("Bujiku").address("Dar Es Salaam")
                        .dateOfBirth(LocalDate.of(2000, 02, 23)).build(),
                Passenger.builder().firstName("Gotti").lastName("John").address("New York")
                        .dateOfBirth(LocalDate.of(1976, 01, 20)).build()
        );
    }

    private static List<Airline> getAirlineList() {
        return List.of(
                Airline.builder().name("Air Canada").codename("AC").build(),
                Airline.builder().name("Air France").codename("AF").build(),
                Airline.builder().name("Egyptair").codename("MS").build(),
                Airline.builder().name("Air India").codename("AI").build(),
                Airline.builder().name("Japan Airlines").codename("JL").build()
        );
    }
}
