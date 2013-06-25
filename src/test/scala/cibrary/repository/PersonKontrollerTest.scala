package cibrary.repository

import org.scalatest.FunSpec
import cibrary.kontrollere.PersonKontroller
import unfiltered.response.Html5

/**
 * Created with IntelliJ IDEA.
 * User: oyvvol
 * Date: 25.06.13
 * Time: 13:54
 * To change this template use File | Settings | File Templates.
 */
class PersonKontrollerTest extends FunSpec {
  describe("A PersonKontroller") {
    it("Should add person to repository") {
      PersonKontroller.leggTilPerson("OyvVol", "Øyvind", "Volden")
      val navn:Html5 = PersonKontroller.hentPerson("OyvVol");
      assert(navn.toString() === (Html5(<h2>Øyvind Volden</h2>).toString()))
    }
  }
}
