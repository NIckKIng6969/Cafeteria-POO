package cafeteria

import kotlin.math.roundToInt

// Encapsulamiento: la lista de bebidas es privada, solo se toca con agregar().
class Pedido(val cliente: String) {

    private val bebidas = mutableListOf<Bebida>()

    // Setter propio: el descuento solo puede ir de 0% a 50%.
    var descuento: Double = 0.0
        set(valor) {
            if (valor in 0.0..0.5) {
                field = valor
            } else {
                println("El descuento debe estar entre 0% y 50%.")
            }
        }

    // Getter propio: el total se calcula solo, no se guarda.
    val total: Double
        get() = bebidas.sumOf { it.precio } * (1 - descuento)

    fun agregar(bebida: Bebida) {
        bebidas.add(bebida)
        println("  + ${bebida.nombre} se agrego al pedido de $cliente")
    }

    fun mostrar() {
        println("Pedido de $cliente")
        for (bebida in bebidas) {
            println("  - ${bebida.ficha()}")
        }
        println("  Descuento: ${(descuento * 100).roundToInt()}%")
        println("  TOTAL: S/ ${"%.2f".format(total)}")
    }

    fun prepararTodo() {
        println("Preparando el pedido de $cliente:")
        for (bebida in bebidas) {
            println("  * ${bebida.preparar()}")
        }
    }
}
