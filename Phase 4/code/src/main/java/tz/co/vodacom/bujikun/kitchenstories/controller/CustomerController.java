package tz.co.vodacom.bujikun.kitchenstories.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tz.co.vodacom.bujikun.kitchenstories.dto.CustomerDTO;
import tz.co.vodacom.bujikun.kitchenstories.dto.OrderDTO;
import tz.co.vodacom.bujikun.kitchenstories.service.CustomerService;
import tz.co.vodacom.bujikun.kitchenstories.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerService.findAll().stream().map(CustomerDTO::fromCustomer).toList());
    }

}
