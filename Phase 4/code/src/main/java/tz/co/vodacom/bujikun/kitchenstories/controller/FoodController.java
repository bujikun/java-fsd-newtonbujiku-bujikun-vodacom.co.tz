package tz.co.vodacom.bujikun.kitchenstories.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tz.co.vodacom.bujikun.kitchenstories.dto.FoodDTO;
import tz.co.vodacom.bujikun.kitchenstories.entity.Food;
import tz.co.vodacom.bujikun.kitchenstories.service.FoodService;
import tz.co.vodacom.bujikun.kitchenstories.util.DateUtil;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;
    private final DateUtil dateUtil;
    @GetMapping
    public ResponseEntity<List<FoodDTO>> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(foodService.findAll().stream().map(f->FoodDTO.fromFood(f,dateUtil)).toList());
    }

    @GetMapping("/search")
    public ResponseEntity<List<FoodDTO>> findAllByName(@RequestParam("name") String name){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(foodService.searchByName(name).stream().map(f->FoodDTO.fromFood(f,dateUtil)).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Food> findById(@PathVariable("id") Integer id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(foodService.findById(id));
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody FoodDTO foodDTO){
        foodService.save(foodDTO.toFood(dateUtil));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Food Item Added");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        foodService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Food Item Deleted");
    }

}
