package org.example

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence
import org.example.departamento.Departamento
import org.example.director.Director
import org.example.instituto.Instituto

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val em = EntityManagerFact

    val instituto = Instituto("IES Rafael Alberti", "Calle", 500, listOf(), listOf(), Director("12345678H", "Pepe", null, null), listOf(), null)
    val dpto = Departamento("Tecnologia", "Hace tecnologia", instituto, null)

    insertTable(dpto, em)

}

/**
    CRUD de Dpto.
    Exceptions = ¿Se puede hacer rollback?
    EntityManagerFactory creandose muchas veces = ¿como lo solucionariais?
 */
fun insertTable(dpto: Departamento, em: EntityManagerFact) {
    em.begin()
    em.persist(dpto)
    em.commit()
    em.close()
}


fun selectTable() {

}

fun updateTable() {

}

fun deleteTable() {

}

object EntityManagerFact{
    private val em: EntityManager = Persistence.createEntityManagerFactory("myunidadsql").createEntityManager()

    fun commit() {
        em.transaction.commit()
    }

    fun begin() {
        em.transaction.begin()

    }

    fun persist(dpto:Any) {
        em.persist(dpto)
    }

    fun close() {
        em.close()
    }
}