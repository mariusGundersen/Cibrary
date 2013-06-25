package cibrary.web

import cibrary.repository.BokRepository
import cibrary.kontrollere.{EksemplarKontroller, BokKontroller}
import cibrary.domain.EksemplarDepotet
import java.io.File
import java.net.URL

object CibraryMain extends App {

  val bokRepository = new BokRepository
  val bokKontroller = new BokKontroller(bokRepository)

  val eksemplarDepotet = new EksemplarDepotet
  val eksemplarKontroller = new EksemplarKontroller(eksemplarDepotet, bokRepository)

	val resources = new URL(new File("src/main/webapp").toURI().toURL(), ".")
  val plan = new CibraryPlan(bokKontroller, eksemplarKontroller)


	unfiltered.jetty.Http(8080)
    .context("/assets"){
      _.resources(resources)
    }
		.plan(plan)
		.run()
	
}