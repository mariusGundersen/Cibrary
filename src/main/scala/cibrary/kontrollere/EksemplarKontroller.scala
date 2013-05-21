package cibrary.kontrollere

import cibrary.domain.{Eksemplar, Bok}

/**
 * Created with IntelliJ IDEA.
 * User: MarGun
 * Date: 21.05.13
 * Time: 14:31
 * To change this template use File | Settings | File Templates.
 */
object EksemplarKontroller {
  def leggTilNyttEksemplar(isbn:String){
    val bok = new Bok("", "")//TODO: Finn bok fra bok repositoriet basert på isbn
    val eksemplar = new Eksemplar(bok);
    //TODO: legg til eksemplar i eksemplar repositoriet
  }
}
