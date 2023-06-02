package tz.co.vodacom.bujikun.kitchenstories.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record OrderItemDTO(
        @JsonProperty("food_name") String foodName,
        @JsonProperty("unit_price") BigDecimal unitPrice,
        @JsonProperty("quantity") Integer quantity

) { }
