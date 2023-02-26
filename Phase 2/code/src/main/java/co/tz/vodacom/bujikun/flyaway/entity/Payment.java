package co.tz.vodacom.bujikun.flyaway.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.awt.print.Book;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "payments")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)//to prevent cyclic reference
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private Double amount;
    @Column(unique = true)
    private String codename;
    @ManyToOne
    @JoinColumn(name = "fk_passenger_id")
    private Passenger passenger;
    @OneToOne(mappedBy = "payment")
    private Booking booking;
}

