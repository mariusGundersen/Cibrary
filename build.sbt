name := "Cibrary"

version := "0.1"

scalaVersion := "2.9.1"

libraryDependencies += "joda-time" % "joda-time" % "2.1" withSources()

libraryDependencies += "org.joda" % "joda-convert" % "1.2" withSources() 

libraryDependencies += "net.databinder" % "unfiltered-jetty_2.9.1" % "0.6.5" withSources()

libraryDependencies += "net.databinder" % "unfiltered-filter_2.9.1" % "0.6.5" withSources()