package org.example.instituto

import jakarta.persistence.*
import org.example.departamento.Departamento
import org.example.director.Director
import org.example.inspector.Inspector
import org.example.proveedor.Proveedor

@Entity
@Table(name = "instituto")
class Instituto(
    @Column(name = "nombre", nullable = false, length = 50)
    val nombre: String,

    @Column(name = "direccion")
    val direccion: String?,

    @Transient
    val nEstudiantes: Int,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "instituto")
    val dptos: List<Departamento>?,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "institutos")
    val inspectores: List<Inspector>?,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "director")
    val director: Director?,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "instituto_proveedor",
        joinColumns = [JoinColumn(name="id_instituto")],
        inverseJoinColumns = [JoinColumn(name="id_proveedor")]
    )
    val proveedores: List<Proveedor>?,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,


    ) {
}