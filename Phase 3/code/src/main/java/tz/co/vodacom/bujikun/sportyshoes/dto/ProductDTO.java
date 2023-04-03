package tz.co.vodacom.bujikun.sportyshoes.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductDTO {
    private Integer id;
    private Integer count;
    private BigDecimal price;
    private String name;
}
