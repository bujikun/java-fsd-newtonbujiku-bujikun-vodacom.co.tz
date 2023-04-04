package tz.co.vodacom.bujikun.sportyshoes.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username",unique = true)
    private String username;
    private String password;
    private Boolean isEnabled;
    private Boolean isLocked;
    private Boolean isCredentialsExpired;
    private Boolean isAccountExpired;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "fk_user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "fk_role_id",referencedColumnName = "id")}
    )
    private Set<Role> roles;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;

}
