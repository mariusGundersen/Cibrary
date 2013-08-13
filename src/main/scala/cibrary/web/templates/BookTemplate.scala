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
      </form>, 2)
  }

  def pønt(innhold: NodeSeq, active: Int = -1): Html5 = {
    Html5(
      <html>
        <head>
          <link rel="stylesheet" href="/assets/css/bootstrap.min.css" />
        </head>
        <body>
          <div class="navbar">
            <div class="navbar-inner">
              <a class="brand" href="/">Cibrary</a>
              <ul class="nav">
                {activeLi(0, active, <a href="/">Home</a>)}
                {activeLi(1, active, <a href="/bok/list">Alle bøker</a>)}
                {activeLi(2, active, <a href="/bok/opprett">Ny bok</a>)}
              </ul>
            </div>
          </div>
          <div class="container">
            <div class="hero-unit">
              {innhold}
            </div>
          </div>
        </body>
      </html>
    )
  }

  def activeLi(index: Int, active: Int, innhold: NodeSeq) = {
    if(index == active){
      <li class="active">{innhold}</li>
    }else{
      <li>{innhold}</li>
    }
  }
}
