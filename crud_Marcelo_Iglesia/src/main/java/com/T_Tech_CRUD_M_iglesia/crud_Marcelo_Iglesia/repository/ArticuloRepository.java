package com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.repository;

import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.models.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {

}
