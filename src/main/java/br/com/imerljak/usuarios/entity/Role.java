package br.com.imerljak.usuarios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Role implements Serializable {

    public static final Role GUEST_ROLE = new Role("GUEST");
    public static final Role USER_ROLE = new Role("USER");
    public static final Role ADMIN_ROLE = new Role("ADMIN");

    private static final long serialVersionUID = 1037038305031850351L;

    @Id
    @Column
    @NotEmpty
    private String role;

    public Role(@NotEmpty String role) {this.role = role;}

    protected Role() {}

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(role);
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                '}';
    }
}
