package com.example.demo.controller;

import com.example.demo.entity.Empleado;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.service.EmpleadoService.EmpleadoService;
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
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService service;

    @PostMapping("/addEmpleado")
    public ResponseEntity<Object> addEmpleado(@RequestBody Empleado empleado){
        try {
            service.saveEmpleado(empleado);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_EMPLEADOS + empleado.getId());
            return new ResponseEntity(empleado,responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no es valida", e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/addEmpleados")
    public ResponseEntity<Any> addClientes(@RequestBody List<Empleado> empleados){
        try {
            return new ResponseEntity(service.saveEmpleados(empleados), HttpStatus.CREATED);
        }catch (Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no es valida", e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("")
    public ResponseEntity<List<Empleado>> findAllEmpleados() {
        try {
            return new ResponseEntity(service.getEmpleados(), HttpStatus.OK);
        } catch (Exception e) {
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no valida", e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Empleado> findEmpleadoById(@PathVariable long id){
        try {
            return new ResponseEntity(service.getEmpleadoById(id),HttpStatus.OK);
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
    public ResponseEntity<Empleado> findEmpleadoByNombre(@PathVariable String nombre){
        try {
            return new ResponseEntity(service.getEmpleadoByNombre(nombre),HttpStatus.OK);
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
    public ResponseEntity<Any> updateEmpleado(@RequestBody Empleado empleado){
        try {
            service.updateEmpleado(empleado);
            return new ResponseEntity(empleado, HttpStatus.OK);
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
    public ResponseEntity<Any> deleteEmpleado(@PathVariable long id){
        try {
            service.deleteEmpleado(id);
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
