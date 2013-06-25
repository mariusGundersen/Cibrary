package cibrary.web

import unfiltered.filter._
import unfiltered.request._
import unfiltered.response._
import cibrary.kontrollere.BokKontroller
import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import cibrary.domain.Bok
import cibrary.web.templates.boktemplate

class CibraryPlan(bokKontroller:BokKontroller) extends Plan{


  def intent = Intent {
    case GET(Path("/boktemplate/opprett")) => boktemplate.opprettBok()
    case GET(Path("/boktemplate/list")) => hentAlleBoker()
    case req @ POST(Path("/boktemplate/opprett")) => nyBok(req)
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


}