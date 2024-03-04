package com.example.examenspring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    //clientes activos que tengan un total de ventas mayor a una cantidad
    @Query("SELECT c FROM Cliente c WHERE c.estado like 'Activo' and c.total>=:cantidad")
    List<Cliente> clientesActivos(@Param("cantidad") Long cantidad);

    //devolver un cliente segun su id
    Cliente getClienteById(Long id);

    @Query("SELECT SUM(c.total) FROM Cliente c")
    Long getTotal();

    @Query("SELECT AVG(c.total) FROM Cliente c WHERE c.estado like 'Activo'")
    Double getPromedio();

    @Query("SELECT COUNT(c) FROM Cliente c WHERE c.estado like 'Inactivo' AND c.total > 0")
    Long getInactivos();
}
