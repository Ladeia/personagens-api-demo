package br.senai.docente.ba.personagens.controller

import br.senai.docente.ba.personagens.entities.Personagem
import br.senai.docente.ba.personagens.service.PersonagemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody


@RestController
@RequestMapping("/personagem")
class PersonagemController(
    @Autowired val service: PersonagemService
) {



//    @PostMapping
//    fun createPersonagem(@RequestBody body: PersonagemPostRequest){
//
//    }

    @GetMapping("/test")
    fun test():  String{
        return "test:ok"
    }

    @GetMapping
    fun personagens():  List<Personagem>{
        return service.getAll()
    }

//    @GetMapping("/{personagemId}")
//    fun personagens(@PathVariable personagemId:String):  List<Personagem>{
//
//    }


}