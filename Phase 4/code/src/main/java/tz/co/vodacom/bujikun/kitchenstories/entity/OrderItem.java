package tz.co.vodacom.bujikun.kitchenstories.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "order_items")
public class OrderItem {
    @Id
    private Integer id;
    @Column("food_name")
    private String foodName;
    @Column("unit_price")
    private BigDecimal unitPrice;
    @Column("quantity")
    private Integer quantity;
    @Transient
    private BigDecimal totalOrderItemPrice;
    @Column("created_on")
    @CreatedDate
    private LocalDateTime createdOn;
    @Column("updated_on")
    @LastModifiedDate
    private LocalDateTime updatedOn;
}
