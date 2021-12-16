package com.example.demo.service.ClienteService;


import com.example.demo.entity.Cliente;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    private ClienteRepository repository;

    @Override
    public Cliente saveCliente(Cliente cliente) throws BusinessException {
        try {
            if (cliente.getNombre().isEmpty()){
                throw new BusinessException("El nombre cliente está vacío");
            }
            if (cliente.getNombre().length() < 5){
                throw new BusinessException("Nombre demasiado corto");
            }
            if (String.valueOf(cliente.getDni()).isEmpty()){
                throw new BusinessException("El DNI está vacío");
            }
            if (String.valueOf(cliente.getDni()).length() < 12){
                throw new BusinessException("DNI demasiado corto");
            }
            if (String.valueOf(cliente.getDni()).length() > 12) {
                throw new BusinessException("DNI demasiado largo");
            }
            if (cliente.getOcupacion().isEmpty()){
                throw new BusinessException("La ocupacion de cliente está vacía");
            }
            if (cliente.getOcupacion().length() < 5){
                throw new BusinessException("Ocupacion demasiado corta");
            }
            if (String.valueOf(cliente.getTelefono()).isEmpty()){
                throw new BusinessException("El telefono está vacío");
            }
            if (String.valueOf(cliente.getTelefono()).length() < 8){
                throw new BusinessException("Telefono demasiado corto");
            }
            if (String.valueOf(cliente.getTelefono()).length() > 8){
                throw new BusinessException("Telefono demasiado largo");
            }
            if (cliente.getEmail().isEmpty()){
                throw new BusinessException("Email de cliente está vacío");
            }
            if (cliente.getEmail().length() < 10){
                throw new BusinessException("Email demasiado corta");
            }
            if (cliente.getDireccion().isEmpty()){
                throw new BusinessException("Dirección de cliente está vacía");
            }
            if (cliente.getDireccion().length() < 5){
                throw new BusinessException("Dirección demasiado corta");
            }
            if (String.valueOf(cliente.getEdad()).isEmpty()){
                throw new BusinessException("Valor Edad está vacío");
            }
            if (String.valueOf(cliente.getEdad()).length() > 3){
                throw new BusinessException("Edad Ingresada invalida");
            }
            if (cliente.getEdad() <= 0) {
                throw new BusinessException("La edad no puede ser <= 0");
            }
            return repository.save(cliente);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Cliente> saveClientes(List<Cliente> clientes) throws BusinessException {
        try {
            for (Cliente cliente: clientes) {
                if (cliente.getNombre().isEmpty()){
                    throw new BusinessException("El nombre cliente está vacío");
                }
                if (cliente.getNombre().length() < 5){
                    throw new BusinessException("Nombre demasiado corto");
                }
                if (String.valueOf(cliente.getDni()).isEmpty()){
                    throw new BusinessException("El DNI está vacío");
                }
                if (String.valueOf(cliente.getDni()).length() < 12){
                    throw new BusinessException("DNI demasiado corto");
                }
                if (String.valueOf(cliente.getDni()).length() > 12) {
                    throw new BusinessException("DNI demasiado largo");
                }
                if (cliente.getOcupacion().isEmpty()){
                    throw new BusinessException("La ocupacion de cliente está vacía");
                }
                if (cliente.getOcupacion().length() < 5){
                    throw new BusinessException("Ocupacion demasiado corta");
                }
                if (String.valueOf(cliente.getTelefono()).isEmpty()){
                    throw new BusinessException("El telefono está vacío");
                }
                if (String.valueOf(cliente.getTelefono()).length() < 8){
                    throw new BusinessException("Telefono demasiado corto");
                }
                if (String.valueOf(cliente.getTelefono()).length() > 8){
                    throw new BusinessException("Telefono demasiado largo");
                }
                if (cliente.getEmail().isEmpty()){
                    throw new BusinessException("Email de cliente está vacío");
                }
                if (cliente.getEmail().length() < 10){
                    throw new BusinessException("Email demasiado corta");
                }
                if (cliente.getDireccion().isEmpty()){
                    throw new BusinessException("Dirección de cliente está vacía");
                }
                if (cliente.getDireccion().length() < 5){
                    throw new BusinessException("Dirección demasiado corta");
                }
                if (String.valueOf(cliente.getEdad()).isEmpty()){
                    throw new BusinessException("Valor Edad está vacío");
                }
                if (String.valueOf(cliente.getEdad()).length() > 3){
                    throw new BusinessException("Edad Ingresada invalida");
                }
                if (cliente.getEdad() <= 0) {
                    throw new BusinessException("La edad no puede ser <= 0");
                }
            }
            return repository.saveAll(clientes);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Cliente> getClientes() throws BusinessException {
        try {
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Cliente getClienteById(long id) throws BusinessException, NotFoundException {
        Optional<Cliente> cliente = null;
        try {
            cliente = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!cliente.isPresent()){
            throw new NotFoundException("No se encontró el cliente "+ id);
        }
        return cliente.get();
    }

    @Override
    public Cliente getClienteByNombre(String nombre) throws BusinessException, NotFoundException {
        Optional<Cliente> cliente = null;
        try {
            cliente = repository.findByNombre(nombre);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!cliente.isPresent()){
            throw new NotFoundException("No se encontró el cliente "+ nombre);
        }
        return cliente.get();
    }

    @Override
    public void deleteCliente(long id) throws BusinessException, NotFoundException {
        Optional<Cliente> cliente = null;
        try {
            cliente = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!cliente.isPresent()){
            throw new NotFoundException("No se encontró el cliente "+ id);
        }else{
            try {
                repository.deleteById(id);
            }catch (Exception ex){
                throw new BusinessException(ex.getMessage());
            }
        }
    }

    @Override
    public Cliente updateCliente(Cliente cliente) throws BusinessException, NotFoundException {
        Optional<Cliente> opt = null;
        try {
            opt = repository.findById(cliente.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se encontró el cliente "+ cliente.getId());
        }else{
            try {
                if (cliente.getNombre().isEmpty()){
                    throw new BusinessException("El nombre cliente está vacío");
                }
                if (cliente.getNombre().length() < 5){
                    throw new BusinessException("Nombre demasiado corto");
                }
                if (String.valueOf(cliente.getDni()).isEmpty()){
                    throw new BusinessException("El DNI está vacío");
                }
                if (String.valueOf(cliente.getDni()).length() < 12){
                    throw new BusinessException("DNI demasiado corto");
                }
                if (String.valueOf(cliente.getDni()).length() > 12) {
                    throw new BusinessException("DNI demasiado largo");
                }
                if (cliente.getOcupacion().isEmpty()){
                    throw new BusinessException("La ocupacion de cliente está vacía");
                }
                if (cliente.getOcupacion().length() < 5){
                    throw new BusinessException("Ocupacion demasiado corta");
                }
                if (String.valueOf(cliente.getTelefono()).isEmpty()){
                    throw new BusinessException("El telefono está vacío");
                }
                if (String.valueOf(cliente.getTelefono()).length() < 8){
                    throw new BusinessException("Telefono demasiado corto");
                }
                if (String.valueOf(cliente.getTelefono()).length() > 8){
                    throw new BusinessException("Telefono demasiado largo");
                }
                if (cliente.getEmail().isEmpty()){
                    throw new BusinessException("Email de cliente está vacío");
                }
                if (cliente.getEmail().length() < 10){
                    throw new BusinessException("Email demasiado corta");
                }
                if (cliente.getDireccion().isEmpty()){
                    throw new BusinessException("Dirección de cliente está vacía");
                }
                if (cliente.getDireccion().length() < 5){
                    throw new BusinessException("Dirección demasiado corta");
                }
                if (String.valueOf(cliente.getEdad()).isEmpty()){
                    throw new BusinessException("Valor Edad está vacío");
                }
                if (String.valueOf(cliente.getEdad()).length() > 3){
                    throw new BusinessException("Edad Ingresada invalida");
                }
                if (cliente.getEdad() <= 0) {
                    throw new BusinessException("La edad no puede ser <= 0");
                }
                Cliente existingCliente = new Cliente();
                existingCliente.setId(cliente.getId());
                existingCliente.setNombre(cliente.getNombre());
                existingCliente.setDni(cliente.getDni());
                existingCliente.setOcupacion(cliente.getOcupacion());
                existingCliente.setTelefono(cliente.getTelefono());
                existingCliente.setEmail(cliente.getEmail());
                existingCliente.setDireccion(cliente.getDireccion());
                existingCliente.setEdad(cliente.getEdad());
                return repository.save(existingCliente); //Si hay error se puede poner solo la Entity cliente
            }catch (Exception ex){
                throw new BusinessException(ex.getMessage());
            }
        }
    }
}
