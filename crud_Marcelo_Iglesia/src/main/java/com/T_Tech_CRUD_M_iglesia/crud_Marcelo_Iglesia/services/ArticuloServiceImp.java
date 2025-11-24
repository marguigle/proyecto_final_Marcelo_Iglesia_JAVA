package com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.models.Articulo;
import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.repository.ArticuloRepository;
import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.repository.CategoriaRepository;

@Service
public class ArticuloServiceImp implements ArticuloService {
    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Articulo> listaArticulos() {
        return articuloRepository.findAll();

    }

    @Override
    public Optional<Articulo> obtenerArticuloPorId(Long id) {

        return articuloRepository.findById(id);
    }

    // @Override
    // public Articulo guardarArticulo(Articulo articulo) {

    // return articuloRepository.save(articulo);

    // }

    @Override
    public Articulo guardarArticulo(Articulo articulo) {

        if (articulo.getCategoria() != null && articulo.getCategoria().getId() != null) {

            Long idCategoria = articulo.getCategoria().getId();

            var categoriaBD = categoriaRepository.findById(idCategoria)
                    .orElseThrow(() -> new RuntimeException("La categoría con id " + idCategoria + " no existe"));

            articulo.setCategoria(categoriaBD);
        }

        return articuloRepository.save(articulo);
    }

    // @Override
    // public Articulo actualizasArticulo(Long id, Articulo articulo) {
    // articulo.setId(id);
    // return articuloRepository.save(articulo);
    // }
    @Override
    public Articulo actualizasArticulo(Long id, Articulo articulo) {

        Articulo articuloExistente = articuloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artículo con id " + id + " no encontrado"));

        articuloExistente.setNombre(articulo.getNombre());
        articuloExistente.setPrecio(articulo.getPrecio());

        if (articulo.getCategoria() != null) {
            Long idCategoria = articulo.getCategoria().getId();

            if (idCategoria != null) {
                var categoriaBD = categoriaRepository.findById(idCategoria)
                        .orElseThrow(() -> new RuntimeException("La categoría con id " + idCategoria + " no existe"));
                articuloExistente.setCategoria(categoriaBD);
            } else {

            }
        }

        return articuloRepository.save(articuloExistente);
    }

    @Override
    public void eliminarArticulo(Long id) {
        articuloRepository.deleteById(id);

    }

}
