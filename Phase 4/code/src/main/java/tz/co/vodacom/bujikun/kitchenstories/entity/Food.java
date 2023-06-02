package tz.co.vodacom.bujikun.kitchenstories.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "foods")
public class Food {
    @Id
    private Integer id;
    @Column("name")
    private String name;
    @Column("price")
    private BigDecimal price;
    @Column("img_url")
    private String imageUrl;
    @Column("version")
    private Integer version;
    @Column("created_on")
    @CreatedDate
    private LocalDateTime createdOn;
    @Column("updated_on")
    @LastModifiedDate
    private LocalDateTime updatedOn;
}
