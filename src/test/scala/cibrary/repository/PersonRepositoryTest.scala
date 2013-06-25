package cibrary.repository

import org.scalatest.FunSpec
import cibrary.domain.Person

/**
 * Created with IntelliJ IDEA.
 * User: Peter Breunig
 * Date: 21.05.13
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 */
class PersonRepositoryTest extends FunSpec {
  describe("A PersonRepository") {
    it("should add persons to repository") {
      val person = new Person("petbre", "Peter", "Breunig")
      PersonRepository.save(person)
      val personOption: Option[Person] = PersonRepository.findByBrukernavn("petbre")
      assert(personOption.isDefined)
      assert(personOption.get == person)
    }
    it("should find persons in repository") {
      val person = new Person("petbre", "Peter", "Breunig")
      PersonRepository.save(person)
      val personOption: Option[Person] = PersonRepository.findByBrukernavn("petbre")
      assert(personOption.isDefined)
      assert(personOption.get == person)
    }
  }
}
