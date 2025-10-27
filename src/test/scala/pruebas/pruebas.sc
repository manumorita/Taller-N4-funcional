import SubsecuenciaMasLarga._

// PRUEBAS PARA: subindices

// Caso 1: Rango pequeño (2,3) 
// Resultado esperado: Set(List(), List(3), List(2), List(2, 3))
subindices(2,3)

// Caso 2: Rango (0,3)
// Resultado esperado: HashSet con 16 elementos incluyendo List(0,1,2,3), List(0,1,2), etc.
subindices(0,3)

// Caso 3: Rango vacío (5,4) - i > n
// Resultado esperado: Set(List())
subindices(5,4)

// Caso 4: Rango de un solo elemento (3,3)
// Resultado esperado: Set(List(), List(3))
subindices(3,3)

// Caso 5: Rango (1,2)
// Resultado esperado: Set(List(), List(2), List(1), List(1, 2))
subindices(1,2)


// PRUEBAS PARA: subSecuenciasDe

// Caso 1: Secuencia de 3 elementos
// Resultado esperado: HashSet con 8 elementos: List(), List(20), List(30), List(10), 
//                    List(20,30), List(20,10), List(30,10), List(20,30,10)
subSecuenciasDe(Seq(20,30,10))

// Caso 2: Secuencia vacía
// Resultado esperado: Set(List())
subSecuenciasDe(Seq())

// Caso 3: Secuencia de 1 elemento
// Resultado esperado: Set(List(), List(5))
subSecuenciasDe(Seq(5))

// Caso 4: Secuencia de 2 elementos  
// Resultado esperado: Set(List(), List(2), List(1), List(1, 2))
subSecuenciasDe(Seq(1,2))

// Caso 5: Secuencia con elementos repetidos
// Resultado esperado: HashSet con 6 elementos: List(), List(1), List(2), 
//                    List(1,1), List(1,2), List(1,1,2)
subSecuenciasDe(Seq(1,1,2))


// PRUEBAS PARA: incremental

// Caso 1: Secuencia incremental estricta
// Resultado esperado: true
incremental(Seq(1,2,3,4))

// Caso 2: Secuencia no incremental (decreciente)
// Resultado esperado: false
incremental(Seq(4,3,2,1))

// Caso 3: Secuencia con elementos iguales
// Resultado esperado: false
incremental(Seq(1,2,2,3))

// Caso 4: Secuencia vacía
// Resultado esperado: true
incremental(Seq())

// Caso 5: Secuencia de un elemento
// Resultado esperado: true
incremental(Seq(5))


// PRUEBAS PARA: subSecuenciasInc

// Caso 1: Secuencia pequeña
// Resultado esperado: HashSet(List(30), List(), List(20), List(10), List(20,30))
subSecuenciasInc(Seq(20,30,10))

// Caso 2: Secuencia incremental
// Resultado esperado: HashSet con 8 elementos (todas las subsecuencias son incrementales)
subSecuenciasInc(Seq(10,20,30))

// Caso 3: Secuencia decreciente
// Resultado esperado: HashSet(List(1), List(3), List(), List(2))
subSecuenciasInc(Seq(3,2,1))

// Caso 4: Secuencia vacía
// Resultado esperado: Set(List())
subSecuenciasInc(Seq())

// Caso 5: Secuencia con patrón mixto
// Resultado esperado: HashSet con subsecuencias crecientes como List(1,3,4), List(1,2,4), etc.
subSecuenciasInc(Seq(1,3,2,4))


// PRUEBAS PARA: subsecuenciaIncrementalMasLarga

// Caso 1: Del ejemplo del problema
// Resultado esperado: List(10, 15, 16, 17)
subsecuenciaIncrementalMasLarga(Seq(20,30,10,40,15,16,17))

// Caso 2: Secuencia completamente incremental
// Resultado esperado: List(1, 2, 3, 4, 5)
subsecuenciaIncrementalMasLarga(Seq(1,2,3,4,5))

// Caso 3: Secuencia completamente decreciente
// Resultado esperado: List(1) (o cualquier elemento individual)
subsecuenciaIncrementalMasLarga(Seq(5,4,3,2,1))

subsecuenciaIncrementalMasLarga(Seq())


// Caso 4: Secuencia con múltiples subsecuencias largas
// Resultado esperado: List(1, 10, 20, 30)
subsecuenciaIncrementalMasLarga(Seq(1,10,2,20,3,30))

// Caso 5: Caso del PDF extendido
// Resultado esperado: List(10, 11, 12, 13, 14)
subsecuenciaIncrementalMasLarga(Seq(20,30,10,40,15,16,17,11,12,13,14))


// PRUEBAS PARA: ssimlComenzandoEn

val secuenciaTest = Seq(10,9,8,7,6,5,4,3,2,1,22,21,20,19,18,17,16,15,14,13,12,11)

// Caso 1: Comenzando en posición válida (índice 4 = elemento 6)
// Resultado esperado: List(6, 22)
ssimlComenzandoEn(4, secuenciaTest)

// Caso 2: Comenzando en posición final (índice 12 = elemento 20)
// Resultado esperado: List(20)
ssimlComenzandoEn(12, secuenciaTest)

// Caso 3: Comenzando en posición con mejor subsecuencia
// Resultado esperado: List(1, 3, 4, 5)
ssimlComenzandoEn(0, Seq(1,3,2,4,5))

// Caso 4: Comenzando en posición sin opciones válidas
// Resultado esperado: List(10)
ssimlComenzandoEn(0, Seq(10,9,8,7))

// Caso 5: Índice fuera de rango
// Resultado esperado: List()
ssimlComenzandoEn(10, Seq(1,2,3))


// PRUEBAS PARA: subSecIncMasLargaV2

// Caso 1: Del ejemplo del problema
// Resultado esperado: List(10, 15, 16, 17)
subSecIncMasLargaV2(Seq(20,30,10,40,15,16,17))

// Caso 2: Caso del PDF extendido
// Resultado esperado: List(10, 11, 12, 13, 14)
subSecIncMasLargaV2(Seq(20,30,10,40,15,16,17,11,12,13,14))

// Caso 3: Secuencia con patrón complejo
// Resultado esperado: List(10, 22)
subSecIncMasLargaV2(Seq(10,9,8,7,6,5,4,3,2,1,22,21,20,19,18,17,16,15,14,13,12,11))

// Caso 4: Secuencia vacía
// Resultado esperado: List()
subSecIncMasLargaV2(Seq())

// Caso 5: Secuencia con un solo elemento
// Resultado esperado: List(5)
subSecIncMasLargaV2(Seq(5))