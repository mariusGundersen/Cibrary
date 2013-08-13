package cibrary.web.templates

import unfiltered.response.Html5
import scala.xml.NodeSeq

object BookTemplate {
    def opprettBok() : Html5 = {
      pønt(<form method="POST" class="form-horizontal">
        <div class="control-group">
          <label class="control-label" for="tittel">Tittel</label>
          <div class="controls">
            <input type="text" name="tittel" id="tittel" placeholder="Tittel"/>
          </div>
        </div>
        <div class="control-group">
          <label class="control-label" for="isbn">ISBN</label>
          <div class="controls">
            <input type="text" name="isbn" id="isbn" placeholder="ISBN"/>
          </div>
        </div>
        <div class="control-group">
          <div class="controls">
            <input type="submit" class="btn" value="Lagre"/>
          </div>
        </div>
      </form>)
  }

  def pønt(innhold:NodeSeq): Html5 = {
    Html5(
      <html>
        <head>
          <link rel="stylesheet" href="/assets/css/bootstrap.min.css" />
        </head>
        <body>
          <div class="container">
            <div class="hero-unit">
              {innhold}
            </div>
          </div>
        </body>
      </html>
    )
  }
}
