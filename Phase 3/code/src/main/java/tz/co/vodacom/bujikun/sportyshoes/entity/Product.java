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
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "products")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private BigDecimal price;
    private String description;
    private String imageUrl;
    @Transient
    private String categoryString;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "products_categories",joinColumns = {@JoinColumn(name = "fk_product_id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "fk_category_id",referencedColumnName = "id")})
    private Set<Category> categories;
    @CreationTimestamp
    @DateTimeFormat(pattern = "dd - MM - yyyy HH:mm:ss")
    private LocalDateTime createdOn;
    @UpdateTimestamp
    @DateTimeFormat(pattern = "dd - MM - yyyy HH:mm:ss")
    private LocalDateTime updatedOn;
    private Integer count;
}
