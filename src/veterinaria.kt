class veterinaria {
    val listaMascotas = mutableListOf<Mascota>()
    val historialConsultas = mutableMapOf<Mascota, MutableList<ConsultaMedica>>()

    fun agregarMascota(mascota: Mascota) {
        listaMascotas.add(mascota)
        historialConsultas[mascota] = mutableListOf()
    }

    fun registrarConsulta(mascota: Mascota, consulta: ConsultaMedica) {
        historialConsultas[mascota]?.add(consulta)
    }

    fun mostrarHistorial(mascota: Mascota) {
        historialConsultas[mascota]?.forEach { consulta ->
            println("Diagnóstico: ${consulta.diagnostico}, Costo: ${consulta.calcularCosto()}")
        }
    }

    fun modificarPeso(mascota: Mascota, nuevoPeso: Double) {
        mascota.actualizarPeso(nuevoPeso)
    }

    fun modificarEdad(mascota: Mascota) {
        mascota.incrementarEdad()
    }

    fun calcularCostoTotalConsultas(mascota: Mascota): Double {
        return historialConsultas[mascota]?.sumOf { it.calcularCosto() } ?: 0.0
    }

}

