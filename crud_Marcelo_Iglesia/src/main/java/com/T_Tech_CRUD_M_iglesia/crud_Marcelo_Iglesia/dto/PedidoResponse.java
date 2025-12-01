package com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class PedidoResponse {

    private Long id;
    private LocalDate fecha;
    private List<DetallePedidoResponse> detalles;

    @Data
    public static class DetallePedidoResponse {
        private Long articuloId;
        private String nombre;
        private double precioUnitario;
        private int cantidad;
        private double subtotal;
    }
}
