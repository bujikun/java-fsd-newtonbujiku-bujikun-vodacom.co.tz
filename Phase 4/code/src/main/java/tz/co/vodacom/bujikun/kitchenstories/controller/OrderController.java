package tz.co.vodacom.bujikun.kitchenstories.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tz.co.vodacom.bujikun.kitchenstories.dto.OrderDTO;
import tz.co.vodacom.bujikun.kitchenstories.entity.Customer;
import tz.co.vodacom.bujikun.kitchenstories.entity.Food;
import tz.co.vodacom.bujikun.kitchenstories.entity.Order;
import tz.co.vodacom.bujikun.kitchenstories.service.CustomerService;
import tz.co.vodacom.bujikun.kitchenstories.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @GetMapping
    @PreAuthorize("hasAuthority('order:read:all')")
    public ResponseEntity<List<OrderDTO>> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody OrderDTO orderDTO){
        orderService.save(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Order Successfully Created!");
    }
}
