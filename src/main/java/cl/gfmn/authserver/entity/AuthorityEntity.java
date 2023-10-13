package cl.gfmn.authserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "authorities")
@Entity
public class AuthorityEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Integer authorityId;

    @Column(name = "role", unique = true)
    private String role;

    @Column(name = "active")
    private Boolean active;

    //Table 'authorities' is the inverse of the Many-to-Many relationship with 'users'
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "authorities")
    @JsonIgnore
    Set<UserEntity> users = new HashSet<>();
}
