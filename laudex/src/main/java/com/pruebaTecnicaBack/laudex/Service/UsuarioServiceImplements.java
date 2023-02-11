package com.pruebaTecnicaBack.laudex.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pruebaTecnicaBack.laudex.Controller.dto.*;
import com.pruebaTecnicaBack.laudex.Model.UsuarioModel;
import com.pruebaTecnicaBack.laudex.Repository.UsuarioRepository;

@Service
public class UsuarioServiceImplements implements UsuarioService {

	
	private UsuarioRepository usuarioRepositorio;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioServiceImplements(UsuarioRepository usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public UsuarioModel guardar(UsuarioRegistroDTO registroDTO) {
		UsuarioModel usuario = new UsuarioModel(registroDTO.getEmail(),
				passwordEncoder.encode(registroDTO.getPassword()));
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioModel usuario = usuarioRepositorio.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(usuario.getEmail(),usuario.getPassword(), false, false, false, false, null);
	}

}