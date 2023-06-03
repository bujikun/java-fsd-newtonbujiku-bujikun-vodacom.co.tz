package tz.co.vodacom.bujikun.kitchenstories.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import tz.co.vodacom.bujikun.kitchenstories.entity.OrderItem;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class OrderItemDTO {
    @JsonProperty("food_name")
    private String foodName;
    @JsonProperty("unit_price")
    private BigDecimal unitPrice;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonIgnore
    private BigDecimal totalOrderItemPrice;
    public OrderItem toOrderItem(){
        return OrderItem.builder()
                .foodName(foodName)
                .unitPrice(unitPrice)
                .quantity(quantity)
                .build();
    }

    public static OrderItemDTO fromOrderItem(OrderItem orderItem){
        return OrderItemDTO.builder()
                .foodName(orderItem.getFoodName())
                .quantity(orderItem.getQuantity())
                .unitPrice(orderItem.getUnitPrice())
                .totalOrderItemPrice(orderItem.getUnitPrice().multiply(new BigDecimal(orderItem.getQuantity())))
                .build();
    }
}
