package cibrary.kontrollere
import cibrary.domain.Bok
import cibrary.repository.BokRepository

class BokKontroller(var bokRepository: BokRepository) {

  def leggTilNyBok(tittel:String, isbn:String):Bok = {
		val bok = new Bok(tittel, isbn);
    bokRepository.lagre(bok)
    return bok
	}

  def hentAlleBoker(): Iterable[Bok] = {
    bokRepository.hentAlleBoker();
  }

}