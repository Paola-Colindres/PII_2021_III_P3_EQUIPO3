package com.example.demo.controller;

import com.example.demo.entity.Proveedor;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.service.ProveedorService.ProveedorService;
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
@RequestMapping("/api/v1/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService service;

    @PostMapping("/addProveedor")
    public ResponseEntity<Object> addProveedor(@RequestBody Proveedor proveedor) {
        try {
            service.saveProveedor(proveedor);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_PROVEEDORES + proveedor.getId());
            return new ResponseEntity(proveedor, responseHeader, HttpStatus.CREATED);
        } catch (Exception e) {
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no es valida",
                    e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addProveedores")
    public ResponseEntity<Any> addProveedores(@RequestBody List<Proveedor> proveedores) {
        try {
            return new ResponseEntity(service.saveProveedores(proveedores), HttpStatus.CREATED);
        } catch (Exception e) {
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no es valida",
                    e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Proveedor>> findAllProveedores() {
        try {
            return new ResponseEntity(service.getProveedores(), HttpStatus.OK);
        } catch (Exception e) {
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no es valida",
                    e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Proveedor> findProveedorById(@PathVariable long id) {
        try {
            return new ResponseEntity(service.getProveedorById(id), HttpStatus.OK);
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
    public ResponseEntity<Proveedor> findProveedorByNombre(@PathVariable String nombre) {
        try {
            return new ResponseEntity(service.getProveedorByNombre(nombre), HttpStatus.OK);
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
    public ResponseEntity<Any> updateProveedor(@RequestBody Proveedor proveedor) {
        try {
            service.updateProveedor(proveedor);
            return new ResponseEntity(proveedor, HttpStatus.OK);
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
    public ResponseEntity<Any> deleteProveedor(@PathVariable long id) {
        try {
            service.deleteProveedor(id);
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
