package com.example.demo.service.ProveedorService;

import com.example.demo.entity.Proveedor;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;

import java.util.List;

public interface IProveedorService {
    Proveedor       saveProveedor(Proveedor proveedor) throws BusinessException;
    List<Proveedor> saveProveedores(List<Proveedor> proveedores) throws BusinessException;
    List<Proveedor> getProveedores() throws BusinessException;
    Proveedor       getProveedorById(long id) throws BusinessException, NotFoundException;
    Proveedor       getProveedorByNombre(String nombre) throws BusinessException, NotFoundException;
    void            deleteProveedor(long id) throws BusinessException, NotFoundException;
    Proveedor       updateProveedor(Proveedor proveedor) throws BusinessException, NotFoundException;
}
