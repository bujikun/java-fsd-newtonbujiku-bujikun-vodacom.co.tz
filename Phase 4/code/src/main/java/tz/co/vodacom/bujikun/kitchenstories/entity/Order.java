package tz.co.vodacom.bujikun.kitchenstories.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "orders")
public class Order {
    @Id
    private Integer id;
    @Column("order_number")
    private String orderNumber;
    @Transient
    private BigDecimal totalPrice;
    @MappedCollection(idColumn = "fk_order_id",keyColumn = "id")
    private List<OrderItem> orderItems;
    @Column("version")
    private Integer version;
    @Column("created_on")
    @CreatedDate
    private LocalDateTime createdOn;
    @Column("updated_on")
    @LastModifiedDate
    private LocalDateTime updatedOn;
}
