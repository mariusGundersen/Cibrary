package cibrary.repository

import org.scalatest.FunSpec
import cibrary.domain.Person

class PersonRepositoryTest extends FunSpec {
  describe("A PersonRepository") {
    it("should add persons to repository") {
      val person = new Person("petbre", "petPw", "Peter", "Breunig")
      PersonDepotet.lagre(person)
      val personOption: Option[Person] = PersonDepotet.finnVedBrukernavn("petbre")
      assert(personOption.isDefined)
      assert(personOption.get == person)
    }
    it("should find persons in repository") {
      val person = new Person("petbre", "petPw", "Peter", "Breunig")
      PersonDepotet.lagre(person)
      val personOption: Option[Person] = PersonDepotet.finnVedBrukernavn("petbre")
      assert(personOption.isDefined)
      assert(personOption.get == person)
    }
  }
}
