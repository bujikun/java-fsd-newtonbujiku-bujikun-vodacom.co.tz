package tz.co.vodacom.bujikun.kitchenstories.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tz.co.vodacom.bujikun.kitchenstories.dto.OrderDTO;
import tz.co.vodacom.bujikun.kitchenstories.entity.Food;
import tz.co.vodacom.bujikun.kitchenstories.entity.Order;
import tz.co.vodacom.bujikun.kitchenstories.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
//    @GetMapping
//    public ResponseEntity<List<Food>> findAll(){
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(orderService.findAll());
//    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody OrderDTO orderDTO){
        //orderService.save(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Order Successfully Created!");
    }

}
