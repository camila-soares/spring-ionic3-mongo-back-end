/*
*
* Aula com Nataniel Paiva
*
* Esse projeto poderá ser distribuído da forma que você achar melhor
* O importante é que você aprenda de verdade!
*
 */
package io.spring.mongo.camila.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.spring.mongo.camila.entity.Usuario;


public interface UsuarioRepository extends MongoRepository<Usuario, String> {

		
	List<Usuario> findByNomeLike(String nome);

	Usuario findByEmail(String username);

}

