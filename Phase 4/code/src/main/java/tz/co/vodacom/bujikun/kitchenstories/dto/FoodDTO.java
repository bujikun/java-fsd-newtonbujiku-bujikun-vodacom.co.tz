package tz.co.vodacom.bujikun.kitchenstories.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import tz.co.vodacom.bujikun.kitchenstories.entity.Food;
import tz.co.vodacom.bujikun.kitchenstories.util.DateUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FoodDTO {
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("img_url")
    private String imageUrl;
    @JsonProperty("created_on")
    private String createdOn;
    @JsonProperty("updated_on")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String updatedOn;

    public Food toFood(DateUtil dateUtil){
        return Food.builder()
                .name(name)
                .price(price)
                .imageUrl(imageUrl)
                .createdOn(dateUtil.now())
                .build();
    }

    public static FoodDTO fromFood(Food food,DateUtil util){
        return FoodDTO.builder()
                .id(food.getId())
                .name(food.getName())
                .price(food.getPrice())
                .imageUrl(food.getImageUrl())
                .createdOn(util.fromLocalDateTime(food.getCreatedOn()))
                .build();
    }
}
