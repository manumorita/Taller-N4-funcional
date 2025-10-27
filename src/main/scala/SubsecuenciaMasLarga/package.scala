package object SubsecuenciaMasLarga {
  type Secuencia = Seq[Int]
  type Subsecuencia = Seq[Int]


  def subindices(i: Int, n: Int): Set[Seq[Int]] = {
    // Caso base: si i > n, solo retornamos la secuencia vacía
    if (i > n) Set(Seq())
    else {
      // Para cada subsecuencia que no incluye i
      val sinI = subindices(i + 1, n)
      // Para cada subsecuencia que incluye i
      val conI = for {
        subseq <- subindices(i + 1, n)
      } yield i +: subseq

      sinI ++ conI
    }
  }

  def subSecuenciaAsoc(s: Secuencia, inds: Seq[Int]): Subsecuencia = {
    for {
      idx <- inds
      if idx >= 0 && idx < s.length
    } yield s(idx)
  }

  def subSecuenciasDe(s: Secuencia): Set[Subsecuencia] = {
    val todosIndices = subindices(0, s.length - 1)
    for {
      indices <- todosIndices
    } yield subSecuenciaAsoc(s, indices)
  }

  def incremental(s: Subsecuencia): Boolean = {
    s match {
      case Seq() => true
      case Seq(_) => true
      case _ =>
        val pares = for {
          i <- 0 until s.length - 1
        } yield (s(i), s(i + 1))

        pares.forall { case (a, b) => a < b }
    }
  }

  def subSecuenciasInc(s: Secuencia): Set[Subsecuencia] = {
    val todasSubsecuencias = subSecuenciasDe(s)
    for {
      subseq <- todasSubsecuencias
      if incremental(subseq)
    } yield subseq
  }

  def subsecuenciaIncrementalMasLarga(s: Secuencia): Subsecuencia = {
    val subsecInc = subSecuenciasInc(s)

    if (subsecInc.isEmpty) Seq()
    else {
      val maxLongitud = (for (subsec <- subsecInc) yield subsec.length).max

      (for {
        subsec <- subsecInc
        if subsec.length == maxLongitud
      } yield subsec).head
    }
  }

  def ssimlComenzandoEn(i: Int, s: Secuencia): Subsecuencia = {
    if (i >= s.length) Seq()
    else {
      val elementoActual = s(i)

      // Encontrar todas las posibles continuaciones válidas
      val continuaciones = for {
        j <- i + 1 until s.length
        if s(j) > elementoActual
        continuacion = ssimlComenzandoEn(j, s)
      } yield continuacion

      // Encontrar la continuación más larga
      val mejorContinuacion = if (continuaciones.nonEmpty) {
        continuaciones.maxBy(_.length)
      } else {
        Seq()
      }

      // Combinar el elemento actual con la mejor continuación
      elementoActual +: mejorContinuacion
    }
  }

  def subSecIncMasLargaV2(s: Secuencia): Subsecuencia = {
    if (s.isEmpty) Seq()
    else {
      val todasComienzos = for {
        i <- 0 until s.length
        subseq = ssimlComenzandoEn(i, s)
      } yield subseq

      todasComienzos.maxBy(_.length)
    }
  }

}
