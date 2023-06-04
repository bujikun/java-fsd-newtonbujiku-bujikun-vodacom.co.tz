package tz.co.vodacom.bujikun.kitchenstories.entity;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Newton Bujiku
 * @since 2023
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;
    @Column("is_account_locked")
    private Boolean isAccountLocked;
    @Column("is_account_expired")
    private Boolean isAccountExpired;
    @Column("is_credentials_expired")
    private Boolean isCredentialsExpired;
    @Column("is_enabled")
    private Boolean isEnabled;
    @MappedCollection(idColumn = "fk_user_id",keyColumn = "fk_permission_id")
    private Set<UserPermission> userPermissions;//many to many! for user actions
    @Transient
    private Set<Permission> permissions;
    @Version
    private Integer version;
    @CreatedDate
    @Column("created_on")
    private LocalDateTime createdOn;
    @LastModifiedDate
    @Column("updated_on")
    private LocalDateTime updatedOn;

    {
        userPermissions = new HashSet<>();
    }


    public void linkPermission(Permission permission){
        var userPermission = new UserPermission();
        userPermission.setPermissionId(AggregateReference.to(permission.getId()));
        userPermission.setCreatedOn(LocalDateTime.now());
        userPermissions.add(userPermission);
    }

    public void linkPermissions(Set<Permission> permissions){
        var userPermissionSet = permissions.stream()
                .map(permission->{
                    var userPerm = new UserPermission();
                    userPerm.setPermissionId(AggregateReference.to(permission.getId()));
                    userPerm.setCreatedOn(LocalDateTime.now());
                    return userPerm;
                })
                .collect(Collectors.toSet());
        userPermissions.addAll(userPermissionSet);
    }
}
