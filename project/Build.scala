import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "mvc"
  val appVersion      = "1.0-SNAPSHOT"

  resolvers += "Scala-Tools" at "https://oss.sonatype.org/content/groups/scala-tools/"

  val appDependencies = Seq(
    // Add your project dependencies here,
    //jdbc,
    //anorm,
    "com.google.guava" % "guava" % "14.0.1",
    "com.google.inject" % "guice" % "3.0",
    "com.tzavellas" % "sse-guice" % "0.7.1"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
