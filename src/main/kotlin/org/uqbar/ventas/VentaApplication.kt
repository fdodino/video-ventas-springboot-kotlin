package org.uqbar.ventas

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VentaApplication

fun main(args: Array<String>) {
    runApplication<VentaApplication>(*args)
}