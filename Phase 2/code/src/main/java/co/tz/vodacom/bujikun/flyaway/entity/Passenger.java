package co.tz.vodacom.bujikun.flyaway.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "passengers")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)//to prevent cyclic reference
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    @Column(unique = true)
    @OneToMany(mappedBy = "passenger")
    private List<Payment> payments;
    @OneToOne(mappedBy = "passenger")
    private Booking booking;
    @Override
    public String toString() {
        return firstName +
                " " + lastName +
                " DOB: " + dateOfBirth +
                " Address: " + address;
    }
}
