package cibrary.repository

import cibrary.domain.Person
import scala.collection.immutable.{HashMap, Map}

/**
 * Created with IntelliJ IDEA.
 * User: Peter Breunig
 * Date: 21.05.13
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
object PersonRepository {
  var personMap: Map[String, Person] = HashMap()

  def findByBrukernavn(brukernavn: String): Option[Person] = {
    personMap.get(brukernavn)
  }

  def save(person: Person): Person = {
    if (person != null) {
      personMap = personMap ++ Map(person.brukernavn -> person)
      return person
    }
    throw new NullPointerException
  }

  def all():Map[String, Person] = {
    return personMap
  }
}