package data.hibernate;

import jakarta.persistence.*;

/**
 * Estado
 *
 * @author Jose L. Navío Mendoza
 */


@Entity
@Table(name = "ESTADOS")
public class Estado {
    @Id
    @Basic(optional = false)
    @Column(name = "ESTADO", nullable = false)
    String estado;
    @Column(name = "NOMBRE")
    String nombreEstado;

    public Estado() {
    }

    public Estado(String estado, String nombreEstado) {
        this.estado = estado;
        this.nombreEstado = nombreEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
}
