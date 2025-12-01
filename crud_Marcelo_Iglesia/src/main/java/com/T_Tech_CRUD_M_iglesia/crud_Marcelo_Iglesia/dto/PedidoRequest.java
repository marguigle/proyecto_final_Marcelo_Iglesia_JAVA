package com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.dto;

import java.util.List;

import lombok.Data;

@Data
public class PedidoRequest {
    private List<ItemPedido> items;

    @Data
    public static class ItemPedido {
        private Long articuloId;
        private int cantidad;
    }
}
