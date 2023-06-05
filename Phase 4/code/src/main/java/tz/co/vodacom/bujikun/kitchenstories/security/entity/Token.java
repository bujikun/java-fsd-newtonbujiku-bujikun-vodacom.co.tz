package tz.co.vodacom.bujikun.kitchenstories.security.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "tokens")
public class Token {
    @Id
    private Integer id;
    @Column("value")
    private String value;
    @Column("username")
    private String username;
    @Column("invalidated")
    private Boolean isInvalidated;
    @Column("version")
    private Integer version;
    @Column("created_on")
    @CreatedDate
    private LocalDateTime createdOn;

}