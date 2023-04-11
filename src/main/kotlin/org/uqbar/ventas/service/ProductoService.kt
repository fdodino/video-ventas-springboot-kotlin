package org.uqbar.ventas.service

import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import org.uqbar.ventas.domain.Producto
import org.uqbar.ventas.repository.ProductoRepository

@Service
class ProductoService {

    @Autowired
    lateinit var productoRepository: ProductoRepository

    @Transactional(Transactional.TxType.NEVER)
    fun getProductos() = productoRepository.findAll()

    @Transactional(Transactional.TxType.NEVER)
    fun getProducto(id: Long) = productoRepository.findById(id)
        .orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "El producto con identificador $id no existe")
        }

    @Transactional(Transactional.TxType.REQUIRED)
    fun crearProducto(producto: Producto): Producto {
        producto.validar()
        productoRepository.save(producto)
        return producto
    }

    @Transactional(Transactional.TxType.REQUIRED)
    fun modificarProducto(productoActualizado: Producto, id: Long): Producto {
        val producto = getProducto(id)
        producto.validar()
        producto.actualizar(productoActualizado)
        productoRepository.save(producto)
        return producto
    }

    @Transactional(Transactional.TxType.REQUIRED)
    fun eliminarProducto(id: Long) {
        productoRepository.deleteById(id)
    }

}