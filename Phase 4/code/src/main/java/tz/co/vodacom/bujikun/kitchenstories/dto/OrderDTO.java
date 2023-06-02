package tz.co.vodacom.bujikun.kitchenstories.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import tz.co.vodacom.bujikun.kitchenstories.entity.Customer;
import tz.co.vodacom.bujikun.kitchenstories.entity.Order;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class OrderDTO {
        @JsonProperty("order_number")
        private String orderNumber;
        @JsonProperty("customer")
        private CustomerDTO customerDTO;
        @JsonProperty("customer_id")
        private Integer customerId;
        @JsonProperty("order_items")
        private List<OrderItemDTO> orderItemDTOs;
        @JsonProperty("total_price")
        private BigDecimal totalPrice;
        public Order toOrder(){
                return Order.builder()
                        .orderNumber(orderNumber)
                        .orderItems(orderItemDTOs.stream()
                                .map(oid->oid.toOrderItem())
                                .toList()
                        )
                        .build();
        }

        public static OrderDTO fromOrder(Order order){

                var dto =  OrderDTO.builder()
                        .orderNumber(order.getOrderNumber())
                        .customerId(order.getCustomerId())
                        //.customerDTO(CustomerDTO.fromCustomer(customer))
                        .orderItemDTOs(order.getOrderItems().stream()
                                .map(OrderItemDTO::fromOrderItem)
                                .toList()
                        )
                        .build();
                var total = dto.orderItemDTOs.stream()
                        .map(orderItemDTO -> orderItemDTO.getTotalOrderItemPrice())
                        .reduce(BigDecimal.valueOf(0),(subtotal, current)->subtotal.add(current));
                dto.setTotalPrice(total);
                return dto;
        }

}
