package com.example.demo.service.EmpleadoService;

import com.example.demo.entity.Empleado;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService {
    @Autowired
    private EmpleadoRepository repository;

    @Override
    public Empleado saveEmpleado(Empleado empleado) throws BusinessException {
        try {
            if (empleado.getNombre().isEmpty()) {
                throw new BusinessException("El nombre cliente está vacío");
            }
            if (empleado.getNombre().length() < 5) {
                throw new BusinessException("Nombre demasiado corto");
            }
            if (String.valueOf(empleado.getDni()).isEmpty()) {
                throw new BusinessException("El DNI está vacío");
            }
            if (String.valueOf(empleado.getDni()).length() < 12) {
                throw new BusinessException("DNI demasiado corto");
            }
            if (String.valueOf(empleado.getDni()).length() > 12) {
                throw new BusinessException("DNI demasiado largo");
            }
            if (empleado.getSueldo() < 0) {
                throw new BusinessException("El sueldo no puede ser menor a 0");
            }
            if (String.valueOf(empleado.getSueldo()).isEmpty()) {
                throw new BusinessException("El valor sueldo está vacío");
            }
            if (empleado.getSucursal().isEmpty()) {
                throw new BusinessException("Sucursal está vacía");
            }
            if (empleado.getSucursal().length() < 5) {
                throw new BusinessException("Sucursal demasiado corta");
            }
            if (String.valueOf(empleado.getFechaIngreso()).isEmpty()) {
                throw new BusinessException("Fecha de inicio está vacía");
            }
            if (String.valueOf(empleado.getFechaIngreso()).length() < 8) {
                throw new BusinessException("Fecha ingresada demasiado corta");
            }
            if (empleado.getGenero().isEmpty()) {
                throw new BusinessException("Género está vacío");
            }
            if (empleado.getGenero().length() < 5) {
                throw new BusinessException("Género ingresado demasiado corto");
            }
            if (String.valueOf(empleado.getEdad()).isEmpty()) {
                throw new BusinessException("Edad está vacía");
            }
            if (empleado.getEdad() < 0) {
                throw new BusinessException("La edad no puede ser menor a 0");
            }
            if (String.valueOf(empleado.getHoras()).isEmpty()) {
                throw new BusinessException("Valor Horas Extra está vacío");
            }
            if (empleado.getHoras() < 0) {
                throw new BusinessException("Horas extra no puede ser menores a 0");
            }
            if (String.valueOf(empleado.getPrecioHora()).isEmpty()) {
                throw new BusinessException("Precio horas extra está vacío");
            }
            if (empleado.getPrecioHora() < 0) {
                throw new BusinessException("El precio por hora no puede ser menor a 0");
            }
            return repository.save(empleado);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Empleado> saveEmpleados(List<Empleado> empleados) throws BusinessException {
        try {
            for (Empleado empleado : empleados) {
                if (empleado.getNombre().isEmpty()) {
                    throw new BusinessException("El nombre cliente está vacío");
                }
                if (empleado.getNombre().length() < 5) {
                    throw new BusinessException("Nombre demasiado corto");
                }
                if (String.valueOf(empleado.getDni()).isEmpty()) {
                    throw new BusinessException("El DNI está vacío");
                }
                if (String.valueOf(empleado.getDni()).length() < 12) {
                    throw new BusinessException("DNI demasiado corto");
                }
                if (String.valueOf(empleado.getDni()).length() > 12) {
                    throw new BusinessException("DNI demasiado largo");
                }
                if (empleado.getSueldo() < 0) {
                    throw new BusinessException("El sueldo no puede ser menor a 0");
                }
                if (String.valueOf(empleado.getSueldo()).isEmpty()) {
                    throw new BusinessException("El valor sueldo está vacío");
                }
                if (empleado.getSucursal().isEmpty()) {
                    throw new BusinessException("Sucursal está vacía");
                }
                if (empleado.getSucursal().length() < 5) {
                    throw new BusinessException("Sucursal demasiado corta");
                }
                if (String.valueOf(empleado.getFechaIngreso()).isEmpty()) {
                    throw new BusinessException("Fecha de inicio está vacía");
                }
                if (String.valueOf(empleado.getFechaIngreso()).length() < 8) {
                    throw new BusinessException("Fecha ingresada demasiado corta");
                }
                if (empleado.getGenero().isEmpty()) {
                    throw new BusinessException("Género está vacío");
                }
                if (empleado.getGenero().length() < 5) {
                    throw new BusinessException("Género ingresado demasiado corto");
                }
                if (String.valueOf(empleado.getEdad()).isEmpty()) {
                    throw new BusinessException("Edad está vacía");
                }
                if (empleado.getEdad() < 0) {
                    throw new BusinessException("La edad no puede ser menor a 0");
                }
                if (String.valueOf(empleado.getHoras()).isEmpty()) {
                    throw new BusinessException("Valor Horas Extra está vacío");
                }
                if (empleado.getHoras() < 0) {
                    throw new BusinessException("Horas extra no puede ser menores a 0");
                }
                if (String.valueOf(empleado.getPrecioHora()).isEmpty()) {
                    throw new BusinessException("Precio horas extra está vacío");
                }
                if (empleado.getPrecioHora() < 0) {
                    throw new BusinessException("El precio por hora no puede ser menor a 0");
                }
            }
            return repository.saveAll(empleados);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Empleado> getEmpleados() throws BusinessException {
        try {
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Empleado getEmpleadoById(long id) throws BusinessException, NotFoundException {
        Optional<Empleado> opt = null;
        try {
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se encontró el empleado "+id);
        }
        return opt.get();
    }

    @Override
    public Empleado getEmpleadoByNombre(String nombre) throws BusinessException, NotFoundException {
        Optional<Empleado> opt = null;
        try {
            opt = repository.findByNombre(nombre);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se encontró el empleado "+nombre);
        }
        return opt.get();
    }

    @Override
    public void deleteEmpleado(long id) throws BusinessException, NotFoundException {
        Optional<Empleado> opt = null;
        try {
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se encontró el empleado "+id);
        }else {
            try {
                repository.deleteById(id);
            }catch (Exception ex){
                throw new BusinessException(ex.getMessage());
            }
        }
    }

    @Override
    public Empleado updateEmpleado(Empleado empleado) throws BusinessException, NotFoundException {
        Optional<Empleado> opt = null;
        try {
            opt = repository.findById(empleado.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se encontró el empleado "+empleado.getId());
        }else {
            try {
                if (empleado.getNombre().isEmpty()) {
                    throw new BusinessException("El nombre cliente está vacío");
                }
                if (empleado.getNombre().length() < 5) {
                    throw new BusinessException("Nombre demasiado corto");
                }
                if (String.valueOf(empleado.getDni()).isEmpty()) {
                    throw new BusinessException("El DNI está vacío");
                }
                if (String.valueOf(empleado.getDni()).length() < 12) {
                    throw new BusinessException("DNI demasiado corto");
                }
                if (String.valueOf(empleado.getDni()).length() > 12) {
                    throw new BusinessException("DNI demasiado largo");
                }
                if (empleado.getSueldo() < 0) {
                    throw new BusinessException("El sueldo no puede ser menor a 0");
                }
                if (String.valueOf(empleado.getSueldo()).isEmpty()) {
                    throw new BusinessException("El valor sueldo está vacío");
                }
                if (empleado.getSucursal().isEmpty()) {
                    throw new BusinessException("Sucursal está vacía");
                }
                if (empleado.getSucursal().length() < 5) {
                    throw new BusinessException("Sucursal demasiado corta");
                }
                if (String.valueOf(empleado.getFechaIngreso()).isEmpty()) {
                    throw new BusinessException("Fecha de inicio está vacía");
                }
                if (String.valueOf(empleado.getFechaIngreso()).length() < 8) {
                    throw new BusinessException("Fecha ingresada demasiado corta");
                }
                if (empleado.getGenero().isEmpty()) {
                    throw new BusinessException("Género está vacío");
                }
                if (empleado.getGenero().length() < 5) {
                    throw new BusinessException("Género ingresado demasiado corto");
                }
                if (String.valueOf(empleado.getEdad()).isEmpty()) {
                    throw new BusinessException("Edad está vacía");
                }
                if (empleado.getEdad() < 0) {
                    throw new BusinessException("La edad no puede ser menor a 0");
                }
                if (String.valueOf(empleado.getHoras()).isEmpty()) {
                    throw new BusinessException("Valor Horas Extra está vacío");
                }
                if (empleado.getHoras() < 0) {
                    throw new BusinessException("Horas extra no puede ser menores a 0");
                }
                if (String.valueOf(empleado.getPrecioHora()).isEmpty()) {
                    throw new BusinessException("Precio horas extra está vacío");
                }
                if (empleado.getPrecioHora() < 0) {
                    throw new BusinessException("El precio por hora no puede ser menor a 0");
                }
                Empleado existingEmpleado = new Empleado();
                existingEmpleado.setId(empleado.getId());
                existingEmpleado.setNombre(empleado.getNombre());
                existingEmpleado.setDni(empleado.getDni());
                existingEmpleado.setSueldo(empleado.getSueldo());
                existingEmpleado.setSucursal(empleado.getSucursal());
                existingEmpleado.setFechaIngreso(empleado.getFechaIngreso());
                existingEmpleado.setGenero(empleado.getGenero());
                existingEmpleado.setEdad(empleado.getEdad());
                existingEmpleado.setHoras(empleado.getHoras());
                existingEmpleado.setPrecioHora(empleado.getPrecioHora());
                return repository.save(existingEmpleado);
            }catch (Exception ex){
                throw new BusinessException(ex.getMessage());
            }
        }
    }

}
