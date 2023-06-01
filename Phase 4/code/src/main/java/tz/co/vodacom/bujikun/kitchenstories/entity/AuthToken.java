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
@Table(name = "tokens")
public class AuthToken {
    @Id
    private Integer id;
    @Column("value")
    private String value;
    @Column("active")
    private Boolean active;
    @Column("created_on")
    @CreatedDate
    private LocalDateTime createdOn;
}
