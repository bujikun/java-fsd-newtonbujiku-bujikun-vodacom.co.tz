package tz.co.vodacom.bujikun.kitchenstories.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record CustomerDTO(
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        @JsonProperty("email") String email,
        @JsonProperty("account_number") String accountNumber
        ) { }
