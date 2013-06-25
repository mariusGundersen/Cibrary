package cibrary.web.templates

import unfiltered.response.Html5

object boktemplate {
    def opprettBok() : Html5 = {
      Html5(
        <html>
        <head>
          <link rel="stylesheet" href="/css/bootstrap.min.css" />
        </head>
        <body>
          <div class="container">
            <div class="hero-unit">
            <form methos="POST" class="form-horizontal">
              <div class="control-group">
                <label class="control-label" for="tittel">Tittel</label>
                <div class="controls">
                  <input type="text" id="tittel" placeholder="Tittel"/>
                </div>
                </div>
                <div class="control-group">
                  <label class="control-label" for="isbn">ISBN</label>
                  <div class="controls">
                    <input type="text" id="isbn" placeholder="ISBN"/>
                    </div>
                  </div>
                  <div class="control-group">
                    <div class="controls">
                      <button type="submit" class="btn">Lagre</button>
                    </div>
                  </div>
                </form>
              </div>
          </div>
        </body>
      </html>







      )
    }
}
