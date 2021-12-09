package com.example.demo.controller;
import com.example.demo.entity.Reservaciones;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.service.ReservacionesService.ReservacionesService;
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
@RequestMapping("/api/v1/reservaciones")
public class ReservacionesController {
    @Autowired
    private ReservacionesService service;

    @PostMapping("/addReservacion")
    public ResponseEntity<Object> addReservacion(@RequestBody Reservaciones reservacion){
        try {
            service.saveReservacion(reservacion);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_RESERVACIONES + reservacion.getId());
            return new ResponseEntity(reservacion,responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no es válida", e.getMessage());
            return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addReservaciones")
    public ResponseEntity<Any> addReservaciones(@RequestBody List<Reservaciones> reservaciones){
        try {
            return new ResponseEntity(service.saveReservaciones(reservaciones), HttpStatus.CREATED);
        }catch (Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no es válida", e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Reservaciones>> findAllReservaciones(){
        try {
            return new ResponseEntity(service.getReservaciones(),HttpStatus.OK);
        }catch (Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Informacion enviada no valida", e.getMessage());
            return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Reservaciones> findReservacionById(@PathVariable long id){
        try {
            return new ResponseEntity(service.getReservacionById(id),HttpStatus.OK);
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

    @GetMapping("/cliente/{cliente}")
    public ResponseEntity<Reservaciones> findReservacionByCliente(@PathVariable String cliente){
        try {
            return new ResponseEntity(service.getReservacionByCliente(cliente),HttpStatus.OK);
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
    public ResponseEntity<Any> updateReservacion(@RequestBody Reservaciones reservacion){
        try {
            service.updateReservacion(reservacion);
            return new ResponseEntity(reservacion, HttpStatus.OK);
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
    public ResponseEntity<Any> deleteReservacion(@PathVariable long id){
        try {
            service.deleteReservacion(id);
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
