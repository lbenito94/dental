package com.dental.model;

import javax.persistence.*;

@Entity
@Table(name="tratamientosper")
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtratamiento")
    private Integer id;
    @Column(name = "descripcion", nullable = false, length = 100)
    private String des;

    public Tratamiento() {
    }

    public Tratamiento(Integer id, String des) {
        this.id = id;
        this.des = des;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Tratamiento{" +
                "id=" + id +
                ", des='" + des + '\'' +
                '}';
    }
}
