package com.programa.prueba.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nombre no puede estar vacío")
    private String nombre;

    private String genero;

    private Integer edad;

    @NotEmpty(message = "Identificación no puede estar vacía")
    @Column(unique = true)
    private String identificacion;

    private String direccion;

    private String telefono;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "Nombre no puede estar vacío") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotEmpty(message = "Nombre no puede estar vacío") String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public @NotEmpty(message = "Identificación no puede estar vacía") String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(@NotEmpty(message = "Identificación no puede estar vacía") String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
