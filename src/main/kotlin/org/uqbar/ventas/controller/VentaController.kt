package org.uqbar.ventas.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.uqbar.ventas.domain.Venta
import org.uqbar.ventas.service.VentaService

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/venta")
class VentaController {

    @Autowired
    private lateinit var ventaService: VentaService

    @GetMapping("")
    fun getVentas() = ventaService.getVentas()

    @GetMapping("/{id}")
    fun getZona(@PathVariable id: Long) = ventaService.getVenta(id)

    @PostMapping()
    fun crearVenta(@RequestBody ventaNueva: Venta) = ventaService.crearVenta(ventaNueva)

    @PutMapping("/{id}")
    fun actualizarVenta(@RequestBody ventaActualizada: Venta, @PathVariable id: Long) =
        ventaService.actualizarVenta(ventaActualizada, id)

    @DeleteMapping("/{id}")
    fun eliminarVenta(@PathVariable id: Long) =
        ventaService.eliminarVenta(id)
}