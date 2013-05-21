package cibrary.web

import unfiltered.filter._
import unfiltered.request._
import unfiltered.response._
import cibrary.kontrollere.BokKontroller

class CibraryPlan(bokKontroller:BokKontroller) extends Plan{

	def intent = Intent {
	  case GET(Path("/")) => hentNyBokForm()
	  case GET(Path(Seg("bok" :: "ny" :: navn :: Nil))) => Html5(<h2>{navn}</h2>)
	  case GET(_) => NotFound ~> Html5(<h2>404 - Not Found</h2>)
    case POST(Path(Seg("bok" :: "opprett" :: navn :: Nil))) => Html5(<h2>{navn}</h2>)
  }

  def nyBok(tittel:String, isbn:String):Html5 = {
    bokKontroller.leggTilNyBok(tittel, isbn)
    Html5(<h2>isbn</h2>)
  }

  def hentNyBokForm():Html5 = {
    Html5(<html>
      <body>
        <form method="POST">
          Ny bok:
          <input type="text" name="tittel" />
          <input type="text" name="isbn" />
          <input type="submit" />
        </form>
      </body>
    </html>)
  }
}