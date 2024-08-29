package com.programa.prueba.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name = "cliente")
public class Cliente extends Persona{


    @NotEmpty(message = "Cliente ID no puede estar vacío")
    @Column(unique = true)
    private String clienteid;

    @NotEmpty(message = "Contraseña no puede estar vacía")
    private String contrasena;

    private Boolean estado;

    public @NotEmpty(message = "Cliente ID no puede estar vacío") String getClienteid() {
        return clienteid;
    }

    public void setClienteid(@NotEmpty(message = "Cliente ID no puede estar vacío") String clienteid) {
        this.clienteid = clienteid;
    }

    public @NotEmpty(message = "Contraseña no puede estar vacía") String getContrasena() {
        return contrasena;
    }

    public void setContrasena(@NotEmpty(message = "Contraseña no puede estar vacía") String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
