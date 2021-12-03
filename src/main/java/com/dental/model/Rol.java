package com.dental.model;

import javax.persistence.*;

@Entity
@Table(name="rolesper")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private Integer id;
    @Column(name = "descripcion", nullable = false, length = 100)
    private String des;
    @Column(name = "idususario", nullable = true)
    private Integer iduser;

    public Rol() {
    }

    public Rol(Integer id, String des, Integer iduser) {
        this.id = id;
        this.des = des;
        this.iduser = iduser;
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

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", des='" + des + '\'' +
                ", iduser=" + iduser +
                '}';
    }
}
