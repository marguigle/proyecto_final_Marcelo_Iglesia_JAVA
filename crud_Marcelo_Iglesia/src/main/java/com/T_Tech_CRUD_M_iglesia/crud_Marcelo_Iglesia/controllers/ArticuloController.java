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

import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.models.Articulo;
import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.services.ArticuloService;

@RestController
@RequestMapping("/api")
public class ArticuloController {
    @Autowired
    public ArticuloService articuloService;

    @GetMapping("/articulos")
    public List<Articulo> listaArticulos() {
        return articuloService.listaArticulos();
    }

    @GetMapping("/articulos/{id}")
    public Articulo obtenerArticuloPorId(@PathVariable Long id) {
        return articuloService.obtenerArticuloPorId(id).orElse(null);
    }

    @PostMapping("/articulos")
    public Articulo guardarArticulo(@RequestBody Articulo articulo) {
        return articuloService.guardarArticulo(articulo);
    }

    @PutMapping("/articulos/{id}")
    public Articulo actualizasArticulo(@PathVariable Long id, @RequestBody Articulo articulo) {
        return articuloService.actualizasArticulo(id, articulo);
    }

    @DeleteMapping("/articulos/{id}")
    public void eliminarArticulo(@PathVariable Long id) {
        articuloService.eliminarArticulo(id);
    }

}
