package controllers

import play.api._
import play.api.mvc._
import com.google.inject._

// http://eng.42go.com/play-framework-dependency-injection-guice/


@Singleton
class Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready!!"))
  }

  def hello(name:String) = Action {
    Ok(views.html.index("Hello " + name + "!!"))
  }
}