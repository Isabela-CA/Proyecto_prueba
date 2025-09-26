package com.happyfeet.Repository;

import com.happyfeet.config.DatabaseConfig;
import com.happyfeet.model.entities.Duenos;
import com.happyfeet.model.entities.Mascota;
import com.happyfeet.model.enums.SexoMascota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO implements IMascotaDAO{
    @Override
    public List<Mascota> listarMacota() {
        List<Mascota> mascota = new ArrayList<>();
        String sql = "SELECT * FROM mascotas ORDER BY id";

        try (Connection con = DatabaseConfig.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                var mascotas = new Mascota();
                mascotas.setId(rs.getInt("id"));
                mascotas.setDueno_id(rs.getInt("dueno_id"));
                mascotas.setNombre(rs.getString("nombre"));
                mascotas.setRaza_id(rs.getInt("raza_id"));
                mascotas.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                mascotas.setSexo(SexoMascota.Sexo.fromString(rs.getString("sexo")));
                mascotas.setUrl_foto(rs.getString("url_foto"));

                mascota.add(mascotas);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los dueños: " + e.getMessage());
            e.printStackTrace();
        }
        return mascota;
    }

    @Override
    public boolean buscarMacota(Mascota mascota) {
        return false;
    }

    @Override
    public boolean agregarMascota(Mascota mascota) {
        return false;
    }

    @Override
    public boolean modificarMascota(Mascota mascota) {
        return false;
    }

    @Override
    public boolean eliminarMascota(Mascota mascota) {
        return false;
    }

    @Override
    public List<Mascota> listarMascota(){
        List <Mascota> mascota = new ArrayList<>();
        String sql = "SELECT * FROM mascotas ORDER BY id";


        return mascota;
    }

}
