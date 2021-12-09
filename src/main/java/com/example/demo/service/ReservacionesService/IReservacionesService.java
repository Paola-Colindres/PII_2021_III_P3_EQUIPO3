package com.example.demo.service.ReservacionesService;

import com.example.demo.entity.Reservaciones;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;

import java.util.List;

public interface IReservacionesService {
    Reservaciones       saveReservacion(Reservaciones reservacion) throws BusinessException;
    List<Reservaciones> saveReservaciones(List<Reservaciones> reservaciones) throws BusinessException;
    List<Reservaciones> getReservaciones() throws BusinessException;
    Reservaciones       getReservacionById(long id) throws BusinessException, NotFoundException;
    Reservaciones       getReservacionByCliente(String cliente) throws BusinessException, NotFoundException;
    void                deleteReservacion(long id) throws BusinessException, NotFoundException;
    Reservaciones       updateReservacion(Reservaciones reservacion) throws BusinessException, NotFoundException;
}
