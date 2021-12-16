package com.example.demo.service.ReservacionesService;
import com.example.demo.entity.Reservaciones;

import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.ReservacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ReservacionesService implements IReservacionesService{
    @Autowired
    private ReservacionesRepository repository;

    @Override
    public Reservaciones saveReservacion(Reservaciones reservacion) throws BusinessException {
        try {
            if (reservacion.getCliente().isEmpty()){
                throw new BusinessException("El cliente está vacío");
            }
            if (reservacion.getCliente().length() < 5){
                throw new BusinessException("Cliente demasiado corto");
            }
            if (reservacion.getSucursal().isEmpty()){
                throw new BusinessException("La sucursal está vacía");
            }
            if (reservacion.getSucursal().length() < 5){
                throw new BusinessException("Sucursal demasiado corto");
            }
            if (reservacion.getHoraInicio().isEmpty()){
                throw new BusinessException("Hora de inicio está vacía");
            }
            if (reservacion.getHoraInicio().length() < 4){
                throw new BusinessException("Hora ingresada invalida");
            }
            if (reservacion.getHoraFinal().isEmpty()){
                throw new BusinessException("Hora de finalización está vacía");
            }
            if (reservacion.getHoraFinal().length() < 4){
                throw new BusinessException("Hora ingresada invalida");
            }
            if (String.valueOf(reservacion.getCantidadPersonas()).isEmpty()){
                throw new BusinessException("Cantidad de personas está vacío");
            }
            if (reservacion.getCantidadPersonas() < 0){
                throw new BusinessException("La cantidad de personas no puede ser menor a 0");
            }
            if (String.valueOf(reservacion.getFecha()).isEmpty()){
                throw new BusinessException("Fecha está vacío");
            }
            if (reservacion.getFecha().length() < 10){
                throw new BusinessException("La fecha es demasiaodo corta");
            }
            if (String.valueOf(reservacion.getPrecioReservacion()).isEmpty()){
                throw new BusinessException("El precio de la reservación está vacío");
            }
            if (reservacion.getPrecioReservacion() < 0){
                throw new BusinessException("El precio de la reservacion no puede ser menor a 0");
            }
            return repository.save(reservacion);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Reservaciones> saveReservaciones(List<Reservaciones> reservaciones) throws BusinessException {
        try {
            for (Reservaciones reservacion: reservaciones) {
                if (reservacion.getCliente().isEmpty()){
                    throw new BusinessException("El cliente está vacío");
                }
                if (reservacion.getCliente().length() < 5){
                    throw new BusinessException("Cliente demasiado corto");
                }
                if (reservacion.getSucursal().isEmpty()){
                    throw new BusinessException("La sucursal está vacía");
                }
                if (reservacion.getSucursal().length() < 5){
                    throw new BusinessException("Sucursal demasiado corto");
                }
                if (reservacion.getHoraInicio().isEmpty()){
                    throw new BusinessException("Hora de inicio está vacía");
                }
                if (reservacion.getHoraInicio().length() < 4){
                    throw new BusinessException("Hora ingresada invalida");
                }
                if (reservacion.getHoraFinal().isEmpty()){
                    throw new BusinessException("Hora de finalización está vacía");
                }
                if (reservacion.getHoraFinal().length() < 4){
                    throw new BusinessException("Hora ingresada invalida");
                }
                if (String.valueOf(reservacion.getCantidadPersonas()).isEmpty()){
                    throw new BusinessException("Cantidad de personas está vacío");
                }
                if (reservacion.getCantidadPersonas() < 0){
                    throw new BusinessException("La cantidad de personas no puede ser menor a 0");
                }
                if (String.valueOf(reservacion.getFecha()).isEmpty()){
                    throw new BusinessException("Fecha está vacío");
                }
                if (reservacion.getFecha().length() < 10){
                    throw new BusinessException("La fecha es demasiaodo corta");
                }
                if (String.valueOf(reservacion.getPrecioReservacion()).isEmpty()){
                    throw new BusinessException("El precio de la reservación está vacío");
                }
                if (reservacion.getPrecioReservacion() < 0){
                    throw new BusinessException("El precio de la reservacion no puede ser menor a 0");
                }
            }
            return repository.saveAll(reservaciones);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Reservaciones> getReservaciones() throws BusinessException {
        try {
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Reservaciones getReservacionById(long id) throws BusinessException, NotFoundException {
        Optional<Reservaciones> opt = null;
        try {
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se encontró la reservación "+id);
        }
        return opt.get();
    }

    @Override
    public Reservaciones getReservacionByCliente(String cliente) throws BusinessException, NotFoundException {
        Optional<Reservaciones> opt = null;
        try {
            opt = repository.findByCliente(cliente);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se encontró la reservacio del cliente "+cliente);
        }
        return opt.get();
    }

    @Override
    public void deleteReservacion(long id) throws BusinessException, NotFoundException {
        Optional<Reservaciones> opt = null;
        try {
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se encontró la reservacion "+id);
        }else {
            try {
                repository.deleteById(id);
            }catch (Exception ex){
                throw new BusinessException(ex.getMessage());
            }
        }
    }

    @Override
    public Reservaciones updateReservacion(Reservaciones reservacion) throws BusinessException, NotFoundException {
        Optional<Reservaciones> opt = null;
        try {
            opt = repository.findById(reservacion.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la sucursal " + reservacion.getId());
        } else {
            try {
                if (reservacion.getCliente().isEmpty()){
                    throw new BusinessException("El cliente está vacío");
                }
                if (reservacion.getCliente().length() < 5){
                    throw new BusinessException("Cliente demasiado corto");
                }
                if (reservacion.getSucursal().isEmpty()){
                    throw new BusinessException("La sucursal está vacía");
                }
                if (reservacion.getSucursal().length() < 5){
                    throw new BusinessException("Sucursal demasiado corto");
                }
                if (reservacion.getHoraInicio().isEmpty()){
                    throw new BusinessException("Hora de inicio está vacía");
                }
                if (reservacion.getHoraInicio().length() < 4){
                    throw new BusinessException("Hora ingresada invalida");
                }
                if (reservacion.getHoraFinal().isEmpty()){
                    throw new BusinessException("Hora de finalización está vacía");
                }
                if (reservacion.getHoraFinal().length() < 4){
                    throw new BusinessException("Hora ingresada invalida");
                }
                if (String.valueOf(reservacion.getCantidadPersonas()).isEmpty()){
                    throw new BusinessException("Cantidad de personas está vacío");
                }
                if (reservacion.getCantidadPersonas() < 0){
                    throw new BusinessException("La cantidad de personas no puede ser menor a 0");
                }
                if (String.valueOf(reservacion.getFecha()).isEmpty()){
                    throw new BusinessException("Fecha está vacío");
                }
                if (reservacion.getFecha().length() < 10){
                    throw new BusinessException("La fecha es demasiaodo corta");
                }
                if (String.valueOf(reservacion.getPrecioReservacion()).isEmpty()){
                    throw new BusinessException("El precio de la reservación está vacío");
                }
                if (reservacion.getPrecioReservacion() < 0){
                    throw new BusinessException("El precio de la reservacion no puede ser menor a 0");
                }
                Reservaciones existingReservacion = new Reservaciones();
                existingReservacion.setId(reservacion.getId());
                existingReservacion.setCliente(reservacion.getCliente());
                existingReservacion.setSucursal(reservacion.getSucursal());
                existingReservacion.setHoraInicio(reservacion.getHoraInicio());
                existingReservacion.setHoraFinal(reservacion.getHoraFinal());
                existingReservacion.setCantidadPersonas(reservacion.getCantidadPersonas());
                existingReservacion.setFecha(reservacion.getFecha());
                existingReservacion.setPrecioReservacion(reservacion.getPrecioReservacion());
                return repository.save(existingReservacion);
            } catch (Exception ex) {
                throw new BusinessException(ex.getMessage());
            }
        }
    }
}
