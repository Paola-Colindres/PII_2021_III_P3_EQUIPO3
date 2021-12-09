package com.example.demo.service.PuestoService;

import com.example.demo.entity.Puesto;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import org.aspectj.weaver.ast.Not;

import java.util.List;

public interface IPuestoService {
    Puesto       savePuesto(Puesto puesto) throws BusinessException;
    List<Puesto> savePuestos(List<Puesto> puestos) throws BusinessException;
    List<Puesto> getPuestos() throws BusinessException;
    Puesto       getPuestoById(long id) throws BusinessException, NotFoundException;
    Puesto       getPuestoByNombre(String nombre) throws BusinessException, NotFoundException;
    void         deletePuesto(long id) throws BusinessException, NotFoundException;
    Puesto       updatePuesto(Puesto puesto) throws BusinessException, NotFoundException;
}
