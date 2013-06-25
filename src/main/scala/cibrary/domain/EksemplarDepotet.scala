package cibrary.domain

class EksemplarDepotet {

  private var eksemplarer:List[Eksemplar]  = List()

  def +=(eksemplar:Eksemplar){
    eksemplarer = eksemplarer :+ eksemplar
  }

  def apply(bok:Bok):List[Eksemplar] = {
    eksemplarer.filter(_.bok == bok)
  }
}
