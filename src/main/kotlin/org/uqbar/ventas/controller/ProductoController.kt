package org.uqbar.ventas.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.uqbar.ventas.domain.Producto
import org.uqbar.ventas.service.ProductoService

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/producto")
class ProductoController {

    @Autowired
    private lateinit var productoService: ProductoService

    @GetMapping("")
    fun getProductos() = productoService.getProductos()

    @GetMapping("/{id}")
    fun getZona(@PathVariable id: Long) = productoService.getProducto(id)

    @PostMapping()
    fun crearProducto(@RequestBody productoNuevo: Producto) = productoService.crearProducto(productoNuevo)

    @PutMapping("/{id}")
    fun crearProducto(@RequestBody productoActualizado: Producto, @PathVariable id: Long) =
        productoService.modificarProducto(productoActualizado, id)

    @DeleteMapping("/{id}")
    fun eliminarProducto(@PathVariable id: Long) =
        productoService.eliminarProducto(id)
}