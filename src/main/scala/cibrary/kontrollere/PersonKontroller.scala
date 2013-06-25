package cibrary.kontrollere

import cibrary.repository.PersonRepository
import cibrary.domain.Person

/**
 * Created with IntelliJ IDEA.
 * User: oyvvol
 * Date: 25.06.13
 * Time: 13:45
 * To change this template use File | Settings | File Templates.
 */
object PersonKontroller {
  def leggTilPerson(brukernavn:String, fornavn:String, etternavn:String)  {
    val person : Option[Person] = PersonRepository.findByBrukernavn(brukernavn);
    if(!person.isDefined) {
      val person:Person = new Person(brukernavn, fornavn, etternavn);
      PersonRepository.save(person);
    }
  }

  def hentPerson(brukernavn:String) : String = {
    val person:Option[Person] = PersonRepository.findByBrukernavn(brukernavn);
    if(person.isDefined) {
      return  person.get.fornavn + " " + person.get.etternavn;
    } else {
      return "Person ikke funnet.";
    }
  }
}
