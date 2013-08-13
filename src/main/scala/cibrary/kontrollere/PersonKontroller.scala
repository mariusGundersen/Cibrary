package cibrary.kontrollere

import cibrary.repository.PersonDepotet
import cibrary.domain.{Bok, Person}
import unfiltered.response.Html5
import scala.collection.{immutable, mutable}

object PersonKontroller {
  def leggTilPerson(brukernavn:String, passord: String, fornavn:String, etternavn:String) :Html5 =  {
    val person : Option[Person] = PersonDepotet.finnVedBrukernavn(brukernavn)
    if(!person.isDefined) {
      val person:Person = new Person(brukernavn, passord, fornavn, etternavn)
      PersonDepotet.lagre(person)
    }

    return Html5(<h2>Lagret bruker med brukernavn {brukernavn}</h2>)
  }

  def finnPerson(brukernavn: String) : Html5 = {
    val person:Option[Person] = PersonDepotet.finnVedBrukernavn(brukernavn)
    if(person.isDefined) {
      return Html5(<h2>{person.get.fornavn} {person.get.etternavn}</h2>)
    } else {
      return Html5(<h2>Person ikke funnet.</h2>)
    }
  }

  def finnPersonVedBrukernavnOgPassord(brukernavn: String, passord: String) = {
    PersonDepotet.finnVedBrukernavnOgPassord(brukernavn, passord)
  }

  def hentAllePersoner():Html5 = {
    val allePersoner:Map[String, Person] = PersonDepotet.alle()
    Html5(
      <ul>
        {allePersoner.values.map(personInfo)}
      </ul>
    )

  }

  def personInfo(person:Person) = {
    <li>{person.brukernavn}: {person.etternavn}, {person.fornavn}</li>
  }
}
