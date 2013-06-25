package cibrary.web

import cibrary.repository.BokRepository
import cibrary.kontrollere.BokKontroller
import java.io.File

object CibraryMain extends App {

  var bokRepository = new BokRepository
  var bokKontroller = new BokKontroller(bokRepository)

  var plan = new CibraryPlan(bokKontroller)

	unfiltered.jetty.Http(8080).resources(new File("src/main/webapp").toURI().toURL()).plan(plan).run()
	
}