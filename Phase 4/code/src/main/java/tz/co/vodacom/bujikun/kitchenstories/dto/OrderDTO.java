package tz.co.vodacom.bujikun.kitchenstories.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record OrderDTO (
        @JsonProperty("order_number") String orderNumber,
        @JsonProperty("customer") CustomerDTO customer,

        @JsonProperty("order_items") List<OrderItemDTO> orderItems



        ) {

}
