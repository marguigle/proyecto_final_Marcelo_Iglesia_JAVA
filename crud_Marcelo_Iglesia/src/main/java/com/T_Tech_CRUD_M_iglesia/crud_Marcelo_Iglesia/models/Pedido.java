package com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate fecha = LocalDate.now();
  // @SuppressWarnings("unused")
  // private double total;

  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PedidoDetalle> detalles = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public List<PedidoDetalle> getDetalles() {
    return detalles;
  }

  public void setDetalles(List<PedidoDetalle> detalles) {
    this.detalles = detalles;
  }

  // public double getTotal() {
  // return detalles.stream()
  // .mapToDouble(PedidoDetalle::getSubtotal)
  // .sum();
  // }

  // public void setTotal(double total) {
  // this.total = total;
  // }
}
