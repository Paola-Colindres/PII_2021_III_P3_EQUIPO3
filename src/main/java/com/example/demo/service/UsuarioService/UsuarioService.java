package com.example.demo.service.UsuarioService;

import com.example.demo.entity.Usuario;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario saveUsuario(Usuario usuario) throws BusinessException {
        try {
            //validaciones
            if (usuario.getNombre().isEmpty()) {
                throw new BusinessException("El nombre viene vacio.");
            }
            if (usuario.getNombre().length() < 5) {
                throw new BusinessException("Ingrese mas de cinco caracteres en el nombre");
            }
            if (usuario.getContrasena().isEmpty()) {
                throw new BusinessException("La contraseña viene vacia");
            }
            if (usuario.getContrasena().length() < 4) {
                throw new BusinessException("La contraseña es demasiado corta");
            }
            if (usuario.getCorreo().isEmpty()) {
                throw new BusinessException("El correo viene vacio");
            }
            if (usuario.getCorreo().length() < 10) {
                throw new BusinessException("Correo incorrecto");
            }
            if (usuario.getRol().isEmpty()) {
                throw new BusinessException("El rol viene vacio");
            }
            if (usuario.getRol().length() < 5) {
                throw new BusinessException("Rol invalido");
            }
            if (usuario.getActivo().isEmpty()) {
                throw new BusinessException("El activo viene vacio");
            }
            return repository.save(usuario);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Usuario> saveUsuarios(List<Usuario> usuarios) throws BusinessException {
        try {
            for (Usuario usuario: usuarios) {
                if (usuario.getNombre().isEmpty()) {
                    throw new BusinessException("El nombre viene vacio.");
                }
                if (usuario.getNombre().length() < 5) {
                    throw new BusinessException("Ingrese mas de cinco caracteres en el nombre");
                }
                if (usuario.getContrasena().isEmpty()) {
                    throw new BusinessException("La contraseña viene vacia");
                }
                if (usuario.getContrasena().length() < 4) {
                    throw new BusinessException("La contraseña es demasiado corta");
                }
                if (usuario.getCorreo().isEmpty()) {
                    throw new BusinessException("El correo viene vacio");
                }
                if (usuario.getCorreo().length() < 10) {
                    throw new BusinessException("Correo incorrecto");
                }
                if (usuario.getRol().isEmpty()) {
                    throw new BusinessException("El rol viene vacio");
                }
                if (usuario.getRol().length() < 5) {
                    throw new BusinessException("Rol invalido");
                }
                if (usuario.getActivo().isEmpty()) {
                    throw new BusinessException("El activo viene vacio");
                }
            }
            return repository.saveAll(usuarios);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Usuario> getUsuarios() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Usuario getUsuarioById(long id) throws BusinessException, NotFoundException {
        Optional<Usuario> opt=null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro el usuario");
        }
        return opt.get();
    }

    @Override
    public Usuario getUsuarioByNombre(String nombre) throws BusinessException, NotFoundException {
        Optional<Usuario> opt=null;
        try {
            opt = repository.findByNombre(nombre);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro el usuario");
        }
        return opt.get();
    }

    @Override
    public void deleteUsuario(long id) throws BusinessException, NotFoundException {
        Optional<Usuario> opt=null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro el usuario");
        }
        else {
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) throws BusinessException, NotFoundException {
        Optional<Usuario> opt=null;
        try {
            opt = repository.findById(usuario.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontro el usuario");
        }
        else {
            try {
                //validaciones
                if (usuario.getNombre().isEmpty()) {
                    throw new BusinessException("El nombre viene vacio.");
                }
                if (usuario.getNombre().length() < 5) {
                    throw new BusinessException("Ingrese mas de cinco caracteres en el nombre");
                }
                if (usuario.getContrasena().isEmpty()) {
                    throw new BusinessException("La contraseña viene vacia");
                }
                if (usuario.getContrasena().length() < 4) {
                    throw new BusinessException("La contraseña es demasiado corta");
                }
                if (usuario.getCorreo().isEmpty()) {
                    throw new BusinessException("El correo viene vacio");
                }
                if (usuario.getCorreo().length() < 10) {
                    throw new BusinessException("Correo incorrecto");
                }
                if (usuario.getRol().isEmpty()) {
                    throw new BusinessException("El rol viene vacio");
                }
                if (usuario.getRol().length() < 5) {
                    throw new BusinessException("Rol invalido");
                }
                if (usuario.getActivo().isEmpty()) {
                    throw new BusinessException("El activo viene vacio");
                }

                Usuario existingUsuario = new Usuario();
                existingUsuario.setId(usuario.getId());
                existingUsuario.setNombre(usuario.getNombre());
                existingUsuario.setContrasena(usuario.getContrasena());
                existingUsuario.setCorreo(usuario.getCorreo());
                existingUsuario.setRol(usuario.getRol());
                existingUsuario.setActivo(usuario.getActivo());
                return repository.save(existingUsuario);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }
}
