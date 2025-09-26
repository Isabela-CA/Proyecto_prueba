package com.happyfeet.model.entities;

import com.happyfeet.model.enums.SexoMascota;

import java.time.LocalDate;
import java.util.Objects;

public class Mascota {
    private int id;
    private int dueno_id;
    private String nombre;
    private int raza_id;
    private LocalDate fecha_nacimiento;

    public void setSexo(SexoMascota.Sexo sexo) {

    }

    private enum sexo {Macho,Hembra};
    private String url_foto;

    public Mascota(){
    }

    // contructor para eliminar mascota
    public Mascota(int id){
        this.id = id;
    }

    public Mascota(int dueno_id, String nombre, int raza_id, LocalDate fecha_nacimiento, String url_foto) {
        this.dueno_id = dueno_id;
        this.nombre = nombre;
        this.raza_id = raza_id;
        this.fecha_nacimiento = fecha_nacimiento;
        this.url_foto = url_foto;
    }

    public Mascota(int id, int dueno_id, String nombre, int raza_id, LocalDate fecha_nacimiento, String url_foto) {
        this(dueno_id, nombre, raza_id, fecha_nacimiento, url_foto);
        this.id =id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDueno_id() {
        return dueno_id;
    }

    public void setDueno_id(int dueno_id) {
        this.dueno_id = dueno_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getRaza_id() {
        return raza_id;
    }

    public void setRaza_id(int raza_id) {
        this.raza_id = raza_id;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    @Override
    public String toString() {
        return "mascota{" +
                "id=" + id +
                ", dueno_id=" + dueno_id +
                ", nombre='" + nombre + '\'' +
                ", raza_id=" + raza_id +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", url_foto='" + url_foto + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mascota mascota = (Mascota) o;
        return id == mascota.id && dueno_id == mascota.dueno_id && raza_id == mascota.raza_id && Objects.equals(nombre, mascota.nombre) && Objects.equals(fecha_nacimiento, mascota.fecha_nacimiento) && Objects.equals(url_foto, mascota.url_foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dueno_id, nombre, raza_id, fecha_nacimiento, url_foto);
    }
}