package co.tz.vodacom.bujikun.flyaway.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "bookings")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)//to prevent cyclic reference
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String bookingNumber;
    @OneToOne
    @JoinColumn(name = "fk_passenger_id")
    private Passenger passenger;
    @OneToOne
    @JoinColumn(name = "fk_payment_id")
    private Payment payment;
    @OneToOne
    @JoinColumn(name = "fk_flight_id")
    private Flight flight;

}