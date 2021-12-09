package com.example.demo.service.SucursalService;

import com.example.demo.entity.Sucursal;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService implements ISucursalService {
    @Autowired
    private SucursalRepository repository;

    @Override
    public Sucursal saveSucursal(Sucursal sucursal) throws BusinessException {
        try {
            if (sucursal.getNombre().isEmpty()){
                throw new BusinessException("El nombre está vacío");
            }
            if (sucursal.getNombre().length() < 5){
                throw new BusinessException("El nombre es demasiado corto");
            }
            if (String.valueOf(sucursal.getCantidadEmpleados()).isEmpty()){
                throw new BusinessException("Cantidad de empleados está vacía");
            }
            if (sucursal.getCantidadEmpleados() < 0){
                throw new BusinessException("La cantidad de Empleados no puede ser menor a 0");
            }
            if (sucursal.getDireccion().isEmpty()){
                throw new BusinessException("La dirección está vacía");
            }
            if (sucursal.getDireccion().length()<5){
                throw new BusinessException("Dirección demasiado corta");
            }
            if (String.valueOf(sucursal.getFechaInicio()).isEmpty()){
                throw new BusinessException("La fecha de inicio está vacía");
            }
            /*if (sucursal.getFechaInicio().getYear() > LocalDate.now()){
                throw new BusinessException("La fecha inicio no puede ser a futuro");
            }*/
            if (String.valueOf(sucursal.getCantidadClientes()).isEmpty()){
                throw new BusinessException("La cantidad de clientes está vacía");
            }
            if (sucursal.getCantidadClientes() < 0){
                throw new BusinessException("La cantidad de clientes no puede ser menor a 0");
            }
            if (String.valueOf(sucursal.getConsumoEnergia()).isEmpty()){
                throw new BusinessException("El consumo de energía está vacío");
            }
            if (sucursal.getConsumoEnergia() < 0){
                throw new BusinessException("El consumo de energía no puede ser menor a 0");
            }
            if (sucursal.getHoraAbre().isEmpty()){
                throw new BusinessException("La hora de apertura está vacía");
            }
            if (sucursal.getHoraAbre().length() < 3){
                throw new BusinessException("Hora de apertura demasiado corta");
            }
            if (sucursal.getHoraCierre().isEmpty()){
                throw new BusinessException("La hora de cierre está vacía");
            }
            if (sucursal.getHoraCierre().length() < 3){
                throw new BusinessException("Hora de cierre demasiado corta");
            }
            return repository.save(sucursal);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Sucursal> saveSucursales(List<Sucursal> sucursales) throws BusinessException {
        try {
            for (Sucursal sucursal: sucursales) {
                if (sucursal.getNombre().isEmpty()){
                    throw new BusinessException("El nombre está vacío");
                }
                if (sucursal.getNombre().length() < 5){
                    throw new BusinessException("El nombre es demasiado corto");
                }
                if (String.valueOf(sucursal.getCantidadEmpleados()).isEmpty()){
                    throw new BusinessException("Cantidad de empleados está vacía");
                }
                if (sucursal.getCantidadEmpleados() < 0){
                    throw new BusinessException("La cantidad de Empleados no puede ser menor a 0");
                }
                if (sucursal.getDireccion().isEmpty()){
                    throw new BusinessException("La dirección está vacía");
                }
                if (sucursal.getDireccion().length()<5){
                    throw new BusinessException("Dirección demasiado corta");
                }
                if (String.valueOf(sucursal.getFechaInicio()).isEmpty()){
                    throw new BusinessException("La fecha de inicio está vacía");
                }
            /*if (sucursal.getFechaInicio().getYear() > LocalDate.now()){
                throw new BusinessException("La fecha inicio no puede ser a futuro");
            }*/
                if (String.valueOf(sucursal.getCantidadClientes()).isEmpty()){
                    throw new BusinessException("La cantidad de clientes está vacía");
                }
                if (sucursal.getCantidadClientes() < 0){
                    throw new BusinessException("La cantidad de clientes no puede ser menor a 0");
                }
                if (String.valueOf(sucursal.getConsumoEnergia()).isEmpty()){
                    throw new BusinessException("El consumo de energía está vacío");
                }
                if (sucursal.getConsumoEnergia() < 0){
                    throw new BusinessException("El consumo de energía no puede ser menor a 0");
                }
                if (sucursal.getHoraAbre().isEmpty()){
                    throw new BusinessException("La hora de apertura está vacía");
                }
                if (sucursal.getHoraAbre().length() < 3){
                    throw new BusinessException("Hora de apertura demasiado corta");
                }
                if (sucursal.getHoraCierre().isEmpty()){
                    throw new BusinessException("La hora de cierre está vacía");
                }
                if (sucursal.getHoraCierre().length() < 3){
                    throw new BusinessException("Hora de cierre demasiado corta");
                }
            }
            return repository.saveAll(sucursales);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Sucursal> getSucursales() throws BusinessException {
        try {
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Sucursal getSucursalById(long id) throws BusinessException, NotFoundException {
        Optional<Sucursal> opt = null;
        try {
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se encontró la sucursal "+id);
        }
        return opt.get();
    }

    @Override
    public Sucursal getSucursalByNombre(String nombre) throws BusinessException, NotFoundException {
        Optional<Sucursal> opt = null;
        try {
            opt = repository.findByNombre(nombre);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se encontró la sucursal "+nombre);
        }
        return opt.get();
    }

    @Override
    public void deleteSucursal(long id) throws BusinessException, NotFoundException {
        Optional<Sucursal> opt = null;
        try {
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se encontró la sucursal "+id);
        }else {
            try {
                repository.deleteById(id);
            }catch (Exception ex){
                throw new BusinessException(ex.getMessage());
            }
        }
    }

    @Override
    public Sucursal updateSucursal(Sucursal sucursal) throws BusinessException, NotFoundException {
        Optional<Sucursal> opt = null;
        try {
            opt = repository.findById(sucursal.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la sucursal " + sucursal.getId());
        }
        else {
            try {
                if (sucursal.getNombre().isEmpty()){
                    throw new BusinessException("El nombre está vacío");
                }
                if (sucursal.getNombre().length() < 5){
                    throw new BusinessException("El nombre es demasiado corto");
                }
                if (String.valueOf(sucursal.getCantidadEmpleados()).isEmpty()){
                    throw new BusinessException("Cantidad de empleados está vacía");
                }
                if (sucursal.getCantidadEmpleados() < 0){
                    throw new BusinessException("La cantidad de Empleados no puede ser menor a 0");
                }
                if (sucursal.getDireccion().isEmpty()){
                    throw new BusinessException("La dirección está vacía");
                }
                if (sucursal.getDireccion().length()<5){
                    throw new BusinessException("Dirección demasiado corta");
                }
                if (String.valueOf(sucursal.getFechaInicio()).isEmpty()){
                    throw new BusinessException("La fecha de inicio está vacía");
                }
            /*if (sucursal.getFechaInicio().getYear() > LocalDate.now()){
                throw new BusinessException("La fecha inicio no puede ser a futuro");
            }*/
                if (String.valueOf(sucursal.getCantidadClientes()).isEmpty()){
                    throw new BusinessException("La cantidad de clientes está vacía");
                }
                if (sucursal.getCantidadClientes() < 0){
                    throw new BusinessException("La cantidad de clientes no puede ser menor a 0");
                }
                if (String.valueOf(sucursal.getConsumoEnergia()).isEmpty()){
                    throw new BusinessException("El consumo de energía está vacío");
                }
                if (sucursal.getConsumoEnergia() < 0){
                    throw new BusinessException("El consumo de energía no puede ser menor a 0");
                }
                if (sucursal.getHoraAbre().isEmpty()){
                    throw new BusinessException("La hora de apertura está vacía");
                }
                if (sucursal.getHoraAbre().length() < 3){
                    throw new BusinessException("Hora de apertura demasiado corta");
                }
                if (sucursal.getHoraCierre().isEmpty()){
                    throw new BusinessException("La hora de cierre está vacía");
                }
                if (sucursal.getHoraCierre().length() < 3){
                    throw new BusinessException("Hora de cierre demasiado corta");
                }
                Sucursal existingSucursal = new Sucursal();
                existingSucursal.setId(sucursal.getId());
                existingSucursal.setNombre(sucursal.getNombre());
                existingSucursal.setCantidadEmpleados(sucursal.getCantidadEmpleados());
                existingSucursal.setDireccion(sucursal.getDireccion());
                existingSucursal.setFechaInicio(sucursal.getFechaInicio());
                existingSucursal.setCantidadClientes(sucursal.getCantidadClientes());
                existingSucursal.setConsumoEnergia(sucursal.getConsumoEnergia());
                existingSucursal.setHoraAbre(sucursal.getHoraAbre());
                existingSucursal.setHoraCierre(sucursal.getHoraCierre());
                return repository.save(existingSucursal);
            } catch (Exception ex) {
                throw new BusinessException(ex.getMessage());
            }
        }
    }
}
