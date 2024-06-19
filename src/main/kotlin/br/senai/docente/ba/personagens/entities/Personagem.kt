package br.senai.docente.ba.personagens.entities

import org.springframework.data.annotation.Id

data class Personagem(
    @Id var id: String,
    var nome: String,
    var raca: String,
    var origem: String,
)
