package cibrary.repository

import org.scalatest.FunSpec
import cibrary.kontrollere.PersonKontroller
import unfiltered.response.Html5

class PersonKontrollerTest extends FunSpec {
  describe("A PersonKontroller") {
    it("Should add person to repository") {
      PersonKontroller.leggTilPerson("OyvVol","OyvPw", "Øyvind", "Volden")
      val navn:Html5 = PersonKontroller.finnPerson("OyvVol");
      assert(navn.toString() === (Html5(<h2>Øyvind Volden</h2>).toString()))
    }
  }
}
