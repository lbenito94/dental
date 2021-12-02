package com.dental.model;

import javax.persistence.*;

@Entity
@Table(name="especialidadesper")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idespecialidad")
    private Integer id;
    @Column(name = "descripcion", nullable = false, length = 50)
    private String des;

    public Especialidad(Integer id, String des) {
        this.id = id;
        this.des = des;
    }

    public Especialidad() {
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
        return "Especialidad{" +
                "id=" + id +
                ", des='" + des + '\'' +
                '}';
    }
}
