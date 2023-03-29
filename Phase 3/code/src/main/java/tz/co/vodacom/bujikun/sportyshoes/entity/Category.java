package tz.co.vodacom.bujikun.sportyshoes.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "categories")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER)
    private Set<Product> products;
    @CreationTimestamp
    @DateTimeFormat(pattern = "dd - MM - yyyy HH:mm:ss")
    private LocalDateTime createdOn;
    @UpdateTimestamp
    @DateTimeFormat(pattern = "dd - MM - yyyy HH:mm:ss")
    private LocalDateTime updatedOn;

}
