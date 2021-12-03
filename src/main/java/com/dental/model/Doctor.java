package com.dental.model;

import javax.persistence.*;

@Entity
@Table(name="doctoresper")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddoctor")
    private Integer id;
    @Column(name = "Tipo_Documento", nullable = false)
    private String tdoc;
    @Column(name = "Numero_Documento", nullable = false, length = 15)
    private String ndoc;
    @Column(name = "Nombres", nullable = false, length = 45)
    private String nom;
    @Column(name = "Apellido_Paterno", nullable = false, length = 45)
    private String apat;
    @Column(name = "Apellido_Materno", nullable = false, length = 45)
    private String amat;
    @Column(name = "Numero_Colegiatura", nullable = false, length = 20)
    private String ncol;
    @Column(name = "idEspecialidades", nullable = false)
    private Integer idesp;

    public Doctor() {
    }

    public Doctor(Integer id, String tdoc, String ndoc, String nom, String apat, String amat, String ncol, Integer idesp) {
        this.id = id;
        this.tdoc = tdoc;
        this.ndoc = ndoc;
        this.nom = nom;
        this.apat = apat;
        this.amat = amat;
        this.ncol = ncol;
        this.idesp = idesp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTdoc() {
        return tdoc;
    }

    public void setTdoc(String tdoc) {
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

    public String getNcol() {
        return ncol;
    }

    public void setNcol(String ncol) {
        this.ncol = ncol;
    }

    public Integer getIdesp() {
        return idesp;
    }

    public void setIdesp(Integer idesp) {
        this.idesp = idesp;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", tdoc=" + tdoc +
                ", ndoc='" + ndoc + '\'' +
                ", nom='" + nom + '\'' +
                ", apat='" + apat + '\'' +
                ", amat='" + amat + '\'' +
                ", ncol='" + ncol + '\'' +
                ", idesp=" + idesp +
                '}';
    }
}
