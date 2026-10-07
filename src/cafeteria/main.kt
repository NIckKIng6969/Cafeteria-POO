package cafeteria

fun main() {
    println("=== CAFETERIA POO ===")
    println()

    val pedido = Pedido("Nicolas")

    val cafe = Cafe()
    cafe.tamanioOnzas = 16
    pedido.agregar(cafe)

    pedido.agregar(Te(nombre = "Te de manzanilla", hierba = "manzanilla"))
    pedido.agregar(Jugo(nombre = "Jugo de naranja", precioBase = 7.5, fruta = "naranja"))
    println()

    pedido.mostrar()
    println()

    pedido.prepararTodo()
    println()

    pedido.descuento = 0.10
    println("Se aplico un descuento del 10%")
    pedido.mostrar()
    println()

    // Los setters rechazan estos valores a proposito:
    pedido.descuento = 0.80
    cafe.tamanioOnzas = 40
}
