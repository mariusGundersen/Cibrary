package cibrary.repository

import cibrary.domain.Bok
import scala.collection.immutable.HashMap

class BokRepository {

  def lagre(bok:Bok) {
    BokRepository.boker ++ Map(bok.isbn -> bok)
    println("La til boktemplate med isbn: ", bok.isbn);
  }

  def hent(isbn:String):Option[Bok] =  {
    val bok: Option[Bok] = BokRepository.boker.get(isbn)
    println("Hentet boktemplate: ", bok.toString)
    return bok
  }

  def hentAlleBoker(): Iterable[Bok] = {
    BokRepository.boker.values
  }
}

object BokRepository {
  val boker: Map[String, Bok] = HashMap()
}