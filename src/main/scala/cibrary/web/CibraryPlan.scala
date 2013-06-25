package cibrary.web

import unfiltered.filter._
import unfiltered.request._
import unfiltered.response._
import cibrary.repository.PersonRepository

class CibraryPlan extends Plan{

	def intent = Intent {
	  case GET(Path("/")) => Html5(<h1>Cibrary</h1>)
	  case GET(Path(Seg("bok" :: "ny" :: navn :: Nil))) => Html5(<h2>{navn}</h2>)
    case GET(Path(Seg("person" :: "hent" :: navn :: Nil))) => Html5(<h2>Person: {PersonRepository.findByBrukernavn(navn)}</h2>)
    case GET(Path(Seg("person" :: "ny" :: brukernavn :: fornavn :: etternavn :: Nil))) => Html5(<h2>Lagret bruker med brukernavn {etternavn}</h2>)
	  case GET(_) => NotFound ~> Html5(<h2>404 - Not Found</h2>)
	}
}