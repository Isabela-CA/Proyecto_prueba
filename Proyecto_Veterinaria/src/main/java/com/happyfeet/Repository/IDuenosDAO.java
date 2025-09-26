package com.happyfeet.Repository;

import com.happyfeet.model.entities.Duenos;

import java.util.List;

public interface IDuenosDAO  {
    List<Duenos> listarDuenos();

    boolean buscarDuenosPorId(Duenos duenos);
    boolean agregarDuenos(Duenos duenos);
    boolean modificarDuenos(Duenos duenos);
    boolean eliminarDuenos(Duenos duenos);
}
