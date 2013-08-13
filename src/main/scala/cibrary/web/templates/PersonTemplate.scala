package cibrary.web.templates

import unfiltered.response.Html5

/**
 * Ape
 * User: OyvVol
 * Date: 13.08.13
 * Time: 13:51
 */
object PersonTemplate {
  def opprettPerson():Html5 = {
    Html5(
      <html>
        <head>
          <link rel="stylesheet" href="/assets/css/bootstrap.min.css" />
        </head>
        <body>
          <div class="container">
            <div class="hero-unit">
              <form method="POST" class="form-horizontal">
                <div class="control-group">
                  <label class="control-label" for="brukernavn">Brukernavn</label>
                  <div class="controls">
                    <input type="text" name="brukernavn" id="brukernavn" placeholder="Brukernavn (6 bokstaver)"/>
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label" for="passord">Løsningsord</label>
                  <div class="controls">
                    <input type="text" name="passord" id="passord" placeholder="Løsningsord"/>
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label" for="fornavn">Fornavn</label>
                  <div class="controls">
                    <input type="text" name="fornavn" id="fornavn" placeholder="Fornavn (Ola)"/>
                  </div>
                </div>
                <div class="control-group">
                   <label class="control-label" for="etternavn">Etternavn</label>
                   <div class="controls">
                     <input type="text" name="etternavn" id="etternavn" placeholder="Etternavn (Nordmann)" />
                   </div>
                </div>
                <div class="control-group">
                  <div class="controls">
                    <input type="submit" class="btn" value="Lagre"/>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </body>
      </html>)
  }
}
