package com.example.dental.model;

import javax.persistence.*;

@Entity
@Table(name="pacientesper")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpacientes")
    private Integer id;
    @Column(name = "Tipo_Documento", nullable = false)
    private Integer tdoc;
    @Column(name = "Numero_Documento", nullable = false, length = 15)
    private String ndoc;
    @Column(name = "Nombres", nullable = false, length = 45)
    private String nom;
    @Column(name = "Apellido_Paterno", nullable = false, length = 45)
    private String apat;
    @Column(name = "Apellido_Materno", nullable = false, length = 45)
    private String amat;
    @Column(name = "Fecha_Nacimiento", nullable = false, length = 10)
    private String fnac;
    @Column(name = "Sexo", nullable = true)
    private Integer sex;
    @Column(name = "Estado_Civil", nullable = false, length = 45)
    private String ecivil;
    @Column(name = "Email", nullable = false, length = 100)
    private String email;
    @Column(name = "Numero_Telefono", nullable = false, length = 9)
    private String ntel;
    @Column(name = "Numero_Celular", nullable = false, length = 9)
    private String ncel;
    @Column(name = "Direccion", nullable = false, length = 250)
    private String dir;

    public Paciente() {
    }

    public Paciente(Integer id, Integer tdoc, String ndoc, String nom, String apat, String amat, String fnac, Integer sex, String ecivil, String email, String ntel, String ncel, String dir) {
        this.id = id;
        this.tdoc = tdoc;
        this.ndoc = ndoc;
        this.nom = nom;
        this.apat = apat;
        this.amat = amat;
        this.fnac = fnac;
        this.sex = sex;
        this.ecivil = ecivil;
        this.email = email;
        this.ntel = ntel;
        this.ncel = ncel;
        this.dir = dir;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTdoc() {
        return tdoc;
    }

    public void setTdoc(Integer tdoc) {
        this.tdoc = tdoc;
    }

    public String getNdoc() {
        return ndoc;
    }

    public void setNdoc(String ndoc) {
        this.ndoc = ndoc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApat() {
        return apat;
    }

    public void setApat(String apat) {
        this.apat = apat;
    }

    public String getAmat() {
        return amat;
    }

    public void setAmat(String amat) {
        this.amat = amat;
    }

    public String getFnac() {
        return fnac;
    }

    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEcivil() {
        return ecivil;
    }

    public void setEcivil(String ecivil) {
        this.ecivil = ecivil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNtel() {
        return ntel;
    }

    public void setNtel(String ntel) {
        this.ntel = ntel;
    }

    public String getNcel() {
        return ncel;
    }

    public void setNcel(String ncel) {
        this.ncel = ncel;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", tdoc=" + tdoc +
                ", ndoc='" + ndoc + '\'' +
                ", nom='" + nom + '\'' +
                ", apat='" + apat + '\'' +
                ", amat='" + amat + '\'' +
                ", fnac='" + fnac + '\'' +
                ", sex=" + sex +
                ", ecivil='" + ecivil + '\'' +
                ", email='" + email + '\'' +
                ", ntel='" + ntel + '\'' +
                ", ncel='" + ncel + '\'' +
                ", dir='" + dir + '\'' +
                '}';
    }
}
