package com.happyfeet.Repository;

import com.happyfeet.model.entities.Mascota;

import java.util.List;

public interface IMascotaDAO {
    List<Mascota> listarMacota();

    boolean buscarMacota(Mascota mascota);
    boolean agregarMascota(Mascota mascota);
    boolean modificarMascota(Mascota mascota);
    boolean eliminarMascota(Mascota mascota);

    List<Mascota> listarMascota();
}
