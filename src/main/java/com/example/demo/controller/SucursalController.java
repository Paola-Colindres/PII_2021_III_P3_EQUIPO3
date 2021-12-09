package com.example.demo.controller;
import com.example.demo.entity.Sucursal;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.service.SucursalService.SucursalService;
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
@RequestMapping("/api/v1/sucursales")
public class SucursalController {
    @Autowired
    private SucursalService service;

    @PostMapping("/addSucursal")
    public ResponseEntity<Object> addSucursal(@RequestBody Sucursal sucursal){
        try {
            service.saveSucursal(sucursal);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_SUCURSALES + sucursal.getId());
            return new ResponseEntity(sucursal,responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no es válida", e.getMessage());
            return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addSucursales")
    public ResponseEntity<Any> addSucursales(@RequestBody List<Sucursal> sucursales){
        try {
            return new ResponseEntity(service.saveSucursales(sucursales), HttpStatus.CREATED);
        }catch (Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no es válida", e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Sucursal>> findAllSucursales(){
        try {
            return new ResponseEntity(service.getSucursales(),HttpStatus.OK);
        }catch (Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no valida", e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Sucursal> findSucursalById(@PathVariable long id){
        try {
            return new ResponseEntity(service.getSucursalById(id),HttpStatus.OK);
        }catch (BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no valida", e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NotFoundException ne){
            RestApiError apiError = new RestApiError(HttpStatus.NOT_FOUND,
                    "No se encontró coincidencia", ne.getMessage());
            return new ResponseEntity(apiError, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Sucursal> findSucursalByName(@PathVariable String nombre){
        try {
            return new ResponseEntity(service.getSucursalByNombre(nombre),HttpStatus.OK);
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
    public ResponseEntity<Any> updateSucursal(@RequestBody Sucursal sucursal){
        try {
            service.updateSucursal(sucursal);
            return new ResponseEntity(sucursal, HttpStatus.OK);
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
    public ResponseEntity<Any> deleteSucursal(@PathVariable long id){
        try {
            service.deleteSucursal(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no valida", e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NotFoundException ne){
            RestApiError apiError = new RestApiError(HttpStatus.NOT_FOUND,
                    "No se encontro coincidencias", ne.getMessage());
            return new ResponseEntity(apiError, HttpStatus.NOT_FOUND);
        }
    }
}
