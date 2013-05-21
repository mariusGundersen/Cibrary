package cibrary.domain

import scala.collection.mutable


object EksemplarRepositorie {

  private val bøker:List[Eksemplar] = List()

  def +=(eksemplar:Eksemplar){
    bøker :+ eksemplar
  }

  def apply(bok:Bok) = {

    bøker.filter(_.bok == bok)

  }
}
