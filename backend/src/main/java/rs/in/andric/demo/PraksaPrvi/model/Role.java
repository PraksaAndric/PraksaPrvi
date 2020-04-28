package rs.in.andric.demo.PraksaPrvi.model;

import javax.persistence.*;

@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue
    @Column(name="role_id")
    private Integer id;

    @Column
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
