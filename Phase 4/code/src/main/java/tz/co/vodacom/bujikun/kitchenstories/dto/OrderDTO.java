package tz.co.vodacom.bujikun.kitchenstories.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import tz.co.vodacom.bujikun.kitchenstories.entity.Customer;
import tz.co.vodacom.bujikun.kitchenstories.entity.Order;
import tz.co.vodacom.bujikun.kitchenstories.util.DateUtil;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class OrderDTO {
        @JsonProperty("customer_name")
        private String customerName;
        @JsonProperty("order_number")
        private String orderNumber;
        @JsonProperty("customer")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private CustomerDTO customerDTO;
        @JsonProperty("customer_id")
        private Integer customerId;
        @JsonProperty("order_items")
        private List<OrderItemDTO> orderItemDTOs;
        @JsonProperty("total_price")
        private BigDecimal totalPrice;
        @JsonProperty("created_on")
        private String createdOn;
        public Order toOrder(){
                return Order.builder()
                        .orderNumber(orderNumber)
                        .orderItems(orderItemDTOs.stream()
                                .map(oid->oid.toOrderItem())
                                .toList()
                        )
                        .customerName(customerName)
                        .build();
        }

        public static OrderDTO fromOrder(Order order, DateUtil util){

                var dto =  OrderDTO.builder()
                        .orderNumber(order.getOrderNumber())
                        .customerId(order.getCustomerId())
                        //.customerDTO(CustomerDTO.fromCustomer(customer))
                        .orderItemDTOs(order.getOrderItems().stream()
                                .map(OrderItemDTO::fromOrderItem)
                                .toList()
                        )
                        .customerName(order.getCustomerName())
                        .createdOn(util.fromLocalDateTime(order.getCreatedOn()))
                        .build();
                var total = dto.orderItemDTOs.stream()
                        .map(orderItemDTO -> orderItemDTO.getTotalOrderItemPrice())
                        .reduce(BigDecimal.valueOf(0),(subtotal, current)->subtotal.add(current));
                dto.setTotalPrice(total);
                return dto;
        }

}
