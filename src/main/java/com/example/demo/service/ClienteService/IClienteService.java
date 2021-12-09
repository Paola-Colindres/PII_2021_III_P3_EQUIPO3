package com.example.demo.service.ClienteService;

import com.example.demo.entity.Cliente;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;

import java.util.List;

public interface IClienteService {
    Cliente       saveCliente(Cliente cliente) throws BusinessException;
    List<Cliente> saveClientes(List<Cliente> clientes) throws BusinessException;
    List<Cliente> getClientes() throws BusinessException;
    Cliente       getClienteById(long id) throws BusinessException, NotFoundException;
    Cliente       getClienteByNombre(String nombre) throws BusinessException, NotFoundException;
    void          deleteCliente(long id) throws BusinessException, NotFoundException;
    Cliente       updateCliente(Cliente cliente) throws BusinessException, NotFoundException;
}
