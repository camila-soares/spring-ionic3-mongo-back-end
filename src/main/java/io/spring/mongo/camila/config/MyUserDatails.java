package io.spring.mongo.camila.config;



import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.spring.mongo.camila.entity.Usuario;

public class MyUserDatails extends Usuario implements UserDetails{
	private static final long serialVersionUID = 1L;

	public MyUserDatails(Usuario usuario) {
	  super(usuario);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getPerfis();
	}

	@Override
	public String getPassword() {
		return getSenha();
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	  return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	

}
