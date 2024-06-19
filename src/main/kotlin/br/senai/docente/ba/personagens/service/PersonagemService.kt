package br.senai.docente.ba.personagens.service

import br.senai.docente.ba.personagens.entities.Personagem
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class PersonagemService(
    val db: JdbcTemplate
) {


    fun getAll(): List<Personagem> {
        return db.query("select * from Personagem") { response, _ ->
            Personagem(
                id = response.getInt("id").toString(),
                nome = response.getString("nome"),
                raca = response.getString("raca"),
                origem = response.getString("origem")
            )
        }
    }
}