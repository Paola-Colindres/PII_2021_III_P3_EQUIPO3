package com.example.demo.controller;

import com.example.demo.entity.Puesto;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.service.PuestoService.PuestoService;
import com.example.demo.utils.Constants;
import com.example.demo.utils.RestApiError;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/puestos")
public class PuestoController {
    @Autowired
    private PuestoService service;

    @PostMapping("/addPuesto")
    public ResponseEntity<Object> addPuesto(@RequestBody Puesto puesto) {
        try {
            service.savePuesto(puesto);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_PUESTOS + puesto.getId());
            return new ResponseEntity(puesto, responseHeader, HttpStatus.CREATED);

        } catch (Exception e) {
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no es valida",
                    e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addPuestos")
    public ResponseEntity<Any> addPuestos(@RequestBody List<Puesto> puestos) {
        try {
            return new ResponseEntity(service.savePuestos(puestos), HttpStatus.CREATED);
        } catch (Exception e) {
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no es valida",
                    e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Puesto>> findAllPuestos() {
        try {
            return new ResponseEntity(service.getPuestos(), HttpStatus.OK);
        } catch (Exception e) {
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no es valida",
                    e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Puesto> findPuestoById(@PathVariable long id) {
        try {
            return new ResponseEntity(service.getPuestoById(id), HttpStatus.OK);
        }catch (BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no valida", e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NotFoundException ne){
            RestApiError apiError = new RestApiError(HttpStatus.NOT_FOUND,
                    "No se encontró coincidencias", ne.getMessage());
            return new ResponseEntity(apiError, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Puesto> findPuestoByNombre(@PathVariable String nombre) {
        try {
            return new ResponseEntity(service.getPuestoByNombre(nombre), HttpStatus.OK);
        }catch (BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no valida", e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NotFoundException ne){
            RestApiError apiError = new RestApiError(HttpStatus.NOT_FOUND,
                    "No se encontró coincidencias", ne.getMessage());
            return new ResponseEntity(apiError, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("")
    public ResponseEntity<Any> updatePuesto(@RequestBody Puesto puesto) {
        try {
            service.updatePuesto(puesto);
            return new ResponseEntity(puesto, HttpStatus.OK);
        }catch (BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no valida", e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NotFoundException ne){
            RestApiError apiError = new RestApiError(HttpStatus.NOT_FOUND,
                    "No se encontró coincidencias", ne.getMessage());
            return new ResponseEntity(apiError, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Any> deletePuesto(@PathVariable long id) {
        try {
            service.deletePuesto(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no valida", e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NotFoundException ne){
            RestApiError apiError = new RestApiError(HttpStatus.NOT_FOUND,
                    "No se encontró coincidencias", ne.getMessage());
            return new ResponseEntity(apiError, HttpStatus.NOT_FOUND);
        }
    }
}
