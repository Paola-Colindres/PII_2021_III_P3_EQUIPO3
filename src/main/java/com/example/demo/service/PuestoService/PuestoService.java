package com.example.demo.service.PuestoService;

import com.example.demo.entity.Puesto;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.PuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuestoService implements IPuestoService {

    @Autowired
    private PuestoRepository repository;

    @Override
    public Puesto savePuesto(Puesto puesto) throws BusinessException {
        try {
            //validaciones
            if(puesto.getNombre().isEmpty()){
                throw new BusinessException("El valor Nombre no debe estar vacío");
            }
            if (puesto.getNombre().length() < 3){
                throw new BusinessException("Nombre demasiado corto");
            }
            if (puesto.getEstudioMinimo().isEmpty()){
                throw new BusinessException("Estudio minimo no puede estar vacío");
            }
            if (puesto.getEstudioMinimo().length() <= 3){
                throw new BusinessException("El valor de Estudio minimo es demasiado corto");
            }
            if (String.valueOf(puesto.getCantidadEmpleados()).isEmpty()) {
                throw new BusinessException("La cantidad de empleados no debe estar vacia");
            }
            if (puesto.getCantidadEmpleados() <= 0) {
                throw new BusinessException("La cantidad de empleados no debe ser <= 0");
            }
            if (puesto.getUsoUniforme().isEmpty()) {
                throw new BusinessException("El uso de uniforme viene vacio");
            }
            if (puesto.getUsoUniforme().length() < 2) {
                throw new BusinessException("El uso de uniforme debe llevar mas de dos caracteres");
            }
            if (String.valueOf(puesto.getFechaInicio()).isEmpty()) {
                throw new BusinessException("La fecha de inicio viene vacia");
            }
            if (puesto.getFechaInicio().length() < 10) {
                throw new BusinessException("La fecha es demasiado corta");
            }
            if (puesto.getDescripcion().isEmpty()) {
                throw new BusinessException("La descripcion viene vacia");
            }
            if (puesto.getDescripcion().length() < 5) {
                throw new BusinessException("Ingrese mas de cinco caracteres en la descripcion");
            }
            if (puesto.getExperiencia().isEmpty()) {
                throw new BusinessException("Campo experiencia viene vacio");
            }
            if (puesto.getExperiencia().length() < 4) {
                throw new BusinessException("Ingrese mas de cuatro caracteres para indicar la experiencia");
            }

            return repository.save(puesto);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Puesto> savePuestos(List<Puesto> puestos) throws BusinessException {
        try {
            for (Puesto puesto: puestos) {
                if(puesto.getNombre().isEmpty()){
                    throw new BusinessException("El valor Nombre no debe estar vacío");
                }
                if (puesto.getNombre().length() < 3){
                    throw new BusinessException("Nombre demasiado corto");
                }
                if (puesto.getEstudioMinimo().isEmpty()){
                    throw new BusinessException("Estudio minimo no puede estar vacío");
                }
                if (puesto.getEstudioMinimo().length() <= 3){
                    throw new BusinessException("El valor de Estudio minimo es demasiado corto");
                }
                if (String.valueOf(puesto.getCantidadEmpleados()).isEmpty()) {
                    throw new BusinessException("La cantidad de empleados no debe estar vacia");
                }
                if (puesto.getCantidadEmpleados() <= 0) {
                    throw new BusinessException("La cantidad de empleados no debe ser <= 0");
                }
                if (puesto.getUsoUniforme().isEmpty()) {
                    throw new BusinessException("El uso de uniforme viene vacio");
                }
                if (puesto.getUsoUniforme().length() < 2) {
                    throw new BusinessException("El uso de uniforme debe llevar mas de dos caracteres");
                }
                if (String.valueOf(puesto.getFechaInicio()).isEmpty()) {
                    throw new BusinessException("La fecha de inicio viene vacia");
                }
                if (puesto.getFechaInicio().length() < 10) {
                    throw new BusinessException("La fecha es demasiado corta");
                }
                if (puesto.getDescripcion().isEmpty()) {
                    throw new BusinessException("La descripcion viene vacia");
                }
                if (puesto.getDescripcion().length() < 5) {
                    throw new BusinessException("Ingrese mas de cinco caracteres en la descripcion");
                }
                if (puesto.getExperiencia().isEmpty()) {
                    throw new BusinessException("Campo experiencia viene vacio");
                }
                if (puesto.getExperiencia().length() < 4) {
                    throw new BusinessException("Ingrese mas de cuatro caracteres para indicar la experiencia");
                }
            }
            return repository.saveAll(puestos);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Puesto> getPuestos() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Puesto getPuestoById(long id) throws BusinessException, NotFoundException {
        Optional<Puesto> opt=null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro el puesto " + id);
        }
        return opt.get();
    }

    @Override
    public Puesto getPuestoByNombre(String nombre) throws BusinessException, NotFoundException {
        Optional<Puesto> opt=null;
        try {
            opt = repository.findByNombre(nombre);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro el puesto " + nombre);
        }
        return opt.get();
    }

    @Override
    public void deletePuesto(long id) throws BusinessException, NotFoundException {
        Optional<Puesto> opt=null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro el puesto " + id);
        }
        else {
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    @Override
    public Puesto updatePuesto(Puesto puesto) throws BusinessException, NotFoundException {
        Optional<Puesto> opt=null;
        try {
            opt = repository.findById(puesto.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro el puesto " + puesto.getId());
        }
        else {
            try {
                if(puesto.getNombre().isEmpty()){
                    throw new BusinessException("El valor Nombre no debe estar vacío");
                }
                if (puesto.getNombre().length() < 3){
                    throw new BusinessException("Nombre demasiado corto");
                }
                if (puesto.getEstudioMinimo().isEmpty()){
                    throw new BusinessException("Estudio minimo no puede estar vacío");
                }
                if (puesto.getEstudioMinimo().length() <= 3){
                    throw new BusinessException("El valor de Estudio minimo es demasiado corto");
                }
                if (String.valueOf(puesto.getCantidadEmpleados()).isEmpty()) {
                    throw new BusinessException("La cantidad de empleados no debe estar vacia");
                }
                if (puesto.getCantidadEmpleados() <= 0) {
                    throw new BusinessException("La cantidad de empleados no debe ser <= 0");
                }
                if (puesto.getUsoUniforme().isEmpty()) {
                    throw new BusinessException("El uso de uniforme viene vacio");
                }
                if (puesto.getUsoUniforme().length() < 2) {
                    throw new BusinessException("El uso de uniforme debe llevar mas de dos caracteres");
                }
                if (String.valueOf(puesto.getFechaInicio()).isEmpty()) {
                    throw new BusinessException("La fecha de inicio viene vacia");
                }
                if (puesto.getFechaInicio().length() < 10) {
                    throw new BusinessException("La fecha es demasiado corta");
                }
                if (puesto.getDescripcion().isEmpty()) {
                    throw new BusinessException("La descripcion viene vacia");
                }
                if (puesto.getDescripcion().length() < 5) {
                    throw new BusinessException("Ingrese mas de cinco caracteres en la descripcion");
                }
                if (puesto.getExperiencia().isEmpty()) {
                    throw new BusinessException("Campo experiencia viene vacio");
                }
                if (puesto.getExperiencia().length() < 4) {
                    throw new BusinessException("Ingrese mas de cuatro caracteres para indicar la experiencia");
                }

                Puesto existingPuesto = new Puesto();
                existingPuesto.setId(puesto.getId());
                existingPuesto.setNombre(puesto.getNombre());
                existingPuesto.setEstudioMinimo(puesto.getEstudioMinimo());
                existingPuesto.setCantidadEmpleados(puesto.getCantidadEmpleados());
                existingPuesto.setUsoUniforme(puesto.getUsoUniforme());
                existingPuesto.setFechaInicio(puesto.getFechaInicio());
                existingPuesto.setDescripcion(puesto.getDescripcion());
                existingPuesto.setExperiencia(puesto.getExperiencia());
                return repository.save(existingPuesto);
            } catch (Exception e) {
                throw new BusinessException(e.getMessage());
            }
        }
    }
}
