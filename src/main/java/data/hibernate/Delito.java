package data.hibernate;

import jakarta.persistence.*;

/**
 * Delito
 *
 * @author Jose L. Navío Mendoza
 */

@Entity
@Table(name = "DELITOS")
public class Delito {
    @Id
    @Basic(optional = false)
    @Column(name = "TOKEN", nullable = false)
    String token;
    @ManyToOne
    @JoinColumn(name = "FICHA")
    Sospechoso ficha;
    @Column(name = "FECHA")
    String fecha;
    @Column(name = "DELITO")
    String tipo;
    @Column(name = "OBSERVACIONES")
    String observaciones;

    public Delito() {
    }

    public Delito(String token, Sospechoso ficha, String fecha, String observaciones) {
        this.token = token;
        this.ficha = ficha;
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    public Delito(Sospechoso ficha, String fecha, String observaciones) {
        this.ficha = ficha;
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Sospechoso getFicha() {
        return ficha;
    }

    public void setFicha(Sospechoso ficha) {
        this.ficha = ficha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}