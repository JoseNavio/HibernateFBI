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
}
