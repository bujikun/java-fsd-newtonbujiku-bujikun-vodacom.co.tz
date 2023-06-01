package tz.co.vodacom.bujikun.kitchenstories.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author Newton Bujiku
 * @since 2023
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "permissions")
public class Permission {
    @Id
    private Integer id;
    @Column
    private String name;
    @Version
    private Integer version;
    @CreatedDate
    @Column("created_on")
    private LocalDateTime createdOn;
    @LastModifiedDate
    @Column("updated_on")
    private LocalDateTime updatedOn;
}
