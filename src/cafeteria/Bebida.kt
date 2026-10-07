package cafeteria

// Interfaz: toda bebida del local debe saber prepararse.
interface Preparar {
    fun preparar(): String
}

// Clase abstracta: no se puede crear una "Bebida" generica.
abstract class Bebida(val nombre: String, open var precioBase: Double) : Preparar {

    // Cada subclase dice a que categoria pertenece.
    abstract val categoria: String

    // Propiedad con setter propio: el tamanio solo puede estar entre 8 y 24 onzas.
    open var tamanioOnzas: Int = 12
        set(valor) {
            if (valor in 8..24) {
                field = valor
            } else {
                println("El tamanio debe estar entre 8 y 24 onzas.")
            }
        }

    // Propiedad con getter propio: cada onza extra cuesta 5% mas.
    val precio: Double
        get() = precioBase * (1 + (tamanioOnzas - 12) * 0.05)

    init {
        println("Registrando la bebida: $nombre")
    }

    open fun ficha(): String =
        "$nombre ($categoria) - $tamanioOnzas oz - S/ ${"%.2f".format(precio)}"

    abstract override fun preparar(): String
}


// Herencia: BebidaCaliente es una Bebida.
open class BebidaCaliente(
    nombre: String,
    precioBase: Double,
    var temperatura: Int
) : Bebida(nombre, precioBase) {

    override val categoria = "caliente"

    override fun preparar(): String = "Calentando $nombre a $temperatura grados"

    // Constructor secundario: usa 80 grados por defecto.
    constructor(nombre: String, precioBase: Double) : this(nombre, precioBase, 80)
}


class Cafe(
    nombre: String = "Cafe americano",
    precioBase: Double = 6.0,
    var tipoGrano: String = "arabica"
) : BebidaCaliente(nombre, precioBase) {

    override fun preparar(): String =
        "${super.preparar()} y moliendo grano $tipoGrano"
}


class Te(
    nombre: String = "Te verde",
    precioBase: Double = 5.0,
    var hierba: String = "matcha"
) : BebidaCaliente(nombre, precioBase) {

    override fun preparar(): String =
        "${super.preparar()} e infusionando $hierba"
}


class Jugo(
    nombre: String,
    precioBase: Double,
    var fruta: String
) : Bebida(nombre, precioBase) {

    override val categoria = "frio"

    override fun preparar(): String = "Licuando $fruta para preparar el $nombre"
}
