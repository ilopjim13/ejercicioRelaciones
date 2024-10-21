package org.example.departamento

import jakarta.persistence.*
import org.example.instituto.Instituto


@Entity
@Table(name = "departamento")
class Departamento(

    @Column(name = "nombre", nullable = false, length = 50)
    val nombre: String,

    @Column(name = "descripcion")
    val descripcion: String?,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_instituto")
    val instituto: Instituto?,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?){

}