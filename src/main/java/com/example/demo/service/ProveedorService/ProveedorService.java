package com.example.demo.service.ProveedorService;

import com.example.demo.entity.Proveedor;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService implements IProveedorService {
    @Autowired
    private ProveedorRepository repository;


    @Override
    public Proveedor saveProveedor(Proveedor proveedor) throws BusinessException {
        try {
            //validaciones
            if (proveedor.getNombre().isEmpty()) {
                throw new BusinessException("El nombre viene vacio");
            }
            if (proveedor.getNombre().length() < 5) {
                throw new BusinessException("Ingrese mas de cinco caracteres en el nombre");
            }
            if (String.valueOf(proveedor.getFechaContrato()).isEmpty()) {
                throw new BusinessException("La fecha viene vacia");
            }
            if (String.valueOf(proveedor.getRtn()).isEmpty()) {
                throw new BusinessException("El rtn no debe estar vacio");
            }
            if (String.valueOf(proveedor.getRtn()).length() < 14) {
                throw new BusinessException("El rtn es muy corto");
            }
            if (String.valueOf(proveedor.getRtn()).length() > 14) {
                throw new BusinessException("El rtn no debe exceder 14 numeros");
            }
            if (proveedor.getRtn() <= 0) {
                throw new BusinessException("El rtn no debe ser menor a 0");
            }
            if (proveedor.getCiudad().isEmpty()) {
                throw new BusinessException("La ciudad no debe estar vacia");
            }
            if (proveedor.getCiudad().length() < 5) {
                throw new BusinessException("La ciudad debe llevar mas de cinco caracteres");
            }
            if (proveedor.getDireccion().isEmpty()) {
                throw new BusinessException("La direccion viene vacia");
            }
            if (proveedor.getDireccion().length() < 5) {
                throw new BusinessException("Direccion invalida, ingrese mas de cinco caracteres");
            }
            if (proveedor.getCategoria().isEmpty()) {
                throw new BusinessException("La categoria no debe estar vacia");
            }
            if (proveedor.getCategoria().length() < 5) {
                throw new BusinessException("Categoria invalida, ingrese mas de cinco caracteres");
            }
            if (String.valueOf(proveedor.getTelefono()).isEmpty()) {
                throw new BusinessException("El numero de telefono viene vacio");
            }
            if (String.valueOf(proveedor.getTelefono()).length() < 8) {
                throw new BusinessException("El numero de telefono es muy corto");
            }
            if (String.valueOf(proveedor.getTelefono()).length() > 8) {
                throw new BusinessException("El numero de telefono no debe exceder ocho digitos");
            }
            if (proveedor.getTelefono() < 0) {
                throw new BusinessException("Numero de telefono invalido");
            }
            return repository.save(proveedor);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Proveedor> saveProveedores(List<Proveedor> proveedores) throws BusinessException {
        try {
            for (Proveedor proveedor: proveedores) {
                if (proveedor.getNombre().isEmpty()) {
                    throw new BusinessException("El nombre viene vacio");
                }
                if (proveedor.getNombre().length() < 5) {
                    throw new BusinessException("Ingrese mas de cinco caracteres en el nombre");
                }
                if (String.valueOf(proveedor.getFechaContrato()).isEmpty()) {
                    throw new BusinessException("La fecha viene vacia");
                }
                if (String.valueOf(proveedor.getRtn()).isEmpty()) {
                    throw new BusinessException("El rtn no debe estar vacio");
                }
                if (String.valueOf(proveedor.getRtn()).length() < 14) {
                    throw new BusinessException("El rtn es muy corto");
                }
                if (String.valueOf(proveedor.getRtn()).length() > 14) {
                    throw new BusinessException("El rtn no debe exceder 14 numeros");
                }
                if (proveedor.getRtn() <= 0) {
                    throw new BusinessException("El rtn no debe ser menor a 0");
                }
                if (proveedor.getCiudad().isEmpty()) {
                    throw new BusinessException("La ciudad no debe estar vacia");
                }
                if (proveedor.getCiudad().length() < 5) {
                    throw new BusinessException("La ciudad debe llevar mas de cinco caracteres");
                }
                if (proveedor.getDireccion().isEmpty()) {
                    throw new BusinessException("La direccion viene vacia");
                }
                if (proveedor.getDireccion().length() < 5) {
                    throw new BusinessException("Direccion invalida, ingrese mas de cinco caracteres");
                }
                if (proveedor.getCategoria().isEmpty()) {
                    throw new BusinessException("La categoria no debe estar vacia");
                }
                if (proveedor.getCategoria().length() < 5) {
                    throw new BusinessException("Categoria invalida, ingrese mas de cinco caracteres");
                }
                if (String.valueOf(proveedor.getTelefono()).isEmpty()) {
                    throw new BusinessException("El numero de telefono viene vacio");
                }
                if (String.valueOf(proveedor.getTelefono()).length() < 8) {
                    throw new BusinessException("El numero de telefono es muy corto");
                }
                if (String.valueOf(proveedor.getTelefono()).length() > 8) {
                    throw new BusinessException("El numero de telefono no debe exceder ocho digitos");
                }
                if (proveedor.getTelefono() < 0) {
                    throw new BusinessException("Numero de telefono invalido");
                }
            }
            return repository.saveAll(proveedores);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Proveedor> getProveedores() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Proveedor getProveedorById(long id) throws BusinessException, NotFoundException {
        Optional<Proveedor> opt=null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro el proveedor " + id);
        }
        return opt.get();
    }

    @Override
    public Proveedor getProveedorByNombre(String nombre) throws BusinessException, NotFoundException {
        Optional<Proveedor> opt=null;
        try {
            opt = repository.findByNombre(nombre);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro el proveedor " + nombre);
        }
        return opt.get();
    }

    @Override
    public void deleteProveedor(long id) throws BusinessException, NotFoundException {
        Optional<Proveedor> opt=null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro el proveedor " + id);
        }
        else {
            try {
                repository.deleteById(id);
            } catch (Exception e) {
                throw new BusinessException(e.getMessage());
            }
        }
    }

    @Override
    public Proveedor updateProveedor(Proveedor proveedor) throws BusinessException, NotFoundException {
        Optional<Proveedor> opt=null;
        try {
            opt = repository.findById(proveedor.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro el proveedor " + proveedor.getId());
        }
        else {
            try {
                //validaciones
                if (proveedor.getNombre().isEmpty()) {
                    throw new BusinessException("El nombre viene vacio");
                }
                if (proveedor.getNombre().length() < 5) {
                    throw new BusinessException("Ingrese mas de cinco caracteres en el nombre");
                }
                if (String.valueOf(proveedor.getFechaContrato()).isEmpty()) {
                    throw new BusinessException("La fecha viene vacia");
                }
                if (String.valueOf(proveedor.getRtn()).isEmpty()) {
                    throw new BusinessException("El rtn no debe estar vacio");
                }
                if (String.valueOf(proveedor.getRtn()).length() < 14) {
                    throw new BusinessException("El rtn es muy corto");
                }
                if (String.valueOf(proveedor.getRtn()).length() > 14) {
                    throw new BusinessException("El rtn no debe exceder 14 numeros");
                }
                if (proveedor.getRtn() <= 0) {
                    throw new BusinessException("El rtn no debe ser menor a 0");
                }
                if (proveedor.getCiudad().isEmpty()) {
                    throw new BusinessException("La ciudad no debe estar vacia");
                }
                if (proveedor.getCiudad().length() < 5) {
                    throw new BusinessException("La ciudad debe llevar mas de cinco caracteres");
                }
                if (proveedor.getDireccion().isEmpty()) {
                    throw new BusinessException("La direccion viene vacia");
                }
                if (proveedor.getDireccion().length() < 5) {
                    throw new BusinessException("Direccion invalida, ingrese mas de cinco caracteres");
                }
                if (proveedor.getCategoria().isEmpty()) {
                    throw new BusinessException("La categoria no debe estar vacia");
                }
                if (proveedor.getCategoria().length() < 5) {
                    throw new BusinessException("Categoria invalida, ingrese mas de cinco caracteres");
                }
                if (String.valueOf(proveedor.getTelefono()).isEmpty()) {
                    throw new BusinessException("El numero de telefono viene vacio");
                }
                if (String.valueOf(proveedor.getTelefono()).length() < 8) {
                    throw new BusinessException("El numero de telefono es muy corto");
                }
                if (String.valueOf(proveedor.getTelefono()).length() > 8) {
                    throw new BusinessException("El numero de telefono no debe exceder ocho digitos");
                }
                if (proveedor.getTelefono() < 0) {
                    throw new BusinessException("Numero de telefono invalido");
                }

                Proveedor existingProveedor = new Proveedor();
                existingProveedor.setId(proveedor.getId());
                existingProveedor.setNombre(proveedor.getNombre());
                existingProveedor.setFechaContrato(proveedor.getFechaContrato());
                existingProveedor.setRtn(proveedor.getRtn());
                existingProveedor.setCiudad(proveedor.getCiudad());
                existingProveedor.setDireccion(proveedor.getDireccion());
                existingProveedor.setCategoria(proveedor.getCategoria());
                existingProveedor.setTelefono(proveedor.getTelefono());
                return repository.save(existingProveedor);
            } catch (Exception e) {
                throw new BusinessException(e.getMessage());
            }
        }
    }
}
