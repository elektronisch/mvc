import com.google.inject.Guice
import com.tzavellas.sse.guice.ScalaModule

import play.api._
import play.api.Play.current

// todo: make DevModule inherit from ProdModule and override/manipulate a set of binds
class ProdModule extends ScalaModule {
  def configure() {
    //bind[Translator].to[FrenchTranslatorImpl]
  }
}

class DevModule extends ScalaModule {
  def configure() {
    //bind[Translator].to[FakeTranslator]
  }
}

object Global extends GlobalSettings {
  private lazy val injector = Play.isProd match {
    case true => Guice.createInjector(new ProdModule)
    case false => Guice.createInjector(new DevModule)
  }

  override def getControllerInstance[A](clazz: Class[A]) = {
    injector.getInstance(clazz)
  }

  override def onStart(app: Application) {
    super.onStart(app)
    Logger.info("Application has started")
  }

  override def onStop(app: Application) {
    super.onStop(app)
    Logger.info("Application shutdown...")
  }
}
