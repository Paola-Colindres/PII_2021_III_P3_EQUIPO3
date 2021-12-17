package com.example.demo.service.MenuService;

import com.example.demo.entity.Menu;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService implements IMenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public Menu saveMenu(Menu menu) throws BusinessException {
        try {
            if (menu.getProducto().isEmpty()) {
                throw new BusinessException("El producto no puede ir vacio.");
            }
            if (menu.getProducto().length() < 4) {
                throw new BusinessException("El nombre del producto es demasiado corto.");
            }
            if (String.valueOf(menu.getStock()).isEmpty()) {
                throw new BusinessException("El stock viene vacio.");
            }
            if (menu.getStock() <= 0) {
                throw new BusinessException("Stock no valido.");
            }
            if (menu.getDescripcion().isEmpty()) {
                throw new BusinessException("La descripcion esta vacia.");
            }
            if (menu.getDescripcion().length() < 5) {
                throw new BusinessException("Ingrese mas de cinco caracteres en la descripcion.");
            }
            if (String.valueOf(menu.getPrecio()).isEmpty()) {
                throw new BusinessException("El precio no puede ir vacio.");
            }
            if (menu.getPrecio() <= 0) {
                throw new BusinessException("Precio incorrecto.");
            }
            if (menu.getCategoria().isEmpty()) {
                throw new BusinessException("La categoria viene vacia.");
            }
            if (menu.getCategoria().length() < 4) {
                throw new BusinessException("La categoria debe llevar mas de 4 caracteres");
            }
            if (menu.getTiempoPreparacion().isEmpty()) {
                throw new BusinessException("Debe indicar el tiempo de preparación apróximado");
            }
            if (menu.getTiempoPreparacion().length() < 4) {
                throw new BusinessException("Tiempo de preparacion incorrecto");
            }
            if (menu.getVariaciones().isEmpty()) {
                throw new BusinessException("El campo de variaciones esta vacio");
            }
            if (menu.getVariaciones().length() < 3) {
                throw new BusinessException("Ingrese mas de tres caracteres en variaciones");
            }
            return repository.save(menu);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Menu> saveMenus(List<Menu> menus) throws BusinessException {
        try {
            for (Menu menu: menus) {
                if (menu.getProducto().isEmpty()) {
                    throw new BusinessException("El producto no puede ir vacio.");
                }
                if (menu.getProducto().length() < 4) {
                    throw new BusinessException("El nombre del producto es demasiado corto.");
                }
                if (String.valueOf(menu.getStock()).isEmpty()) {
                    throw new BusinessException("El stock viene vacio.");
                }
                if (menu.getStock() <= 0) {
                    throw new BusinessException("Stock no valido.");
                }
                if (menu.getDescripcion().isEmpty()) {
                    throw new BusinessException("La descripcion esta vacia.");
                }
                if (menu.getDescripcion().length() < 5) {
                    throw new BusinessException("Ingrese mas de cinco caracteres en la descripcion.");
                }
                if (String.valueOf(menu.getPrecio()).isEmpty()) {
                    throw new BusinessException("El precio no puede ir vacio.");
                }
                if (menu.getPrecio() <= 0) {
                    throw new BusinessException("Precio incorrecto.");
                }
                if (menu.getCategoria().isEmpty()) {
                    throw new BusinessException("La categoria viene vacia.");
                }
                if (menu.getCategoria().length() < 4) {
                    throw new BusinessException("La categoria debe llevar mas de 4 caracteres");
                }
                if (menu.getTiempoPreparacion().isEmpty()) {
                    throw new BusinessException("Debe indicar el tiempo de preparación apróximado");
                }
                if (menu.getTiempoPreparacion().length() < 4) {
                    throw new BusinessException("Tiempo de preparacion incorrecto");
                }
                if (menu.getVariaciones().isEmpty()) {
                    throw new BusinessException("El campo de variaciones esta vacio");
                }
                if (menu.getVariaciones().length() < 3) {
                    throw new BusinessException("Ingrese mas de tres caracteres en variaciones");
                }
            }
            return repository.saveAll(menus);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Menu> getMenus() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Menu getMenuById(long id) throws BusinessException, NotFoundException {
        Optional<Menu> opt = null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro el Menu " + id);
        }
        return opt.get();
    }

    @Override
    public Menu getMenuByProducto(String producto) throws BusinessException, NotFoundException {
        Optional<Menu> opt = null;
        try {
            opt = repository.findByProducto(producto);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro el producto " + producto);
        }
        return opt.get();
    }

    @Override
    public void deleteMenu(long id) throws BusinessException, NotFoundException {
        Optional<Menu> opt = null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro el Menu " + id);
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
    public Menu updateMenu(Menu menu) throws BusinessException, NotFoundException {
        Optional<Menu> opt = null;
        try {
            opt = repository.findById(menu.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro el Menu " + menu.getId());
        }
        else {
            try {
                //validaciones
                if (menu.getProducto().isEmpty()) {
                    throw new BusinessException("El producto no puede ir vacio.");
                }
                if (menu.getProducto().length() < 4) {
                    throw new BusinessException("El nombre del producto es demasiado corto.");
                }
                if (String.valueOf(menu.getStock()).isEmpty()) {
                    throw new BusinessException("El stock viene vacio.");
                }
                if (menu.getStock() <= 0) {
                    throw new BusinessException("Stock no valido.");
                }
                if (menu.getDescripcion().isEmpty()) {
                    throw new BusinessException("La descripcion esta vacia.");
                }
                if (menu.getDescripcion().length() < 5) {
                    throw new BusinessException("Ingrese mas de cinco caracteres en la descripcion.");
                }
                if (String.valueOf(menu.getPrecio()).isEmpty()) {
                    throw new BusinessException("El precio no puede ir vacio.");
                }
                if (menu.getPrecio() <= 0) {
                    throw new BusinessException("Precio incorrecto.");
                }
                if (menu.getCategoria().isEmpty()) {
                    throw new BusinessException("La categoria viene vacia.");
                }
                if (menu.getCategoria().length() < 4) {
                    throw new BusinessException("La categoria debe llevar mas de 4 caracteres");
                }
                if (menu.getTiempoPreparacion().isEmpty()) {
                    throw new BusinessException("Debe indicar el tiempo de preparación apróximado");
                }
                if (menu.getTiempoPreparacion().length() < 4) {
                    throw new BusinessException("Tiempo de preparacion incorrecto");
                }
                if (menu.getVariaciones().isEmpty()) {
                    throw new BusinessException("El campo de variaciones esta vacio");
                }
                if (menu.getVariaciones().length() < 3) {
                    throw new BusinessException("Ingrese mas de tres caracteres en variaciones");
                }

                Menu existingMenu = new Menu();
                existingMenu.setId(menu.getId());
                existingMenu.setProducto(menu.getProducto());
                existingMenu.setStock(menu.getStock());
                existingMenu.setDescripcion(menu.getDescripcion());
                existingMenu.setPrecio(menu.getPrecio());
                existingMenu.setCategoria(menu.getCategoria());
                existingMenu.setTiempoPreparacion(menu.getTiempoPreparacion());
                existingMenu.setVariaciones(menu.getVariaciones());
                return repository.save(existingMenu);
            } catch (Exception e) {
                throw new BusinessException(e.getMessage());
            }
        }
    }
}
