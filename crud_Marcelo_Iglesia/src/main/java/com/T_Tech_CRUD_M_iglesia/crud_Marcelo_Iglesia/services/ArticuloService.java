package com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.services;

import java.util.List;
import java.util.Optional;

import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.models.Articulo;

public interface ArticuloService {
    List<Articulo> listaArticulos();

    Optional<Articulo> obtenerArticuloPorId(Long id);

    Articulo guardarArticulo(Articulo articulo);

    Articulo actualizasArticulo(Long id, Articulo articulo);

    void eliminarArticulo(Long id);
}
