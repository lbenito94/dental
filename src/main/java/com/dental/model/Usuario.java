package com.dental.model;

import javax.persistence.*;

@Entity
@Table(name="usuariosper")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer id;
    @Column(name = "usuario", nullable = false, length = 25)
    private String user;
    @Column(name = "clave", nullable = false, length = 25)
    private String pass;
    @Column(name = "idrol", nullable = true)
    private Integer idrol;

    public Usuario() {
    }

    public Usuario(Integer id, String user, String pass, Integer idrol) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.idrol = idrol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", idrol=" + idrol +
                '}';
    }
}
