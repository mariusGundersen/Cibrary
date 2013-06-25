package cibrary.web

import unfiltered.filter._
import unfiltered.request._
import unfiltered.response._
import cibrary.kontrollere._
import javax.servlet.http.HttpServletRequest
import cibrary.domain.Bok
import cibrary.web.templates.BookTemplate

class CibraryPlan(bokKontroller:BokKontroller, eksemplarKontroller: EksemplarKontroller) extends Plan{

  def intent = Intent {
    case GET(Path("/bok/opprett")) => BookTemplate.opprettBok()
    case GET(Path("/bok/list")) => hentAlleBoker()
    case req @ POST(Path("/bok/opprett")) => nyBok(req)
    case GET(Path(Seg("eksemplar" :: "info" :: (isbn:String) :: Nil))) => hentEksemplarInfo(isbn)
    case req @ POST(Path("/eksemplar/ny")) => nyttEksemplar(req)
    case GET(Path(Seg("person" :: "hent" :: navn :: Nil))) => PersonKontroller.hentPerson(navn)
    case GET(Path(Seg("person" :: "ny" :: brukernavn :: fornavn :: etternavn :: Nil))) => PersonKontroller.leggTilPerson(brukernavn, fornavn, etternavn)
    case GET(Path("/")) => hentForside()
  }

  def hentForside() = {
    Html5(<h1>Cibrary</h1>
      <ul>
        <li><a href="/bok/list">Alle bøker</a></li>
        <li><a href="/bok/opprett">Ny bok</a></li>
      </ul>
    )
  }

  def nyBok(req : HttpRequest[HttpServletRequest]):Html5 = {
    val isbn = req.parameterValues("isbn")
    val tittel = req.parameterValues("tittel")
    bokKontroller.leggTilNyBok(tittel.head, isbn.head)
    Html5(<h2>Bok lagt til</h2>)
  }

  def nyttEksemplar(req : HttpRequest[HttpServletRequest]):Html5 = {
    val isbn = req.parameterValues("isbn")
    eksemplarKontroller.leggTilNyttEksemplar(isbn.head)
    Html5(<h2>Eksemplar lagt til</h2>)
  }

  def hentAlleBoker(): Html5 = {
    val boker = bokKontroller.hentAlleBoker()
    Html5(<html>
      <ul>
        {boker.map(bokInfo)}
      </ul>
    </html>)
  }

  def bokInfo(bok:Bok) ={
    <li>{bok.tittel} ({bok.isbn}) <a href={"/eksemplar/info/"+bok.isbn}>info</a></li>
  }

  def hentEksemplarInfo(isbn:String): Html5 = {
    val bok = bokKontroller.bokRepository.hent(isbn)

    bok match {
      case Some(bok) => {
        val boker = eksemplarKontroller.finnEksemplarerAvBok(bok)

        Html5(<html>
          <h1>{bok.tittel} ({bok.isbn})</h1>
          <h2>{boker.length} eksemplarer</h2>
          <form action="/eksemplar/ny" method="post">
            <input type="hidden" name="isbn" value={bok.isbn}></input>
            <input type="submit">+</input>
          </form>
        </html>)
      }
      case _ => {
        Html5(<h1>Boken finnes ikke</h1>)
      }
    }
  }
}