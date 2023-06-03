package tz.co.vodacom.bujikun.kitchenstories.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import tz.co.vodacom.bujikun.kitchenstories.entity.Customer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CustomerDTO {

        @JsonProperty("first_name")
        private  String firstName;
        @JsonProperty("last_name")
        private String lastName;
        @JsonProperty("email")
        private String email;
        @JsonProperty("account_number")
        private String accountNumber;

        public Customer toCustomer(){
                return Customer.builder()
                        .firstName(firstName)
                        .lastName(lastName)
                        .email(email)
                        .accountNumber(accountNumber)
                        .createdOn(LocalDateTime.now())
                        .build();
        }

        public static CustomerDTO fromCustomer(Customer customer){
               return CustomerDTO.builder()
                       .firstName(customer.getFirstName())
                       .lastName(customer.getLastName())
                       .email(customer.getEmail())
                       .accountNumber(customer.getAccountNumber())
                       .build();
        }
}
