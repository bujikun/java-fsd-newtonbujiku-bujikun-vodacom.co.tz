package tz.co.vodacom.bujikun.sportyshoes.dto;

import lombok.*;

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
    private Set<String> products;
    private String createdOn;
    private String updatedOn;

}
