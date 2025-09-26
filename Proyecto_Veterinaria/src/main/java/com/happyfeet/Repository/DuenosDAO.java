package com.happyfeet.Repository;

import com.happyfeet.config.DatabaseConfig;
import com.happyfeet.model.entities.Duenos;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DuenosDAO implements IDuenosDAO {
    @Override
    public List<Duenos> listarDuenos() {
        List<Duenos> duenos = new ArrayList<>();
        String sql = "SELECT * FROM duenos ORDER BY id";

        try (Connection con = DatabaseConfig.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                var dueno = new Duenos();
                dueno.setId(rs.getInt("id"));
                dueno.setNombre_completo(rs.getString("nombre_completo"));
                dueno.setDocumento_identidad(rs.getString("documento_identidad"));
                dueno.setDireccion(rs.getString("direccion"));
                dueno.setTelefono(rs.getString("telefono"));
                dueno.setEmail(rs.getString("email"));
                dueno.setContacto_emergencia(rs.getString("contacto_emergencia"));

                duenos.add(dueno);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los dueños: " + e.getMessage());
            e.printStackTrace();
        }
        return duenos;
    }

    @Override
    public boolean buscarDuenosPorId(Duenos duenos) {
        PreparedStatement ps;
        ResultSet rs;
        var con = DatabaseConfig.getConexion();
        var sql = "SELECT * FROM duenos Where id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, duenos.getId());
            rs = ps.executeQuery();
            if (rs.next()){
                duenos.setNombre_completo(rs.getString("nombre_completo"));
                duenos.setDocumento_identidad(rs.getString("documento_identidad"));
                duenos.setDireccion(rs.getString("direccion"));
                duenos.setTelefono(rs.getString("telefono"));
                duenos.setEmail(rs.getString("email"));
                duenos.setContacto_emergencia(rs.getString("contacto_emergencia"));
                return true;
            }
        }catch (Exception e) {
            System.out.println("Error al recuperar dueño por id: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }
    @Override
    public boolean agregarDuenos(Duenos duenos) {
        PreparedStatement ps;
        var con = DatabaseConfig.getConexion();
        String sql = "INSERT INTO duenos(nombre_completo, documento_identidad, direccion, telefono, email, contacto_emergencia ) "
                + " VALUES(?, ?, ?, ?, ?, ? )";
        try{
        ps = con.prepareStatement(sql);
        ps.setString(1, duenos.getNombre_completo());
        ps.setString(2, duenos.getDocumento_identidad());
        ps.setString(3, duenos.getDireccion());
        ps.setString(4, duenos.getTelefono());
        ps.setString(5, duenos.getEmail());
        ps.setString(6, duenos.getContacto_emergencia());
        ps.execute();

        return true;

    }catch (Exception e){
        System.out.println("Error al agregar cliente: " + e.getMessage());
    }
        finally {
        try {
            con.close();
        }catch(Exception e){
            System.out.println("Error al cerrar conexion: " + e.getMessage());
        }
    }
        return false;
    }

    @Override
    public boolean modificarDuenos(Duenos duenos) {
        PreparedStatement ps;
        Connection con = DatabaseConfig.getConexion();
        String sql = "UPDATE duenos SET nombre_completo=?, documento_identidad=?, direccion=?, telefono=?, email=?, contacto_emergencia=? " +
                "WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, duenos.getNombre_completo());
            ps.setString(2, duenos.getDocumento_identidad());
            ps.setString(3, duenos.getDireccion());
            ps.setString(4, duenos.getTelefono());
            ps.setString(5, duenos.getEmail());
            ps.setString(6, duenos.getContacto_emergencia());
            ps.setInt(7, duenos.getId());
            ps.execute();
            return true;
        } catch (Exception e){
            System.out.println("Error al modificar dueño: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }


    @Override
    public boolean eliminarDuenos(Duenos duenos) {
        PreparedStatement ps;
        Connection con = DatabaseConfig.getConexion();
        String sql = "DELETE FROM duenos WHERE documento_identidad = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, duenos.getId());
            ps.execute();
            return true;
        } catch (Exception e){
            System.out.println("Error al eliminar dueño: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {

        DuenosDAO duenosDao = new DuenosDAO();

       // var modificarDuenos = new Duenos(83,"Daniel Perez", "65237", "cll 100D 109", "367337873" , "Daniel@gmail.com", "NULL");
       // var modificado = duenosDao.modificarDuenos(modificarDuenos);
       // if (modificado)
         //   System.out.println("Dueño modificado: " + modificarDuenos);


        var duenosEliminar = new Duenos(41);
        var eliminado = duenosDao.eliminarDuenos(duenosEliminar);
        if(eliminado) {
            System.out.println("Dueño eliminado correctamente");
        } else {
            System.out.println("No se pudo eliminar el dueño, es posible que sea Dueño de una mascota");
        }
        System.out.println("*** Listar DUEÑOS ***");
        var duenos = duenosDao.listarDuenos();
        duenos.forEach(System.out::println);
    }

}
