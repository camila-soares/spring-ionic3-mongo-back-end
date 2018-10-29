/*
*
* Aula com Nataniel Paiva
*
* Esse projeto poderá ser distribuído da forma que você achar melhor
* O importante é que você aprenda de verdade!
*
 */
package io.spring.mongo.camila.controller;

import java.security.Principal;
import java.util.List;

import io.spring.mongo.camila.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import io.spring.mongo.camila.entity.Usuario;
import io.spring.mongo.camila.service.UsuarioService;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public List<Usuario> listar() {
        return this.usuarioService.listaUsuario();
    }
    
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public Usuario getById(@PathVariable String id) {
        return this.usuarioService.getById(id);
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public Usuario salvar(@RequestBody Usuario usuario) {
        return this.usuarioService.salvarUsuario(usuario);
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.PUT)
    public Usuario editar(@RequestBody Usuario usuario) {
        return this.usuarioService.salvarUsuario(usuario);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable String id) {
        this.usuarioService.deleteUsuario(id);
    }
    
    @RequestMapping(value="/usuario/{page}/{count}", method = RequestMethod.GET)
    public Page<Usuario> listaPaginada(@PathVariable int page, @PathVariable int count){
		return this.usuarioService.listaPaginada(count, page);
    }
    
    @RequestMapping(value="/usuario/{nome}/nome", method = RequestMethod.GET)
    public List<Usuario> listaPaginada(@PathVariable String nome){
    	return this.usuarioService.buscaPorNome(nome);
    }

    @RequestMapping(value="/usuario/logado", method = RequestMethod.GET)
    @ResponseBody
    public Usuario currentName(Principal principal){
        Usuario usuario = this.usuarioRepository.findByEmail ( principal.getName () );
        return usuario;
    }

}
