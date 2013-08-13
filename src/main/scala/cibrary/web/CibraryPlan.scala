package cibrary.web

import unfiltered.filter._
import unfiltered.request._
import unfiltered.response._
import cibrary.kontrollere._
import javax.servlet.http.HttpServletRequest
import cibrary.domain.Bok
import cibrary.web.templates.{PersonTemplate, BookTemplate}

class CibraryPlan(bokKontroller:BokKontroller, eksemplarKontroller: EksemplarKontroller) extends Plan{

  def intent = Intent {
    case GET(Path("/bok/opprett")) => BookTemplate.opprettBok()
    case GET(Path("/bok/list")) => hentAlleBoker()
    case req @ POST(Path("/bok/opprett")) => nyBok(req)
    case GET(Path(Seg("bok" :: (isbn:String) :: Nil))) => hentBokInfo(isbn)
    case req @ POST(Path("/eksemplar/ny")) => nyttEksemplar(req)
    case GET(Path("/person/list")) => hentAllePersoner()
    case GET(Path("/person/opprett")) => PersonTemplate.opprettPerson()
    case req @ POST (Path("/person/opprett")) => nyPerson(req)
    case GET(Path("/")) => hentForside()
    case req @ POST (Path("/")) => loggInn(req)
  }

  def loggInn(req: HttpRequest[HttpServletRequest]) :Html5 = {
    val epost = req.parameterValues("epost")
    val passord = req.parameterValues("passord")
    val loggaInn = PersonKontroller.finnPersonVedBrukernavnOgPassord(epost.head, passord.head)
    //loggaInn match {
      //case Some(status) =>
      //case _ =>   Html5(<h2>Innlogging mislyktes.</h2>)
    //}
    Html5(<h2>To be conbstructed.</h2>)
  }

  def hentLoggInnSide() = {
    BookTemplate.pønt(
      <h1>Logg Inn</h1>
      <form method="POST" class="form-horizontal">
        <div class="control-group">
          <label class="control-label" for="brukernavn">Epostadresse</label>
          <div class="controls">
            <input type="text" name="brukernavn" id="brukernavn" placeholder="Epostadresse"/>
          </div>
        </div>
        <div class="control-group">
          <label class="control-label" for="passord">Løsningsord</label>
          <div class="controls">
            <input type="text" name="passord" id="passord" placeholder="Løsningsord"/>
          </div>
        </div>
        <div class="control-group">
          <div class="controls">
            <input type="submit" class="btn" value="Logge seg inn"/>
          </div>
        </div>
      </form>
    )
  }

  def hentForside() = {
    BookTemplate.pønt(<h1>Cibrary</h1>
      <ul>
        <li><a href="/bok/list">Alle bøker</a></li>
        <li><a href="/bok/opprett">Ny bok</a></li>
        <li><a href="/person/list">Alle personer</a></li>
        <li><a href="/person/opprett">Ny person</a></li>
      </ul>, 0)
  }

  def nyBok(req : HttpRequest[HttpServletRequest]):Html5 = {
    val isbn = req.parameterValues("isbn")
    val tittel = req.parameterValues("tittel")
    bokKontroller.leggTilNyBok(tittel.head, isbn.head)
    BookTemplate.pønt(<h2>Bok lagt til</h2>, 2)
  }

  def nyttEksemplar(req : HttpRequest[HttpServletRequest]):Html5 = {
    val isbn = req.parameterValues("isbn")
    eksemplarKontroller.leggTilNyttEksemplar(isbn.head)
    BookTemplate.pønt(<h2>Eksemplar lagt til</h2>)
  }

  def nyPerson(req : HttpRequest[HttpServletRequest]):Html5 = {
    val brukernavn = req.parameterValues("brukernavn")
    val passord = req.parameterValues("passord")
    val fornavn = req.parameterValues("fornavn")
    val etternavn = req.parameterValues("etternavn")
    PersonKontroller.leggTilPerson(brukernavn.head, passord.head, fornavn.head, etternavn.head)
    Html5(<h2>Person lagt til</h2>)
  }

  def hentAllePersoner():Html5 = {
    PersonKontroller.hentAllePersoner()
  }

  def hentAlleBoker(): Html5 = {
    val boker = bokKontroller.hentAlleBoker()
    BookTemplate.pønt(
      <ul>
        {boker.map(bokInfo)}
      </ul>
      , 1)
  }

  def bokInfo(bok:Bok) = {
    <li>{bok.tittel} ({bok.isbn}) <a href={"/bok/"+bok.isbn}>info</a></li>
  }

  def hentBokInfo(isbn:String): Html5 = {
    val bok = bokKontroller.bokRepository.hent(isbn)

    bok match {
      case Some(bok) => {
        val boker = eksemplarKontroller.finnEksemplarerAvBok(bok)

        BookTemplate.pønt(
          <h1>{bok.tittel} ({bok.isbn})</h1>
          <h2>{boker.length} eksemplarer</h2>
          <form action="/eksemplar/ny" method="post">
            <input type="hidden" name="isbn" value={bok.isbn}></input>
            <input type="submit" value="+" />
          </form>
          <form action="/utlaan/opprett" method="post">
            <input type="hidden" name="isbn" value={bok.isbn}></input>
            <input type="submit" value="Lån bok" />
          </form>)
      }
      case _ => {
        BookTemplate.pønt(<h1>Boken finnes ikke</h1>)
      }
    }
  }
}