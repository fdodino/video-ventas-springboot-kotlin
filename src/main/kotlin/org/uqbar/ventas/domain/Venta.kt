package org.uqbar.ventas.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import org.uqbar.ventas.domain.exceptions.UserException
import java.time.LocalDate

@Entity
class Venta {

    @Id
    @GeneratedValue
    var id: Long? = null

    var cantidad: Int = 1
    var fecha: LocalDate = LocalDate.now()

    @ManyToOne
    lateinit var producto: Producto

    fun validar() {
        if (cantidad < 1) {
            throw UserException("Debe ingresar cantidad")
        }
    }

    fun actualizar(ventaNueva: Venta) {
        cantidad = ventaNueva.cantidad
        producto = ventaNueva.producto
        fecha = ventaNueva.fecha
    }

}
