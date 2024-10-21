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
    val instituto = Instituto("IES Rafael Alberti", "Calle", 500, listOf(), listOf(), Director("12345678H", "Pepe", null, null), listOf(), null)
    val dpto = Departamento("Tecnologia", "Hace tecnologia", instituto, null)

    insertTable(dpto)

}

/**
    CRUD de Dpto.
    Exceptions = ¿Se puede hacer rollback?
    EntityManagerFactory creandose muchas veces = ¿como lo solucionariais?
 */
fun insertTable(dpto: Departamento) {
    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("myunidadsql")
    val em: EntityManager = emf.createEntityManager()
    em.transaction.begin()
    em.persist(dpto)
    em.transaction.commit()
    em.close()

}