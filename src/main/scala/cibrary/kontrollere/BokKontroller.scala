package cibrary.kontrollere
import cibrary.domain.Bok

object BokKontroller {

	def leggTilNyBok(tittel:String, isbn:String):Bok = {
		new Bok(tittel, isbn);
	}
}