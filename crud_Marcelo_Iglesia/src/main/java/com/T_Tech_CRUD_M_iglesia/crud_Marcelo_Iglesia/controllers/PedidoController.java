
package com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.dto.PedidoRequest;
import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.dto.PedidoResponse;
import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.models.Pedido;
import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public PedidoResponse crear(@RequestBody PedidoRequest request) {
        return pedidoService.crearPedido(request);
    }

    @GetMapping
    public List<PedidoResponse> listar() {
        return pedidoService.listar()
                .stream()
                .map(pedidoService::convertirAPedidoResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> obtener(@PathVariable Long id) {
        Pedido pedido = pedidoService.obtener(id);

        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pedidoService.convertirAPedidoResponse(pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        pedidoService.eliminar(id);
        return ResponseEntity.ok("Pedido eliminado");
    }
}
