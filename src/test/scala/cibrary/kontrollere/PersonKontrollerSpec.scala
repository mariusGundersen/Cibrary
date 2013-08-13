package cibrary.kontrollere

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import cibrary.domain.Person

class PersonKontrollerSpec extends FunSpec with ShouldMatchers {

  val pk = PersonKontroller

  describe("hentBruker"){

    it("skal returnere None dersom bruker ikke finnes"){
      val brukernavn = "SpilleFransTrompetFisk"
      val passord = "feilPassord"
      pk.finnPersonVedBrukernavnOgPassord(brukernavn, passord) should be (None)
    }

    it("skal returnere Some dersom bruker finnes"){
      val brukernavn = "DKuberSkillzSniperDK"
      val passord = "riktigPassord"
      val fornavn = "Ken Remi"
      val etternavn = "Bottolfsen"
      pk.leggTilPerson(brukernavn, passord, fornavn, etternavn)
      pk.finnPersonVedBrukernavnOgPassord(brukernavn, passord) should be (Some(Person(brukernavn, passord, fornavn, etternavn)))
    }
  }
}
