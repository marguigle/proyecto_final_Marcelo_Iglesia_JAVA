package com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.services;

import java.util.List;
import java.util.Optional;

import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.models.Categoria;

public interface CategoriaService {

    List<Categoria> listarCategorias();

    Optional<Categoria> obtenerCategoriaPorId(Long id);

    Categoria guardarCategoria(Categoria categoria);

    Categoria actualizarCategoria(Long id, Categoria categoria);

    void eliminarCategoria(Long id);
}
