package com.boccidente.services;

import com.boccidente.entity.Desarrollador;
import java.util.List;
import java.util.Optional;

public interface IDesarrolladorService {

    boolean existById(int id);
    
    Optional<Desarrollador> getOne(int id);
    
    List<Desarrollador> listAll();
    
    Desarrollador save(Desarrollador desarrollador);
    
    void delete(int id);
}
