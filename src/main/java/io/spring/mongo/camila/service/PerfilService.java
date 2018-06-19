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

import io.spring.mongo.camila.entity.Perfil;
import io.spring.mongo.camila.repository.PerfilRepository;


@Service
public class PerfilService {

    @Autowired
    PerfilRepository perfilRepository;

    public List<Perfil> listaPerfil() {
        return perfilRepository.findAll();
    }
    
    public Page<Perfil> listaPaginada(int count, int page){
    	Pageable pages = new PageRequest(count, count);
		return perfilRepository.findAll(pages);
    }
    
    public List<Perfil> buscaPorNome(String nome){
		return perfilRepository.findByNomeLike(nome);
    	
    }

    public Perfil salvarPerfil(Perfil perfiladd) {
        return perfilRepository.save(perfiladd);
    }

    public void deletePerfil(String id) {
    	perfilRepository.delete(id);
    }

    public Perfil getById(String id) {
        return perfilRepository.findOne(id);
    }

	

	

}
