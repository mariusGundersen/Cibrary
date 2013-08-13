package cibrary.repository

import cibrary.domain.Person
import scala.collection.immutable.{HashMap, Map}

object PersonDepotet {
  var personMap: Map[String, Person] = HashMap()

  def finnVedBrukernavn(brukernavn: String): Option[Person] = {
    personMap.get(brukernavn)
  }

  def finnVedBrukernavnOgPassord(brukernavn: String, passord: String): Option[Person] = {
    personMap.get(brukernavn).filter(_.passord == passord)
  }

  def lagre(person: Person): Person = {
    if (person != null) {
      personMap = personMap ++ Map(person.brukernavn -> person)
      return person
    }
    throw new NullPointerException
  }

  def alle():Map[String, Person] = {
    return personMap
  }
}