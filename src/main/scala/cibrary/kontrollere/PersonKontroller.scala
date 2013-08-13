package cibrary.kontrollere

import cibrary.repository.PersonRepository
import cibrary.domain.{Bok, Person}
import unfiltered.response.Html5
import scala.collection.{immutable, mutable}

/**
 * Created with IntelliJ IDEA.
 * User: oyvvol
 * Date: 25.06.13
 * Time: 13:45
 * To change this template use File | Settings | File Templates.
 */
object PersonKontroller {
  def leggTilPerson(brukernavn:String, fornavn:String, etternavn:String) :Html5 =  {
    val person : Option[Person] = PersonRepository.findByBrukernavn(brukernavn);
    if(!person.isDefined) {
      val person:Person = new Person(brukernavn, fornavn, etternavn);
      PersonRepository.save(person);
    }

    return Html5(<h2>Lagret bruker med brukernavn {brukernavn}</h2>);
  }

  def hentPerson(brukernavn:String) : Html5 = {
    val person:Option[Person] = PersonRepository.findByBrukernavn(brukernavn);
    if(person.isDefined) {
      return Html5(<h2>{person.get.fornavn} {person.get.etternavn}</h2>)
    } else {
      return Html5(<h2>Person ikke funnet.</h2>)
    }
  }

  def hentAllePersoner():Html5 = {
    val allePersoner:Map[String, Person] = PersonRepository.all();
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
