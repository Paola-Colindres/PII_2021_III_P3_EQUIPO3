package com.example.demo.service.EmpleadoService;


import com.example.demo.entity.Empleado;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;

import java.util.List;

public interface IEmpleadoService {
    Empleado       saveEmpleado(Empleado empleado) throws BusinessException;
    List<Empleado> saveEmpleados(List<Empleado> empleados) throws BusinessException;
    List<Empleado> getEmpleados() throws BusinessException;
    Empleado       getEmpleadoById(long id) throws BusinessException, NotFoundException;
    Empleado       getEmpleadoByNombre(String nombre) throws BusinessException, NotFoundException;
    void           deleteEmpleado(long id) throws BusinessException, NotFoundException;
    Empleado       updateEmpleado(Empleado empleado) throws BusinessException, NotFoundException;
}
