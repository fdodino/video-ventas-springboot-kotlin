package org.uqbar.ventas.service

import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import org.uqbar.ventas.domain.Venta
import org.uqbar.ventas.repository.ProductoRepository
import org.uqbar.ventas.repository.VentaRepository
import java.sql.SQLException

@Service
class VentaService {

    @Autowired
    lateinit var ventaRepository: VentaRepository

    @Autowired
    lateinit var productoRepository: ProductoRepository

    @Transactional(Transactional.TxType.NEVER)
    fun getVentas() = ventaRepository.findAll()

    @Transactional(Transactional.TxType.NEVER)
    fun getVenta(id: Long): Venta =
        ventaRepository.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "La venta con identificador $id no existe")
        }

    @Transactional(Transactional.TxType.REQUIRED)
    fun actualizarVenta(ventaActualizada: Venta, id: Long): Venta {
        val venta = getVenta(id)
        venta.actualizar(ventaActualizada)
        ventaRepository.save(venta)
        return ventaActualizada
    }

    @Transactional(Transactional.TxType.REQUIRED)
    fun crearVenta(ventaNueva: Venta) {
        if (ventaNueva.producto.id == null) {
            productoRepository.save(ventaNueva.producto)
        }
        ventaRepository.save(ventaNueva)
    }

    @Transactional(Transactional.TxType.REQUIRED)
    fun eliminarVenta(id: Long) {
        ventaRepository.deleteById(id)
    }

}