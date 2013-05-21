package cibrary.domain

import org.scalatest.FunSpec

class EksemplarRepositorieTest extends FunSpec{

  describe("når man lagrer et eksemplar"){
    it("skal man kunne hente eksemplaret"){
      val bok = new Bok("test", "1234")
      val eksemplar = new Eksemplar(bok)
      EksemplarRepositorie += eksemplar
      val hentet = EksemplarRepositorie(bok);
      assert(hentet === eksemplar :: Nil)
    }
  }
  describe("når man prøver å finne et eksemplar av en bok som ikke finnes"){
    it("skal man få en tom liste"){
      val bok = new Bok("test", "1234")
      val hentet = EksemplarRepositorie(bok);
      assert(hentet === Nil)
    }
  }
}
