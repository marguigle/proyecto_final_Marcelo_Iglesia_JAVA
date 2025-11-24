package com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.models.Categoria;
import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();

    }

    @Override
    public Optional<Categoria> obtenerCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Long id, Categoria categoria) {

        Categoria categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id " + id));

        if (categoria.getNombre() != null) {
            categoriaExistente.setNombre(categoria.getNombre());
        }

        return categoriaRepository.save(categoriaExistente);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);

    }
}