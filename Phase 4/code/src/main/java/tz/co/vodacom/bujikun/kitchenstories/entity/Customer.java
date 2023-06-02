package tz.co.vodacom.bujikun.kitchenstories.entity;

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
@Table(name = "customers")
public class Customer {
    @Id
    private Integer id;
    @Column("first_name")
    private String firstName;
    @Column("last_name")
    private String lastName;
    @Column("email")
    private String email;
    @Column("account_number")
    private String accountNumber;
    @Column("version")
    private Integer version;
    @Column("created_on")
    @CreatedDate
    private LocalDateTime createdOn;
    @Column("updated_on")
    @LastModifiedDate
    private LocalDateTime updatedOn;

}
