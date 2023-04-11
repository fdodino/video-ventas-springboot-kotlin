package org.uqbar.ventas.repository

import org.springframework.data.repository.CrudRepository
import org.uqbar.ventas.domain.Producto
import java.util.*

interface ProductoRepository : CrudRepository<Producto, Long> {
    fun findByDescripcion(descripcion: String): Optional<Producto>
}