package cibrary.kontrollere

import cibrary.domain.{EksemplarDepotet, Eksemplar, Bok}
import cibrary.repository.BokRepository

class EksemplarKontroller(depotet: EksemplarDepotet, bøker: BokRepository) {
  def leggTilNyttEksemplar(isbn: String){
    val bok = bøker.hent(isbn)
    val eksemplar = new Eksemplar(bok.getOrElse(throw new Error("bok fantes ikke")))
    depotet += eksemplar
  }

  def finnEksemplarerAvBok(bok: Bok):List[Eksemplar] = {
    depotet(bok)
  }
}
