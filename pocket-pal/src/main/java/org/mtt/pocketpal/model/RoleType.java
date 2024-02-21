package org.mtt.pocketpal.model;

public enum RoleType {
    ROLE_USER,
    ROLE_ADMIN
}

/*

package org.mtt.pocketpal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "role_types")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RoleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    ROLE_USER,
    ROLE_ADMIN
}

 */