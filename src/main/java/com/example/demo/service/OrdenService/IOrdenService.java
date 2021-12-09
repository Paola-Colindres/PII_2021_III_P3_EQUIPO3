package com.example.demo.service.OrdenService;

import com.example.demo.entity.Orden;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;

import java.util.List;

public interface IOrdenService {
    Orden       saveOrden(Orden orden) throws BusinessException;
    List<Orden> saveOrdenes(List<Orden> ordenes) throws BusinessException;
    List<Orden> getOrdenes() throws BusinessException;
    Orden       getOrdenById(long id) throws BusinessException, NotFoundException;
    Orden       getOrdenByPlato(String plato) throws BusinessException, NotFoundException;
    void        deleteOrden(long id) throws BusinessException, NotFoundException;
    Orden       updateOrden(Orden orden) throws BusinessException, NotFoundException;
}
