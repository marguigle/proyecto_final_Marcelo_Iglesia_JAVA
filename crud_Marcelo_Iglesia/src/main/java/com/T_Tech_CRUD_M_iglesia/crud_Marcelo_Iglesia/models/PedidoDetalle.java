package com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class PedidoDetalle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "pedido_id")
  private Pedido pedido;

  @ManyToOne
  @JoinColumn(name = "articulo_id")
  private Articulo articulo;

  private int cantidad;

  public double getSubtotal() {
    return articulo.getPrecio() * cantidad;
  }
}
