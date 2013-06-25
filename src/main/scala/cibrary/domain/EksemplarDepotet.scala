package cibrary.domain

import scala.collection.mutable.MutableList


object EksemplarDepotet {

  private var bøker:List[Eksemplar]  = List()

  def +=(eksemplar:Eksemplar){
    bøker = bøker :+ eksemplar
  }

  def apply(bok:Bok) = {
    bøker.filter(_.bok == bok)

  }
}
