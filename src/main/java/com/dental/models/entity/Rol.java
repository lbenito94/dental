package com.dental.models.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="roles")
public class Rol implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String roldes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoldes() {
        return roldes;
    }

    public void setRoldes(String roldes) {
        this.roldes = roldes;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", roldes='" + roldes + '\'' +
                '}';
    }
}
