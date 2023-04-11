package org.uqbar.ventas.repository

import org.springframework.data.repository.CrudRepository
import org.uqbar.ventas.domain.Venta

interface VentaRepository : CrudRepository<Venta, Long>

