//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(){
    val veterinaria = veterinaria()
    while (true) {
        println("Menú de la Veterinaria")
        println("1. Agregar nueva mascota")
        println("2. Registrar consulta médica")
        println("3. Mostrar historial de consultas")
        println("4. Modificar peso de una mascota")
        println("5. Modificar edad de una mascota")
        println("6. Calcular costo total de consultas")
        println("7. Salir")
        print("Seleccione una opción: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Ingrese el nombre de la mascota: ")
                val nombre = readLine().orEmpty()
                print("Ingrese la especie de la mascota: ")
                val especie = readLine().orEmpty()
                print("Ingrese la edad de la mascota: ")
                val edad = readLine()?.toIntOrNull() ?: 0
                print("Ingrese el peso de la mascota: ")
                val peso = readLine()?.toDoubleOrNull() ?: 0.0

                val mascota = Mascota(nombre, especie, edad, peso)
                veterinaria.agregarMascota(mascota)
                println("Mascota agregada exitosamente.")
            }
            2 -> {
                print("Ingrese el nombre de la mascota para la consulta: ")
                val nombreMascota = readLine().orEmpty()
                val mascota = veterinaria.listaMascotas.find { it.nombre == nombreMascota }
                if (mascota != null) {
                    print("Ingrese el diagnóstico: ")
                    val diagnostico = readLine().orEmpty()
                    print("Ingrese el costo base de la consulta: ")
                    val costoBase = readLine()?.toDoubleOrNull() ?: 0.0
                    print("¿Incluye medicación? (si/no): ")
                    val incluyeMedicacion = readLine().orEmpty().lowercase() == "si"

                    val consulta = ConsultaMedica(mascota, diagnostico, costoBase, incluyeMedicacion)
                    veterinaria.registrarConsulta(mascota, consulta)
                    println("Consulta registrada correctamente.")
                } else {
                    println("Mascota no encontrada.")
                }
            }
            3 -> {
                print("Ingrese el nombre de la mascota: ")
                val nombreMascota = readLine().orEmpty()
                val mascota = veterinaria.listaMascotas.find { it.nombre == nombreMascota }
                if (mascota != null) {
                    veterinaria.mostrarHistorial(mascota)
                } else {
                    println("Mascota no encontrada.")
                }
            }
            4 -> {
                print("Ingrese el nombre de la mascota: ")
                val nombreMascota = readLine().orEmpty()
                val mascota = veterinaria.listaMascotas.find { it.nombre == nombreMascota }
                if (mascota != null) {
                    print("Ingrese el nuevo peso: ")
                    val nuevoPeso = readLine()?.toDoubleOrNull() ?: 0.0
                    veterinaria.modificarPeso(mascota, nuevoPeso)
                    println("Peso actualizado correctamente.")
                } else {
                    println("Mascota no encontrada.")
                }
            }
            5 -> {
                print("Ingrese el nombre de la mascota: ")
                val nombreMascota = readLine().orEmpty()
                val mascota = veterinaria.listaMascotas.find { it.nombre == nombreMascota }
                if (mascota != null) {
                    veterinaria.modificarEdad(mascota)
                    println("Edad incrementada en 1 año.")
                } else {
                    println("Mascota no encontrada.")
                }
            }
            6 -> {
                print("Ingrese el nombre de la mascota: ")
                val nombreMascota = readLine().orEmpty()
                val mascota = veterinaria.listaMascotas.find { it.nombre == nombreMascota }
                if (mascota != null) {
                    val totalCosto = veterinaria.calcularCostoTotalConsultas(mascota)
                    println("El costo total de todas las consultas es: $$totalCosto")
                } else {
                    println("Mascota no encontrada.")
                }
            }
            7 -> {
                println("Saliendo del sistema.")
                break
            }
            else -> println("Opción no válida, intente de nuevo.")
        }
    }
}