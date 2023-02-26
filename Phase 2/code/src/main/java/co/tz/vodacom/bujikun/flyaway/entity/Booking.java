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
    private Integer passengerId;
    private Integer flightId;
    private Integer paymentId;
    private String bookingNumber;
    @OneToOne
    @JoinColumn (insertable = false)
    private Passenger passenger;
    @OneToOne
    @JoinColumn(insertable = false)
    private Payment payment;
    @OneToOne
    @JoinColumn(insertable = false)
    private Flight flight;

}