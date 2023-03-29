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
    private String name;
    private BigDecimal price;
    private String description;
    private String imageUrl;
    private Set<String> categories;
    private String createdOn;
    private String updatedOn;
}
