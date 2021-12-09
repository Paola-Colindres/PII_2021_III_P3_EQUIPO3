package com.example.demo.service.OrdenService;

import com.example.demo.entity.Orden;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenService implements IOrdenService {

    @Autowired
    private OrdenRepository repository;

    @Override
    public Orden saveOrden(Orden orden) throws BusinessException {
        try {
            //validaciones
            if (orden.getPlato().isEmpty()) {
                throw new BusinessException("El plato viene vacio");
            }
            if (orden.getPlato().length() < 5) {
                throw new BusinessException("Ingrese mas de cinco caracteres en el nombre del plato");
            }
            if (orden.getBebida().isEmpty()) {
                throw new BusinessException("La bebida viene vacia");
            }
            if (orden.getBebida().length() < 4) {
                throw new BusinessException("Ingrese mas de cuatro caracteres en nombre de bebida");
            }
            if (orden.getExtra().isEmpty()) {
                throw new BusinessException("No deje campos vacios");
            }
            if (orden.getExtra().length() < 3) {
                throw new BusinessException("El complemento extra es demasiado corto.");
            }
            if (orden.getComplemento().isEmpty()) {
                throw new BusinessException("El complemento viene vacio");
            }
            if (String.valueOf(orden.getCantidad()).isEmpty()) {
                throw new BusinessException("La cantidad viene vacia");
            }
            if (orden.getCantidad() <= 0) {
                throw new BusinessException("La cantidad no debe ser <= 0");
            }
            if (orden.getPostre().isEmpty()) {
                throw new BusinessException("El postre viene vacio");
            }
            if (orden.getPostre().length() < 5) {
                throw new BusinessException("El nombre del postre debe llevar mas de cinco caracteres");
            }
            if (String.valueOf(orden.getPrecioTotal()).isEmpty()) {
                throw new BusinessException("El precio total no debe ir vacio");
            }
            if (orden.getPrecioTotal() <= 0) {
                throw new BusinessException("El precio no puede ser <= 0");
            }

            return repository.save(orden);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Orden> saveOrdenes(List<Orden> ordenes) throws BusinessException {
        try {
            for (Orden orden: ordenes) {
                //validaciones
                if (orden.getPlato().isEmpty()) {
                    throw new BusinessException("El plato viene vacio");
                }
                if (orden.getPlato().length() < 5) {
                    throw new BusinessException("Ingrese mas de cinco caracteres en el nombre del plato");
                }
                if (orden.getBebida().isEmpty()) {
                    throw new BusinessException("La bebida viene vacia");
                }
                if (orden.getBebida().length() < 4) {
                    throw new BusinessException("Ingrese mas de cuatro caracteres en nombre de bebida");
                }
                if (orden.getExtra().isEmpty()) {
                    throw new BusinessException("No deje campos vacios");
                }
                if (orden.getExtra().length() < 3) {
                    throw new BusinessException("El complemento extra es demasiado corto.");
                }
                if (orden.getComplemento().isEmpty()) {
                    throw new BusinessException("El complemento viene vacio");
                }
                if (String.valueOf(orden.getCantidad()).isEmpty()) {
                    throw new BusinessException("La cantidad viene vacia");
                }
                if (orden.getCantidad() <= 0) {
                    throw new BusinessException("La cantidad no debe ser <= 0");
                }
                if (orden.getPostre().isEmpty()) {
                    throw new BusinessException("El postre viene vacio");
                }
                if (orden.getPostre().length() < 5) {
                    throw new BusinessException("El nombre del postre debe llevar mas de cinco caracteres");
                }
                if (String.valueOf(orden.getPrecioTotal()).isEmpty()) {
                    throw new BusinessException("El precio total no debe ir vacio");
                }
                if (orden.getPrecioTotal() <= 0) {
                    throw new BusinessException("El precio no puede ser <= 0");
                }
            }
            return repository.saveAll(ordenes);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Orden> getOrdenes() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Orden getOrdenById(long id) throws BusinessException, NotFoundException {
        Optional<Orden> opt=null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro la Orden " + id);
        }
        return opt.get();
    }

    @Override
    public Orden getOrdenByPlato(String plato) throws BusinessException, NotFoundException {
        Optional<Orden> opt=null;
        try {
            opt = repository.findByPlato(plato);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro la Orden con el Plato " + plato);
        }
        return opt.get();
    }

    @Override
    public void deleteOrden(long id) throws BusinessException, NotFoundException {
        Optional<Orden> opt=null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro la Orden " + id);
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
    public Orden updateOrden(Orden orden) throws BusinessException, NotFoundException {
        Optional<Orden> opt=null;
        try {
            opt = repository.findById(orden.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro la Orden " + orden.getId());
        }
        else {
            try {
                if (orden.getPlato().isEmpty()) {
                    throw new BusinessException("El plato viene vacio");
                }
                if (orden.getPlato().length() < 5) {
                    throw new BusinessException("Ingrese mas de cinco caracteres en el nombre del plato");
                }
                if (orden.getBebida().isEmpty()) {
                    throw new BusinessException("La bebida viene vacia");
                }
                if (orden.getBebida().length() < 4) {
                    throw new BusinessException("Ingrese mas de cuatro caracteres en nombre de bebida");
                }
                if (orden.getExtra().isEmpty()) {
                    throw new BusinessException("No deje campos vacios");
                }
                if (orden.getExtra().length() < 3) {
                    throw new BusinessException("El complemento extra es demasiado corto.");
                }
                if (orden.getComplemento().isEmpty()) {
                    throw new BusinessException("El complemento viene vacio");
                }
                if (String.valueOf(orden.getCantidad()).isEmpty()) {
                    throw new BusinessException("La cantidad viene vacia");
                }
                if (orden.getCantidad() <= 0) {
                    throw new BusinessException("La cantidad no debe ser <= 0");
                }
                if (orden.getPostre().isEmpty()) {
                    throw new BusinessException("El postre viene vacio");
                }
                if (orden.getPostre().length() < 5) {
                    throw new BusinessException("El nombre del postre debe llevar mas de cinco caracteres");
                }
                if (String.valueOf(orden.getPrecioTotal()).isEmpty()) {
                    throw new BusinessException("El precio total no debe ir vacio");
                }
                if (orden.getPrecioTotal() <= 0) {
                    throw new BusinessException("El precio no puede ser <= 0");
                }

                Orden existingOrden = new Orden();
                existingOrden.setId(orden.getId());
                existingOrden.setPlato(orden.getPlato());
                existingOrden.setBebida(orden.getBebida());
                existingOrden.setExtra(orden.getExtra());
                existingOrden.setComplemento(orden.getComplemento());
                existingOrden.setCantidad(orden.getCantidad());
                existingOrden.setPostre(orden.getPostre());
                existingOrden.setPrecioTotal(orden.getPrecioTotal());
                return repository.save(existingOrden);
            } catch (Exception e) {
                throw new BusinessException(e.getMessage());
            }
        }
    }
}
