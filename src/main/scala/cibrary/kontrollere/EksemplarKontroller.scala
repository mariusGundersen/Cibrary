package cibrary.kontrollere

import cibrary.domain.{Eksemplar, Bok}

class EksemplarKontroller {
  def leggTilNyttEksemplar(isbn:String){
    val bok = new Bok("", "")//TODO: Finn bok fra bok repositoriet basert på isbn
    val eksemplar = new Eksemplar(bok);
    //TODO: legg til eksemplar i eksemplar repositoriet
  }

  def finnEksemplarerAvBok(bok:Bok){

  }
}
