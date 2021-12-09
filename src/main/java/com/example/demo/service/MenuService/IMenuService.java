package com.example.demo.service.MenuService;

import com.example.demo.entity.Menu;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;

import java.util.List;

public interface IMenuService {
    Menu       saveMenu(Menu menu) throws BusinessException;
    List<Menu> saveMenus(List<Menu> menus) throws BusinessException;
    List<Menu> getMenus() throws BusinessException;
    Menu       getMenuById(long id) throws BusinessException, NotFoundException;
    Menu       getMenuByProducto(String producto) throws BusinessException, NotFoundException;
    void       deleteMenu(long id) throws BusinessException, NotFoundException;
    Menu       updateMenu(Menu menu) throws BusinessException, NotFoundException;
}
