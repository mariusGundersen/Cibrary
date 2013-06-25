package cibrary.domain

import org.scalatest.{BeforeAndAfter, FunSpec}

class EksemplarDepotetTest extends FunSpec with BeforeAndAfter{

  var depotet:EksemplarDepotet = _

  before {
    depotet = new EksemplarDepotet
  }


  describe("når man lagrer et eksemplar"){
    it("skal man kunne hente eksemplaret"){
      val bok = new Bok("test", "1234")
      val eksemplar = new Eksemplar(bok)
      depotet += eksemplar
      val hentet = depotet(bok);
      assert(hentet === eksemplar :: Nil)
    }
  }
  describe("når man prøver å finne et eksemplar av en bok som ikke finnes"){
    it("skal man få en tom liste"){
      val bok = new Bok("test", "1234")
      val hentet = depotet(bok);
      assert(hentet === Nil)
    }
  }
}
