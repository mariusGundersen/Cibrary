package cibrary.repository

import cibrary.domain.Bok
import scala.collection.immutable.HashMap

class BokRepository {

  def lagre(bok:Bok) {
    BokRepository.boker ++ Map(bok.isbn -> bok)
    println("La til bok med isbn: %1", bok.isbn);
  }

  def hent(isbn:String):Option[Bok] =  {
    val bok: Option[Bok] = BokRepository.boker.get(isbn)
    println("Hentet bok: %1", bok.toString)
    return bok
  }

  def hentAlleTitler(): Iterable[Bok] = {
    BokRepository.boker.values
  }
}

object BokRepository {
  val boker: Map[String, Bok] = HashMap()
}