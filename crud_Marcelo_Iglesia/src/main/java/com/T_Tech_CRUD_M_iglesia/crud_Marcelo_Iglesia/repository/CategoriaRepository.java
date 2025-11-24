package com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.T_Tech_CRUD_M_iglesia.crud_Marcelo_Iglesia.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
