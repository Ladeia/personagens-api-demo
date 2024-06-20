package br.senai.docente.ba.personagens.controller

import br.senai.docente.ba.personagens.entities.Personagem
import br.senai.docente.ba.personagens.entities.PersonagemPostRequest
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

    @GetMapping("/hello")
    fun hello(): String{
        return "world"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): List<Personagem> {
        return service.getbyid(id)
    }


    @PostMapping
    fun createPersonagem(@RequestBody body: PersonagemPostRequest): String{
        service.insertPersonagem(body)
        return """"{
            "msg":"usuario cadastrado com sucesso",
            "status": 200
        }"""
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