package org.example.proveedor

import jakarta.persistence.*
import org.example.departamento.Departamento
import org.example.instituto.Instituto

@Entity
@Table(
    name = "Proveedor"
)
class Proveedor(
    @Column(name="cif", unique = true, nullable = false)
    val cif: String,

    @Column(nullable = false)
    val nombre: String,

    @ManyToMany(mappedBy = "proveedores", cascade = [CascadeType.ALL])
    val institutos: List<Instituto>?,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

) {
}