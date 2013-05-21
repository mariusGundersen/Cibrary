package cibrary.web

import cibrary.repository.BokRepository
import cibrary.kontrollere.BokKontroller

object CibraryMain extends App {

  var bokRepository = new BokRepository
  var bokKontroller = new BokKontroller(bokRepository)

  var plan = new CibraryPlan(bokKontroller)

	unfiltered.jetty.Http(8080).plan(new CibraryPlan(bokKontroller)).run()
	
}