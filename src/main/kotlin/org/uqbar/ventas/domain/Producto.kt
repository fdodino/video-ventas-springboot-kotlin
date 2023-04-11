package org.uqbar.ventas.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.uqbar.ventas.domain.exceptions.UserException

@Entity
class Producto {
    @Id
    @GeneratedValue
    var id: Long? = null

    var descripcion: String = ""

    fun validar() {
        if (descripcion.isEmpty()) {
            throw UserException("La descripción no puede estar vacía")
        }
    }

    fun actualizar(productoActualizado: Producto) {
        descripcion = productoActualizado.descripcion
    }


}