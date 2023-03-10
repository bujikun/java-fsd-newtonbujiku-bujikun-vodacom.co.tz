package co.tz.vodacom.bujikun.flyaway.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "flights")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)//to prevent cyclic reference
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String code;
    private LocalDate date;
    private LocalTime departure;
    private LocalTime arrival;
    private Double price;
    @OneToOne
    @JoinColumn(name = "fk_airline_id")
    private Airline airline;
    @ManyToOne
    @JoinColumn(name = "fk_source_id")
    private Place placeSource;
    @ManyToOne
    @JoinColumn(name = "fk_dest_id")
    private Place placeDest;

    @Override
    public String toString() {
        return airline.getName() +
                " (" + code + ")" +
                " On: " + date +
                " From: " + placeSource +
                " To: " + placeDest;
    }
}