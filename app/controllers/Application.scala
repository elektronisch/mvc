package controllers

import play.api.mvc._
import com.google.inject._
import play.libs.Json
import org.codehaus.jackson.JsonNode
import models.Employee
import java.util

// http://eng.42go.com/play-framework-dependency-injection-guice/
@Singleton
class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready!!"))
  }

  /**
   * Sample of reverse route and route with parameter
   * @param name
   * @return
   */
  def hello(name:String) = Action {
    request =>
    Ok("Hello " + name + "! from " + routes.Application.hello(name))
  }

  /**
   * Sample generation of json
   * @return
   */
  def json() = Action {
    val employees = new util.ArrayList[Employee]
    employees.add(new Employee { FirstName = "Sam"; LastName = "Mueller" })
    employees.add(new Employee { FirstName = "Shawn"; LastName = "Dumas" })
    employees.add(new Employee { FirstName = "Ivan"; LastName = "Velkov" })
    employees.add(new Employee { FirstName = "Jason"; LastName = "Mitchell" })

    val jsonString: JsonNode = Json.toJson(employees)
    Ok(Json.stringify(jsonString))
  }
}
