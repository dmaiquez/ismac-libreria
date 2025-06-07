package com.distribuida.dao;

import com.distribuida.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByCedula(String cedula);

    boolean existsByCorreo(String correo);

}
