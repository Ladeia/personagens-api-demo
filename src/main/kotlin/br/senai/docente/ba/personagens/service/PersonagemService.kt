package br.senai.docente.ba.personagens.service

import br.senai.docente.ba.personagens.entities.Personagem
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service

@Service
class PersonagemService(
    val db: JdbcTemplate
) {


    fun getAll(): List<Personagem> {
        return db.query("select * from PersonagemTruncated") { response, _ ->
            Personagem(
                id = response.getInt("id"),
                nome = response.getString("nome"),
                raca = response.getString("raca"),
                origem = response.getString("origem")
            )
        }
    }

    fun findById(id: Int): List<Personagem> {
        return db.query("select * from PersonagemTruncated where id = ?", id.toString()) { response, _ ->
            Personagem(
                id = response.getInt("id"),
                nome = response.getString("nome"),
                raca = response.getString("raca"),
                origem = response.getString("origem")
            )
        }
    }
}