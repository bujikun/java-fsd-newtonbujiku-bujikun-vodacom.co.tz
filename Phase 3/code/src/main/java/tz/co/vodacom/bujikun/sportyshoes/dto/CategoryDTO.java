package tz.co.vodacom.bujikun.sportyshoes.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CategoryDTO {
    private Integer id;
    private String name;
    private String description;
    private Set<String> categories;
}
