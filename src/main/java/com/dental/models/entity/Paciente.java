package com.dental.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name="pacientes")
public class Paciente implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String tipodocumento;
    @NotEmpty
    private String numerodocumento;
    @NotEmpty
    private String nombres;
    @NotEmpty
    private String apellidopaterno;
    @NotEmpty
    private String apellidomaterno;
    @NotEmpty
    private String fechanacimiento;
    @NotEmpty
    private String sexo;
    private String estadocivil;
    @NotEmpty
    @Email
    private String email;
    @Pattern(regexp="[0-9]{9}")
    private String numerotelefono;
    @NotEmpty
    @Pattern(regexp="[0-9]{9}")
    private String numerocelular;
    private String direccion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumerotelefono() {
        return numerotelefono;
    }

    public void setNumerotelefono(String numerotelefono) {
        this.numerotelefono = numerotelefono;
    }

    public String getNumerocelular() {
        return numerocelular;
    }

    public void setNumerocelular(String numerocelular) {
        this.numerocelular = numerocelular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", tipodocumento='" + tipodocumento + '\'' +
                ", numerodocumento='" + numerodocumento + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidopaterno='" + apellidopaterno + '\'' +
                ", apellidomaterno='" + apellidomaterno + '\'' +
                ", fechanacimiento='" + fechanacimiento + '\'' +
                ", sexo='" + sexo + '\'' +
                ", estadocivil='" + estadocivil + '\'' +
                ", email='" + email + '\'' +
                ", numerotelefono='" + numerotelefono + '\'' +
                ", numerocelular='" + numerocelular + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
