package com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.dto.PedidoRequest;
import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.dto.PedidoResponse;
import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.models.Articulo;
import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.models.Pedido;
import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.models.PedidoDetalle;
import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.repository.ArticuloRepository;
import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.repository.PedidoDetalleRepository;
import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepo;

    @Autowired
    private PedidoDetalleRepository detalleRepo;

    @Autowired
    private ArticuloRepository articuloRepo;

    // -------------------------------------------------------
    // CREAR PEDIDO
    // -------------------------------------------------------
    public PedidoResponse crearPedido(PedidoRequest request) {

        Pedido pedido = new Pedido();
        pedidoRepo.save(pedido); // Para obtener ID en caso de no usar cascade

        for (PedidoRequest.ItemPedido item : request.getItems()) {

            Articulo articulo = articuloRepo.findById(item.getArticuloId())
                    .orElseThrow(() -> new RuntimeException("Artículo no encontrado: " + item.getArticuloId()));

            PedidoDetalle detalle = new PedidoDetalle();
            detalle.setPedido(pedido);
            detalle.setArticulo(articulo);
            detalle.setCantidad(item.getCantidad());

            detalleRepo.save(detalle);

            // Añadir el detalle a la lista del pedido
            pedido.getDetalles().add(detalle);
        }

        // Guardar cambios finales
        pedidoRepo.save(pedido);

        return convertirAPedidoResponse(pedido);
    }

    // -------------------------------------------------------
    // CONVERSORES DTO
    // -------------------------------------------------------
    public PedidoResponse convertirAPedidoResponse(Pedido pedido) {

        PedidoResponse dto = new PedidoResponse();
        dto.setId(pedido.getId());
        dto.setFecha(pedido.getFecha());

        // OJO: eliminamos dto.setTotal() porque ya no existe

        List<PedidoResponse.DetallePedidoResponse> detallesDTO = pedido.getDetalles().stream()
                .map(this::convertirDetalleAPedidoResponse)
                .toList();

        dto.setDetalles(detallesDTO);

        return dto;
    }

    private PedidoResponse.DetallePedidoResponse convertirDetalleAPedidoResponse(PedidoDetalle det) {

        PedidoResponse.DetallePedidoResponse dto = new PedidoResponse.DetallePedidoResponse();

        dto.setArticuloId(det.getArticulo().getId());
        dto.setNombre(det.getArticulo().getNombre());
        dto.setPrecioUnitario(det.getArticulo().getPrecio());
        dto.setCantidad(det.getCantidad());
        dto.setSubtotal(det.getSubtotal());

        return dto;
    }

    // -------------------------------------------------------
    // CRUD BÁSICO
    // -------------------------------------------------------
    public List<Pedido> listar() {
        return pedidoRepo.findAll();
    }

    public Pedido obtener(Long id) {
        return pedidoRepo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        pedidoRepo.deleteById(id);
    }
}
