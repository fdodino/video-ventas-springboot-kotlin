package org.uqbar.ventas

import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.uqbar.ventas.domain.*
import org.uqbar.ventas.repository.ProductoRepository
import org.uqbar.ventas.repository.VentaRepository

/**
 *
 * Para explorar otras opciones
 * https://stackoverflow.com/questions/38040572/spring-boot-loading-initial-data
 */
@Service
class VentasBootstrap : InitializingBean {

    @Autowired
    private lateinit var ventaRepository: VentaRepository

    @Autowired
    private lateinit var productoRepository: ProductoRepository

    lateinit var cuadernoA4: Producto
    lateinit var hojaCansonA5: Producto

    fun initProductos() {
        cuadernoA4 = Producto().apply { descripcion = "Cuaderno A4" }
        crearProducto(cuadernoA4)
        hojaCansonA5 = Producto().apply { descripcion = "Hoja Canson A5" }
        crearProducto(hojaCansonA5)
    }

    fun crearProducto(producto: Producto) {
        val productoEnRepo = productoRepository.findByDescripcion(producto.descripcion)
        if (productoEnRepo.isPresent()) {
            producto.id = productoEnRepo.get().id
        } else {
            productoRepository.save(producto)
        }
    }



    override fun afterPropertiesSet() {
        println("************************************************************************")
        println("Running initialization")
        println("************************************************************************")
        this.initProductos()
    }

}