package com.boccidente.services;
import com.boccidente.entity.Desarrollador;
import java.util.*;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boccidente.repository.IDesarrolladorRepository;

@Service
@Transactional
public class DesarrolladorServiceImpl implements IDesarrolladorService{
    
    @Autowired
    IDesarrolladorRepository DesarrolladorRepository;
    
    //list of developers method
    public List<Desarrollador> listAll(){
        return DesarrolladorRepository.findAll();
    }

    //save developer method
    @Override
    public Desarrollador save(Desarrollador desarrollador) {
        return DesarrolladorRepository.save(desarrollador);
    }

    //delete developer method
    @Override
    public void delete(int id) {
        DesarrolladorRepository.deleteById(id);
    }

    //exist by id developer
    @Override
    public boolean existById(int id) {
        return DesarrolladorRepository.existsById(id);
    }

    //get one developer
    @Override
    public Optional<Desarrollador> getOne(int id) {
        return DesarrolladorRepository.findById(id);
    }
}
