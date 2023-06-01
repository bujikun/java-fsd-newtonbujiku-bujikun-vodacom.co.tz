package tz.co.vodacom.bujikun.kitchenstories.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tz.co.vodacom.bujikun.kitchenstories.entity.Food;
import tz.co.vodacom.bujikun.kitchenstories.service.FoodService;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;
    @GetMapping
    public ResponseEntity<List<Food>> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(foodService.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Food>> findAllByName(@RequestParam("name") String name){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(foodService.searchByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity <Food> findById(@PathVariable("id") Integer id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(foodService.findById(id));
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Food food){
        foodService.save(food);
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
