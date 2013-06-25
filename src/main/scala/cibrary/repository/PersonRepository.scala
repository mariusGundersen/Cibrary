package cibrary.repository

import cibrary.domain.Person
import scala.collection.mutable.Map

/**
 * Created with IntelliJ IDEA.
 * User: Peter Breunig
 * Date: 21.05.13
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
object PersonRepository {
  val personMap: Map[String, Person] = Map()

  def findByBrukernavn(brukernavn: String): Option[Person] = {
    personMap.get(brukernavn)
  }

  def save(person: Person): Person = {
    if (person != null) {
      personMap(person.brukernavn) = person
      return person
    }
    throw new NullPointerException
  }
}