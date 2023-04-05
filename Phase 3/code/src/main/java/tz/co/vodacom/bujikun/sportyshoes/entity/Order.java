package tz.co.vodacom.bujikun.sportyshoes.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")//prevents circular reference
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "orders_items",
            joinColumns = {@JoinColumn(name = "fk_order_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "fk_item_id", referencedColumnName = "id")}
    )
    private Set<OrderItem> orderItems;
    @ManyToOne
    @JoinColumn(name = "fk_user_id", referencedColumnName = "id")
    private User user;
    @Transient
    private BigDecimal totalPrice;
    @CreationTimestamp
    private LocalDateTime createdOn;

    public BigDecimal getTotalPrice() {
        return  this.getOrderItems().stream()
                .map(i->i.getTotalLinePrice())
                .reduce(new BigDecimal(0),(current, subtotal)->
                        subtotal.add(current));
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = getTotalPrice();
    }
}
