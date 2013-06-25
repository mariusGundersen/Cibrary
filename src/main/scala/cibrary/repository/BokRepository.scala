package cibrary.repository

import cibrary.domain.Bok
import scala.collection.immutable.HashMap

class BokRepository {

  def lagre(bok:Bok) {
    BokRepository.boker = BokRepository.boker ++ Map(bok.isbn -> bok)
    println("La til BookTemplate med isbn: ", bok.isbn);
  }

  def hent(isbn:String):Option[Bok] =  {
    val bok: Option[Bok] = BokRepository.boker.get(isbn)
    println("Hentet BookTemplate: ", bok.toString)
    return bok
  }

  def hentAlleBoker(): Iterable[Bok] = {
    BokRepository.boker.values
  }
}

object BokRepository {
  var boker: Map[String, Bok] = HashMap()
}