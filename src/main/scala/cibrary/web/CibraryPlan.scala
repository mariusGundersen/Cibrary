package cibrary.web

import unfiltered.filter._
import unfiltered.request._
import unfiltered.response._
import cibrary.kontrollere.BokKontroller
import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import cibrary.domain.Bok

class CibraryPlan(bokKontroller:BokKontroller) extends Plan{


	def intent = Intent {
	  case GET(Path("/")) => Html5(<h1>Cibrary</h1>)
    case GET(Path("/bok/opprett")) => hentNyBokForm()
    case GET(Path("/bok/list")) => hentAlleBoker()
	  case GET(_) => NotFound ~> Html5(<h2>404 - Not Found</h2>)
    case req @ POST(Path("/bok/opprett")) => nyBok(req)
	}

  def nyBok(req : HttpRequest[HttpServletRequest]):Html5 = {
    var isbn = req.parameterValues("isbn");
    var tittel = req.parameterValues("tittel");
    bokKontroller.leggTilNyBok(tittel.head, isbn.head);
    Html5(<h2>Bok lagt til</h2>)
  }

  def hentAlleBoker(): Html5 = {
    val boker = bokKontroller.hentAlleBoker()
    var x = ""
     boker.foreach(bok => x += "<li>Tittel: " + bok.tittel +", ISBN: " + bok.isbn + "</li>")
    Html5(<html>
      <ul>
        {x}
      </ul>
    </html>)
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