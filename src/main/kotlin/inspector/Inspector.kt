package org.example.inspector

import jakarta.persistence.*
import org.example.instituto.Instituto

@Entity
@Table(name = "inspector")
class Inspector(
    @Column(name = "dni", unique = true, nullable = false)
    val dni: String,

    @Column(name = "nombre")
    val nombre: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_instituto")
    val institutos: Instituto?,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
) {
}