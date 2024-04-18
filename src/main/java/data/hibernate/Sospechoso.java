package data.hibernate;

import jakarta.persistence.*;

import java.util.List;

/**
 * Sospechoso
 *
 * @author Jose L. Navío Mendoza
 */


@Entity
@Table(name = "SOSPECHOSOS")
public class Sospechoso {
    @Id
    @Basic(optional = false)
    @Column(name = "FICHA", nullable = false)
    String ficha;

    @ManyToOne
    @JoinColumn(name = "ESTADO")
    Estado estado;

    @Column(name = "NOMBRE")
    String nombre;

    @Column(name = "SEXO")
    String sexo;
    @Column(name = "ALTURA")
    String altura;
    @Column(name = "PESO")
    String peso;
    @Column(name = "FECHANACIMIENTO")
    String fechaNacimiento;
    @Column(name = "FOTO")
    String foto;
    @OneToMany
    @JoinColumn(name = "FICHA")
    List<Delito> delitos;

    public Sospechoso() {
    }

    public Sospechoso(String ficha, Estado estado, String nombre, String sexo, String altura, String peso, String fechaNacimiento, String foto, List<Delito> delitos) {
        this.ficha = ficha;
        this.estado = estado;
        this.nombre = nombre;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
        this.fechaNacimiento = fechaNacimiento;
        this.foto = foto;
        this.delitos = delitos;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Delito> getDelitos() {
        return delitos;
    }

    public void setDelitos(List<Delito> delitos) {
        this.delitos = delitos;
    }
}

