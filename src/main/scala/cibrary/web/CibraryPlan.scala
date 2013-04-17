package cibrary.web

import unfiltered.filter._
import unfiltered.request._
import unfiltered.response._

class CibraryPlan extends Plan{

	def intent = Intent {
	  case GET(Path("/")) => Html5(<h1>Cibrary</h1>)
	  case GET(Path(Seg("bok" :: "ny" :: navn :: Nil))) => Html5(<h2>{navn}</h2>)
	  case GET(_) => NotFound ~> Html5(<h2>404 - Not Found</h2>)
	}
}