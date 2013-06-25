package cibrary.web

import cibrary.repository.BokRepository
import cibrary.kontrollere.{EksemplarKontroller, BokKontroller}
import cibrary.domain.EksemplarDepotet

object CibraryMain extends App {

  val bokRepository = new BokRepository
  val bokKontroller = new BokKontroller(bokRepository)

  val eksemplarDepotet = new EksemplarDepotet
  val eksemplarKontroller = new EksemplarKontroller(eksemplarDepotet, bokRepository)

	
  val plan = new CibraryPlan(bokKontroller, eksemplarKontroller)

	unfiltered.jetty.Http(8080).plan(plan).run()
	
}