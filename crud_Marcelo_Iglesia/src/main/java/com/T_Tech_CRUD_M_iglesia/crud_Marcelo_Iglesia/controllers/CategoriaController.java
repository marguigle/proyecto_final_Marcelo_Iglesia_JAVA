package com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.models.Categoria;
import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.services.CategoriaService;

@RestController
@RequestMapping("/api")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    };

    @GetMapping("categorias/{id}")
    public Categoria obtenerCategoriaPorId(@PathVariable Long id) {
        return categoriaService.obtenerCategoriaPorId(id).orElse(null);
    };

    @PostMapping("categorias")
    public Categoria guardarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.guardarCategoria(categoria);
    }

    @PutMapping("categorias/{id}")
    public Categoria actualizarCategoria(@PathVariable Long id, Categoria categoria) {
        return categoriaService.actualizarCategoria(id, categoria);
    }

    @DeleteMapping("categorias/{id}")
    public void eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
    }

}
