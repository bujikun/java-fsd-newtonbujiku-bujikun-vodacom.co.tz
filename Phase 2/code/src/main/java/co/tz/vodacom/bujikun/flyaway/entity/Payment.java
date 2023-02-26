package co.tz.vodacom.bujikun.flyaway.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.awt.print.Book;

@AllArgsConstructor
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
    private Integer passengerId;
    @ManyToOne
    @JoinColumn(insertable = false)
    private Passenger passenger;
    @OneToOne(mappedBy = "payment")
    private Booking booking;
}

