package com.dental.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name="tratamientos")
public class Tratamiento implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String trades;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrades() {
        return trades;
    }

    public void setTrades(String trades) {
        this.trades = trades;
    }

    @Override
    public String toString() {
        return "Tratamiento{" +
                "id=" + id +
                ", trades='" + trades + '\'' +
                '}';
    }
}
