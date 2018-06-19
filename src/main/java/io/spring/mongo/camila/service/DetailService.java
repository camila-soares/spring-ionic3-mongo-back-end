package io.spring.mongo.camila.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.spring.mongo.camila.config.MyUserDatails;
import io.spring.mongo.camila.entity.Usuario;
import io.spring.mongo.camila.repository.UsuarioRepository;

@Service
public class DetailService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);
		
		if(usuario == null){
			throw new UsernameNotFoundException("Usuário ou senha inválidos");
		}
		return new MyUserDatails(usuario);
	}

}
