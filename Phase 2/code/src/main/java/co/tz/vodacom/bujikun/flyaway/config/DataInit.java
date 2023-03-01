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
        var payment = new PaymentService().createAndGet(Payment.builder().amount(387.99).codename("45FEDDRTZ").passenger(PASSENGERS.get(0)).build());
        new BookingService().create(Booking.builder().bookingNumber("ABD242SR").flight(FLIGHTS.get(0))
                .passenger(PASSENGERS.get(0)).payment(payment).build());

    }

    private static List<Flight> getFlights() {
        return List.of(
                Flight.builder().code("AC23").date(LocalDate.now()).departure(LocalTime.now())
                        .arrival(LocalTime.now().plusHours(6)).placeSource(PLACES.get(0)).placeDest(PLACES.get(1))
                        .price(500.99).airline(AIRLINES.get(0)).build()
        );
    }

    private static List<Place> getPlaces() {
        return List.of(
                Place.builder().name("Madrid").build(),
                Place.builder().name("London").build()
        );
    }

    private static List<Passenger> getPassengers() {
        return List.of(
                Passenger.builder().firstName("Newton").lastName("Bujiku").address("Dar Es Salaam")
                        .dateOfBirth(LocalDate.of(2000, 02, 23)).build()
        );
    }

    private static List<Airline> getAirlineList() {
        return List.of(
                Airline.builder().name("Air Canada").codename("AC").build()
        );
    }
}
