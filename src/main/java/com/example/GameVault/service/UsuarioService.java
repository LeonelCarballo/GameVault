package com.example.GameVault.service;

import com.example.GameVault.model.Juego;
import com.example.GameVault.model.Usuario;
import com.example.GameVault.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario obtenerUsuarioLogueado() {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(1L);

        if (usuarioOpt.isPresent()) {
            return usuarioOpt.get();
        } else {
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre("Martin Bernal");
            nuevoUsuario.setEmail("martin@gmail.com");
            nuevoUsuario.setContrasenia("12345678");

            return usuarioRepository.save(nuevoUsuario);
        }
    }

}
