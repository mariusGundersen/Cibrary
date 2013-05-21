package cibrary.web

object CibraryMain extends App {

	unfiltered.jetty.Http(8080).plan(new CibraryPlan).run()
	
}