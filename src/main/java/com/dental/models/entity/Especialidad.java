package com.dental.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name="especialidades")
public class Especialidad implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String espdes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspdes() {
        return espdes;
    }

    public void setEspdes(String espdes) {
        this.espdes = espdes;
    }

    @Override
    public String toString() {
        return "Especialidad{" +
                "id=" + id +
                ", espdes='" + espdes + '\'' +
                '}';
    }
}
