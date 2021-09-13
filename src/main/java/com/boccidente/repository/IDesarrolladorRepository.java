package com.boccidente.repository;
import com.boccidente.entity.Desarrollador;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDesarrolladorRepository extends JpaRepository<Desarrollador, Integer>{
    Optional<Desarrollador> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
