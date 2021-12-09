package com.example.demo.service.SucursalService;

import com.example.demo.entity.Sucursal;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;

import java.util.List;

public interface ISucursalService {
    Sucursal       saveSucursal(Sucursal sucursal) throws BusinessException;
    List<Sucursal> saveSucursales(List<Sucursal> sucursales) throws BusinessException;
    List<Sucursal> getSucursales() throws BusinessException;
    Sucursal       getSucursalById(long id) throws BusinessException, NotFoundException;
    Sucursal       getSucursalByNombre(String nombre) throws BusinessException, NotFoundException;
    void           deleteSucursal(long id) throws BusinessException, NotFoundException;
    Sucursal       updateSucursal(Sucursal sucursal) throws BusinessException, NotFoundException;
}
