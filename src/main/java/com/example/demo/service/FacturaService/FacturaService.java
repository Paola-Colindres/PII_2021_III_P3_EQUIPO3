package com.example.demo.service.FacturaService;

import com.example.demo.entity.Factura;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService implements IFacturaService {
    @Autowired
    private FacturaRepository repository;

    @Override
    public Factura saveFactura(Factura factura) throws BusinessException {
        try {
            //validaciones
            if (factura.getCliente().isEmpty()) {
                throw new BusinessException("El cliente viene vacio");
            }
            if (factura.getCliente().length() < 5) {
                throw new BusinessException("Ingrese mas de cinco caracteres en cliente");
            }
            if (factura.getEmpleado().isEmpty()) {
                throw new BusinessException("El empleado no debe estar vacio");
            }
            if (factura.getEmpleado().length() < 5) {
                throw new BusinessException("Empleado incorrecto, ingrese mas de cinco caracteres");
            }
            if (factura.getOrden().isEmpty()) {
                throw new BusinessException("La orden viene vacia");
            }
            if (String.valueOf(factura.getFecha()).isEmpty()) {
                throw new BusinessException("La fecha no debe estar vacia");
            }
            if (String.valueOf(factura.getCantidadOrden()).isEmpty()) {
                throw new BusinessException("La cantidad de orden no debe estar vacia");
            }
            if (factura.getCantidadOrden() <= 0) {
                throw new BusinessException("La cantidad de orden no debe ser <= 0");
            }
            if (factura.getTipoPago().isEmpty()) {
                throw new BusinessException("El tipo de pago viene vacio");
            }
            if (factura.getTipoPago().length() < 3) {
                throw new BusinessException("Tipo de Pago invalido");
            }
            if (String.valueOf(factura.getTotalPagar()).isEmpty()) {
                throw new BusinessException("El total a pagar viene vacio");
            }
            if (factura.getTotalPagar() <= 0) {
                throw new BusinessException("El total a pagar no debe ser <= 0");
            }
            return repository.save(factura);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Factura> saveFacturas(List<Factura> facturas) throws BusinessException {
        try {
            for (Factura factura: facturas) {
                if (factura.getCliente().isEmpty()) {
                    throw new BusinessException("El cliente viene vacio");
                }
                if (factura.getCliente().length() < 5) {
                    throw new BusinessException("Ingrese mas de cinco caracteres en cliente");
                }
                if (factura.getEmpleado().isEmpty()) {
                    throw new BusinessException("El empleado no debe estar vacio");
                }
                if (factura.getEmpleado().length() < 5) {
                    throw new BusinessException("Empleado incorrecto, ingrese mas de cinco caracteres");
                }
                if (factura.getOrden().isEmpty()) {
                    throw new BusinessException("La orden viene vacia");
                }
                if (String.valueOf(factura.getFecha()).isEmpty()) {
                    throw new BusinessException("La fecha no debe estar vacia");
                }
                if (String.valueOf(factura.getCantidadOrden()).isEmpty()) {
                    throw new BusinessException("La cantidad de orden no debe estar vacia");
                }
                if (factura.getCantidadOrden() <= 0) {
                    throw new BusinessException("La cantidad de orden no debe ser <= 0");
                }
                if (factura.getTipoPago().isEmpty()) {
                    throw new BusinessException("El tipo de pago viene vacio");
                }
                if (factura.getTipoPago().length() < 3) {
                    throw new BusinessException("Tipo de Pago invalido");
                }
                if (String.valueOf(factura.getTotalPagar()).isEmpty()) {
                    throw new BusinessException("El total a pagar viene vacio");
                }
                if (factura.getTotalPagar() <= 0) {
                    throw new BusinessException("El total a pagar no debe ser <= 0");
                }
            }
            return repository.saveAll(facturas);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Factura> getFacturas() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Factura getFacturaById(long id) throws BusinessException, NotFoundException {
        Optional<Factura> opt=null;
        try {
             opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro la factura " + id);
        }
        return opt.get();
    }

    @Override
    public Factura getFacturaByCliente(String cliente) throws BusinessException, NotFoundException {
        Optional<Factura> opt=null;
        try {
            opt = repository.findFirstByCliente(cliente);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro la factura con el cliente " + cliente);
        }
        return opt.get();
    }

    @Override
    public void deleteFactura(long id) throws BusinessException, NotFoundException {
        Optional<Factura> opt=null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro la factura " + id);
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
    public Factura updateFactura(Factura factura) throws BusinessException, NotFoundException {
        Optional<Factura> opt=null;
        try {
            opt = repository.findById(factura.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro la factura " + factura.getId());
        }
        else {
            try {
                //validaciones
                if (factura.getCliente().isEmpty()) {
                    throw new BusinessException("El cliente viene vacio");
                }
                if (factura.getCliente().length() < 5) {
                    throw new BusinessException("Ingrese mas de cinco caracteres en cliente");
                }
                if (factura.getEmpleado().isEmpty()) {
                    throw new BusinessException("El empleado no debe estar vacio");
                }
                if (factura.getEmpleado().length() < 5) {
                    throw new BusinessException("Empleado incorrecto, ingrese mas de cinco caracteres");
                }
                if (factura.getOrden().isEmpty()) {
                    throw new BusinessException("La orden viene vacia");
                }
                if (String.valueOf(factura.getFecha()).isEmpty()) {
                    throw new BusinessException("La fecha no debe estar vacia");
                }
                if (String.valueOf(factura.getCantidadOrden()).isEmpty()) {
                    throw new BusinessException("La cantidad de orden no debe estar vacia");
                }
                if (factura.getCantidadOrden() <= 0) {
                    throw new BusinessException("La cantidad de orden no debe ser <= 0");
                }
                if (factura.getTipoPago().isEmpty()) {
                    throw new BusinessException("El tipo de pago viene vacio");
                }
                if (factura.getTipoPago().length() < 3) {
                    throw new BusinessException("Tipo de Pago invalido");
                }
                if (String.valueOf(factura.getTotalPagar()).isEmpty()) {
                    throw new BusinessException("El total a pagar viene vacio");
                }
                if (factura.getTotalPagar() <= 0) {
                    throw new BusinessException("El total a pagar no debe ser <= 0");
                }

                Factura existingFactura = new Factura();
                existingFactura.setId(factura.getId());
                existingFactura.setCliente(factura.getCliente());
                existingFactura.setEmpleado(factura.getEmpleado());
                existingFactura.setOrden(factura.getOrden());
                existingFactura.setFecha(factura.getFecha());
                existingFactura.setCantidadOrden(factura.getCantidadOrden());
                existingFactura.setTipoPago(factura.getTipoPago());
                existingFactura.setTotalPagar(factura.getTotalPagar());
                return repository.save(existingFactura);
            } catch (Exception e) {
                throw new BusinessException(e.getMessage());
            }
        }
    }
}
