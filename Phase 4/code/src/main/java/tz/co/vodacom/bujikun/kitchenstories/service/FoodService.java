package tz.co.vodacom.bujikun.kitchenstories.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.kitchenstories.entity.Food;
import tz.co.vodacom.bujikun.kitchenstories.repository.FoodRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    public void save(Food food){
        foodRepository.save(food);
    }
    public void delete(Integer id){
        foodRepository.deleteById(id);
    }

    public List<Food> findAll(){
      return  foodRepository.findAll();
    }

    public Food findById(Integer id){
        return foodRepository.findById(id).orElse(null);
    }
}
