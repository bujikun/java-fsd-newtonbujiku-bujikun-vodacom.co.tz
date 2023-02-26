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
@ToString
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
    private Integer sourceId;
    private Integer destinationId;
    private Double price;
    @OneToOne(mappedBy = "flight")
    private Booking booking;
    @ManyToOne
    @JoinColumn(name = "fk_source_id",insertable = false)
    private Place placeSource;
    @ManyToOne
    @JoinColumn(name = "fk_dest_id",insertable = false)
    private Place placeDest;
}