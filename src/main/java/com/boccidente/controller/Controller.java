package com.boccidente.controller;

import com.boccidente.entity.Desarrollador;
import com.boccidente.request.*;
import com.boccidente.services.DesarrolladorServiceImpl;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/developers")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @Autowired
    DesarrolladorServiceImpl Service;

    //list of developers
    @GetMapping("/list")
    public ResponseEntity<List<Desarrollador>> list() {
        List<Desarrollador> list = Service.listAll();

        return new ResponseEntity<List<Desarrollador>>(list, HttpStatus.OK);
    }

    //create method
    @PostMapping("/create")
    public ResponseEntity<Mensaje> create(@RequestBody DesarrolladorRequest desarrolladorRequest) {
        //validations
        if (StringUtils.isBlank(desarrolladorRequest.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        } else if (StringUtils.isBlank(desarrolladorRequest.getApellido())) {
            return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        } else if (StringUtils.isBlank(desarrolladorRequest.getCorreo())) {
            return new ResponseEntity(new Mensaje("El correo es obligatorio"), HttpStatus.BAD_REQUEST);
        } else if (desarrolladorRequest.getEdad() <= 0) {
            return new ResponseEntity(new Mensaje("La edad tiene que ser mayor a 0"), HttpStatus.BAD_REQUEST);
        } else if (desarrolladorRequest.getTelefono() <= 0) {
            return new ResponseEntity(new Mensaje("El teléfono es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        //new developer
        Desarrollador desarrollador = new Desarrollador(desarrolladorRequest.getNombre(), desarrolladorRequest.getApellido(), desarrolladorRequest.getEdad(), desarrolladorRequest.getCorreo(), desarrolladorRequest.getTelefono());
        Service.save(desarrollador);
        return new ResponseEntity(new Mensaje("Usuario creado exitosamente."), HttpStatus.OK);
    }

    //Update method
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DesarrolladorRequest desarrolladorRequest) {

        //Validations
        if (!Service.existById(id)) {
            return new ResponseEntity(new Mensaje("El usuario no existe."), HttpStatus.NOT_FOUND);
        }

        if (StringUtils.isBlank(desarrolladorRequest.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        } else if (StringUtils.isBlank(desarrolladorRequest.getApellido())) {
            return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        } else if (StringUtils.isBlank(desarrolladorRequest.getCorreo())) {
            return new ResponseEntity(new Mensaje("El correo es obligatorio"), HttpStatus.BAD_REQUEST);
        } else if (desarrolladorRequest.getEdad() <= 0) {
            return new ResponseEntity(new Mensaje("La edad tiene que ser mayor a 0"), HttpStatus.BAD_REQUEST);
        } else if (desarrolladorRequest.getTelefono() <= 0) {
            return new ResponseEntity(new Mensaje("El teléfono es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        //Developer update
        Desarrollador desarrollador = Service.getOne(id).get();
        desarrollador.setNombre(desarrolladorRequest.getNombre());
        desarrollador.setApellido(desarrolladorRequest.getApellido());
        desarrollador.setEdad(desarrolladorRequest.getEdad());
        desarrollador.setCorreo(desarrolladorRequest.getCorreo());
        desarrollador.setTelefono(desarrolladorRequest.getTelefono());
        Service.save(desarrollador);
        return new ResponseEntity(new Mensaje("Usuario actualizado exitosamente."), HttpStatus.OK);
    }

    //delete method
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Mensaje> delete(@PathVariable("id") int id) {
        //validation
        if (!Service.existById(id)) {
            return new ResponseEntity(new Mensaje("La ID proporcionada no existe."), HttpStatus.NOT_FOUND);
        }

        //delete of developer
        Service.delete(id);
        return new ResponseEntity(new Mensaje("Usuario eliminado exitosamente."), HttpStatus.NOT_FOUND);
    }
}
