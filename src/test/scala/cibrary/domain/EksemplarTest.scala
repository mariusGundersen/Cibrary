package cibrary.domain


class EksemplarTest extends org.scalatest.FunSpec {

  describe("Når man lager et eksemplar") {
    it("skal ha en referanse til en bok"){
      val bok = new Bok("blabla", "1234")
      new Eksemplar(bok).bok === bok
    }
  }
}
