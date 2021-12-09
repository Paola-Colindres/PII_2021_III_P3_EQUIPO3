package com.example.demo.service.UsuarioService;

import com.example.demo.entity.Usuario;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;

import java.util.List;

public interface IUsuarioService {
    Usuario       saveUsuario(Usuario usuario) throws BusinessException;
    List<Usuario> saveUsuarios(List<Usuario> usuarios) throws BusinessException;
    List<Usuario> getUsuarios() throws BusinessException;
    Usuario       getUsuarioById(long id) throws BusinessException, NotFoundException;
    Usuario       getUsuarioByNombre(String nombre) throws BusinessException, NotFoundException;
    void          deleteUsuario(long id) throws BusinessException, NotFoundException;
    Usuario       updateUsuario(Usuario usuario) throws BusinessException, NotFoundException;
}
