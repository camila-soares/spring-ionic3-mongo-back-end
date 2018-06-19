/*
*
* Aula com Nataniel Paiva
*
* Esse projeto poderá ser distribuído da forma que você achar melhor
* O importante é que você aprenda de verdade!
*
 */
package io.spring.mongo.camila.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.spring.mongo.camila.entity.Usuario;
import io.spring.mongo.camila.repository.UsuarioRepository;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listaUsuario() {
        return usuarioRepository.findAll();
    }
    
    public Page<Usuario> listaPaginada(int count, int page){
    	Pageable pages = new PageRequest(count, count);
		return usuarioRepository.findAll(pages);
    }
    
    public List<Usuario> buscaPorNome(String nome){
		return usuarioRepository.findByNomeLike(nome);
    	
    }

    public Usuario salvarUsuario(Usuario usuarioAdd) {
        return usuarioRepository.save(usuarioAdd);
    }

    public void deleteUsuario(String id) {
        usuarioRepository.delete(id);
    }

    public Usuario getById(String id) {
        return usuarioRepository.findOne(id);
    }

}
