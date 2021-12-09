package com.example.demo.service.FacturaService;

import com.example.demo.entity.Factura;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;

import java.util.List;

public interface IFacturaService {
    Factura       saveFactura(Factura factura) throws BusinessException;
    List<Factura> saveFacturas(List<Factura> facturas) throws BusinessException;
    List<Factura> getFacturas() throws BusinessException;
    Factura       getFacturaById(long id) throws BusinessException, NotFoundException;
    Factura       getFacturaByCliente(String cliente) throws BusinessException, NotFoundException;
    void          deleteFactura(long id) throws BusinessException, NotFoundException;
    Factura       updateFactura(Factura factura) throws BusinessException, NotFoundException;
}
